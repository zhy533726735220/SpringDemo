package com.zhy.action;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zhy.util.AbstractAction;
import com.zhy.vo.VoTest;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// 当前的这个程序属于SpringMvc中的一个控制器
@Controller
// 只要以"/pages/emp开头就表示访问次Action"
@RequestMapping("/pages/emp/*")
public class EmpAction extends AbstractAction{

    @InitBinder
    // 方法名称自己随便写
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 本方法的处理指的是追加有一个自定义的转换编译器，如果遇见的操作目标类行为java.util.Date类，则使用定义好的SimpleDateFormate类
        // 来进行格式处理，并且允许参数的内容为空
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
    }
    // 进行消息的接收
    @RequestMapping("echo")
    // 进行消息的接收，msg就表示参数
    public ModelAndView echo(@RequestParam(defaultValue = "nihao") String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("allEmp", new ArrayList<String>());
        map.put("empCount", 1000);

        ModelAndView view = new ModelAndView("show");
        view.addAllObjects(map);
        view.addObject("info", msg);
        System.out.println(msg);
        // 表示现在不进行跳转，如果使用Ajax连接，才需要使用这个返回方式
        return view;
    }

    // 此时vo作为一个参数，并且没有实例化
    @RequestMapping("add")
//     表单文件选择框的参数名称必须是photo
    public ModelAndView add(VoTest vo, MultipartFile photo, HttpServletRequest request) {
        System.out.println(vo);
        if (photo != null) {
            System.out.println("文件原始名称:" + photo.getOriginalFilename());
            System.out.println("文件是否上传:" + photo.isEmpty());
            System.out.println("文件大小:" + photo.getSize());
            System.out.println("文件类型:" + photo.getContentType());
            String fileName = super.createFileName(photo);
            System.out.println("上传结果:" + super.saveFile(photo, fileName, request));
        }
        return null;
    }

    @RequestMapping("info")
    public ModelAndView info() {
//        System.out.println(super.getValue("vo.edit.msg", "haha"));
//        System.out.println(super.getValue("emp.add.page"));
//        System.out.println(super.getValue("emp.add.rules"));
//        System.out.println();
        return null;
    }

    public String getFileUploadDir() {
        return "/upload/emp/";
    }
}
