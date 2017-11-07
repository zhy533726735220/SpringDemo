package com.zhy.resources;

import javax.enterprise.inject.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

// 表示此WEB服务访问路径

@Path("/info")
public class HelloResource {
    // 针对于GET请求处理
    @GET
    // 返回的类型为普通的文本类型
//    @Produces(MediaType.TEXT_PLAIN)
    public String info() {
        return "hello";
    }
}
