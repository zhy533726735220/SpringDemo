package com.zhy.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 当前的这个程序属于SpringMvc中的一个控制器
@Controller
// 只要以"/pages/emp开头就表示访问次Action"
@RequestMapping("/pages/emp/*")
public class EmpAction {
    // 进行消息的接收
    @RequestMapping("echo")
    public ModelAndView echo(String msg) {
        System.out.println(msg);
        return null;
    }
}
