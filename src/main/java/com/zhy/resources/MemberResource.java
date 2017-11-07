package com.zhy.resources;

import com.zhy.vo.Member;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("/member")
public class MemberResource {
    @Path("/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Member get() {
        Member vo = new Member();
        vo.setMid(10);
        vo.setSalary(1.1);
        vo.setName("zhy");
        vo.setHirdate(new Date());
        return vo;
    }

}
