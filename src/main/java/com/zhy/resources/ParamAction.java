package com.zhy.resources;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;


@Component
// 描述的是本类不属于单利设计
@Scope("prototype")
@Path("/myparam")
public class ParamAction {
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/query")
//    public String getQuery(@QueryParam("msg") String msg) {
//        return "echo:" + msg;
//    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/query")
    public String getQuery(@FormParam("msg") String msg) {
        return "echo:" + msg;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{mych}")
    public String echo(@PathParam("mych") String msg) {
        return "ECHO:" + msg;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/query/{condition}")
    public String echo(@PathParam("condition") PathSegment cond) {
        // 取得所有的参数
        MultivaluedMap<String, String> map = cond.getMatrixParameters();
        return "ECHO:" + map;
    }
}
