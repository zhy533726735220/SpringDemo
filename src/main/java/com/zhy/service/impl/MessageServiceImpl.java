package com.zhy.service.impl;


import com.zhy.service.IMessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements IMessageService {

    public boolean remove(String mid) {
        System.out.println("业务层执行删除调用，删除的数据id:" + mid);
        return false;
    }
}
