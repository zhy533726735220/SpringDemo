
package com.zhy.util.validate;

import com.zhy.util.resource.ResourceReadUtil;
import com.zhy.util.validator.ValidatorUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Spring 拦截器
 * @author zhy
 */
public class ValidationInterceptor implements HandlerInterceptor{
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 默认放行
        boolean flag = true;

        // 需要取得HandlerMethod对象，这样可以取得相关的Action信息
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        // 表示具体的验证信息，所有的错误信息通过Map返回
        Map<String, String> errors = ValidatorUtils.validate(request, handlerMethod);

        if (errors.size() > 0) {
            // 表示出现了错误
            // 保存在Request属性范围之中
            request.setAttribute("errors", errors);
            // 表示现在有错误，无法向下执行
            flag = false;
            // todo 没看懂下面的代码
            request.getRequestDispatcher(ResourceReadUtil.getErrorPageValue(handlerMethod)).forward(request, response);
        } else {
            flag = true;
        }


        System.out.println("preHandle:" +  handler.getClass());
        System.out.println("preHandle: beanName = " +  handlerMethod.getBean().getClass().getSimpleName() + ",methodName:" + handlerMethod.getMethod().getName());
        return flag;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle:" + handler.getClass() + "modelAndView" + modelAndView);
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion" + handler.getClass());
    }
}
