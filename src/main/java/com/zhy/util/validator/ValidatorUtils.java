package com.zhy.util.validator;

import com.zhy.util.resource.ResourceReadUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.security.cert.CertPathValidatorResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 验证表单提交工具类
 * @author zhy
 */
public class ValidatorUtils {

    /**
     * 实现提交参数的验证，使用指定Action的验证规则处理
     * @param request
     * @param handlerMethod
     * @return 所有的验证错误信息保存在Map集合中返回，如果么有错误，map的成都
     */
     public static Map<String, String> validate(HttpServletRequest request, HandlerMethod handlerMethod) {

         // 保存所有的验证信息
         Map<String, String> errors = new HashMap<String, String>();

         // EmpAction.info.rules==empo:int|ename:string|sal:double|hirdate:date

         // 通过给定的Action名称以及要调用的业务方法“rules”一起拼凑出要去取出的验证规则，在validations.properties定义
         String validationKey = handlerMethod.getBean().getClass().getSimpleName() + "." + handlerMethod.getMethod().getName() + ".rules";

         //现在取得了验证的规则key的信息之后实际上并无法知道该key对应的具体的内容是什么，而内容需要依靠Abstraction.getValues()取得
//         Method getValuesMethod = handlerMethod.getBean().getClass().getMethod("getValue", String.class, Object[].class);
         // 如果现在没有指定的key有可能产生异常，就认为现在没有具体的验证规则出现

         // 通过getValues()方法的对象取得对应的验证信息
//         String validationValue = (String) getValuesMethod.invoke(handlerMethod.getBean(), validationKey, null);
         // 现在有ResourceReadUtil文件读取类进行上面的处理
         String validationValue = ResourceReadUtil.getValue(handlerMethod, validationKey);

         if (validationValue != null) {
             System.out.println("preHandle:validationValue = " + validationValue );
             // 按照"|"拆分
             String result[] = validationValue.split("\\|");
             // 每一个规则的组成"参数名字：规则类型"
             for (int i = 0; i < result.length; i++) {
                 String temp[] = result[i].split(":");
                 String paramName = temp[0];
                 String paramRule = temp[1];
                 String paramValue = request.getParameter(paramName);
                 System.out.println("提交参数" + paramName + ":" + request.getParameter(paramName));
                 switch (paramRule) {
                     case "string": {
                         // 验证没有通过
                         if (!ValidateRuleUtil.isString(paramValue)) {
//                             String msg = (String) getValuesMethod.invoke(handlerMethod.getBean(), "validation.string.msg", null);
                             String msg = ResourceReadUtil.getValue(handlerMethod, "validation.string.msg");
                             errors.put(paramName, msg);
                         }
                         break;
                     }
                     case "int": {
                         if (!ValidateRuleUtil.isInt(paramValue)) {
//                             String msg = (String) getValuesMethod.invoke(handlerMethod.getBean(), "validation.int.msg", null);
                             String msg = ResourceReadUtil.getValue(handlerMethod, "validation.int.msg");
                             errors.put(paramName, msg);
                         }
                         break;
                     }
                     case "double": {
                         if (!ValidateRuleUtil.isDouble(paramValue)) {
//                             String msg = (String) getValuesMethod.invoke(handlerMethod.getBean(), "validation.double.msg", null);
                             String msg = ResourceReadUtil.getValue(handlerMethod, "validation.double.msg");
                             errors.put(paramName, msg);
                         }
                         break;
                     }
                     case "date": {

                         if (!ValidateRuleUtil.isDate(paramValue)) {
//                             String msg = (String) getValuesMethod.invoke(handlerMethod.getBean(), "validation.date.msg", null);
                             String msg = ResourceReadUtil.getValue(handlerMethod, "validation.date.msg");
                             errors.put(paramName, msg);
                         }
                         break;
                     }
                     case "datetime": {
                         if (!ValidateRuleUtil.isDatetime(paramValue)) {
//                             String msg = (String) getValuesMethod.invoke(handlerMethod.getBean(), "validation.datetime.msg", null);
                             String msg = ResourceReadUtil.getValue(handlerMethod, "validation.datetime.msg");
                             errors.put(paramName, msg);
                         }
                         break;
                     }

                     case "rand": {
                         if (!ValidateRuleUtil.isRand(request, paramValue)) {
//                             String msg = (String) getValuesMethod.invoke(handlerMethod.getBean(), "validation.rand.msg", null);
                             String msg = ResourceReadUtil.getValue(handlerMethod, "validation.rand.msg");
                             errors.put(paramName, msg);
                         }
                         break;
                     }
                 }
             }
         }



         if (errors.size() == 0) {
             // 之前没有错误信息，现在表示我可以对上传文件的类型进行验证
             // 需要判断是否当前有上传文件
             // 通过他来判断对于文件上传的接受操作
             MultipartResolver mr = new CommonsMultipartResolver();
             if (mr.isMultipart(request)) {
                 // 需要拼凑验证规则的消息
                 String mimeKey = handlerMethod.getBean().getClass().getSimpleName() + "." + handlerMethod.getMethod().getName() + ".mime.rules";
                 // 取得具体的验证规则的消息
                 String mimeValue = ResourceReadUtil.getValue(handlerMethod, mimeKey);
                 if (mimeValue == null) {
                     // 没有消息读到，没有设置单独的验证规则
                     mimeValue = ResourceReadUtil.getValue(handlerMethod, "mime.rules");
                 }
                 // 进行每一个上传文件的具体验证操作
                 // 因为是一组规则，所以需要拆分
                 String mimeResult[] = mimeValue.split("\\|");
                 MultipartRequest multipartRequest = (MultipartRequest) request;
                 // 处理上传时的request
                 // 取得全部的上传文件
                 Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();

                 if (fileMap.size() > 0) {
                     // 现在有上传文件
                     // 需要判断每一个文件的类型
                     Iterator<Map.Entry<String, MultipartFile>> iter = fileMap.entrySet().iterator();
                     while (iter.hasNext()) {
                         // 判断每一个文件的类型
                         Map.Entry<String, MultipartFile> me = iter.next();
                         if (me.getValue().getSize() > 0) {
                             // 当前的这个上传文件的长度大于0，有上传
                             if (!ValidateRuleUtil.isMime(mimeResult, me.getValue().getContentType())) {
                                 // 没有验证通过
                                 errors.put("file", ResourceReadUtil.getValue(handlerMethod, "validation.mime.msg"));
                             }
                         }
                     }
                 }
             }
         }
        return errors;
     }
}
