package com.zhy.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.zhy.util.SplitPageUtil;
import com.zhy.vo.Member;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

import java.util.*;

@Controller
public class MemberAction {

    @InitBinder
    // 方法名称自己随便写
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 本方法的处理指的是追加有一个自定义的转换编译器，如果遇见的操作目标类行为java.util.Date类，则使用定义好的SimpleDateFormate类
        // 来进行格式处理，并且允许参数的内容为空
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
    }


    // 定义该方法的访问路径，而后表示该方法返回的数据类型为普通的文本类型，即MIME
    @RequestMapping(value = "/info", produces = "text/plain;charset=UTF-8")
    //该方法的返回值即回应的主题消息
    public @ResponseBody  String info() {
        return "www.baidu.com";
    }

    @RequestMapping(value = "/echo/{msgParam}", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String echo(@PathVariable("msgParam") String msg) {
        return "Echo:" + msg;
     }

    @RequestMapping(value = "/member", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody Object add(Member vo) {
        System.out.println(vo);
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("flag", true);
        JSONObject itemJSONObj = JSONObject.parseObject(JSON.toJSONString(map));
        return itemJSONObj;
    }

    @RequestMapping(value = "/member", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public @ResponseBody Object edit(Member vo) {
        System.out.println(vo);
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("flag", true);
        JSONObject itemJSONObj = JSONObject.parseObject(JSON.toJSONString(map));
        return itemJSONObj;
    }

    @RequestMapping(value = "/member/{mid:\\d+}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public @ResponseBody Object remove(@PathVariable int mid) {
        System.out.println(mid);
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("flag", true);
        JSONObject itemJSONObj = JSONObject.parseObject(JSON.toJSONString(map));
        return itemJSONObj;
    }

    @RequestMapping(value = "/member/{mid:\\d+}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody Object get(@PathVariable int mid) {
        System.out.println(mid);
        Member vo = new Member();
        vo.setMid(mid);
        vo.setName("zhy");
        vo.setSalary(1000.00);
        vo.setHirdate(new Date());

        return vo;
    }

    @RequestMapping(value = "/member/{condition}", method = RequestMethod.PATCH, produces = "application/json;charset=UTF-8")
    public @ResponseBody Object list(@PathVariable("condition") String condition, SplitPageUtil splitPageUtil) {
        System.out.println("当前查询：" + condition);
        List<Member> all = new ArrayList<>();
        for (int i = (splitPageUtil.getCurrentpage() - 1) * splitPageUtil.getLineSize(); i < splitPageUtil.getCurrentpage() * splitPageUtil.getLineSize(); i++) {
            Member vo = new Member();
            vo.setMid(i);
            vo.setName("姓名zhy：" + i);
            vo.setSalary(10000.0 + i);
            all.add(vo);
        }
        Map<String, Object> result = new HashMap<>();
        result.put("memberCount", 400);
        result.put("allMembers", all);
        result.put("condition", condition);
        // 下次可能继续使用

        JSONObject itemJSONObj = JSONObject.parseObject(JSON.toJSONString(result));
        return itemJSONObj;
    }

}
