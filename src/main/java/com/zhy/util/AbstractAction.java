package com.zhy.util;

import org.springframework.context.MessageSource;

import javax.annotation.Resource;
import java.util.Locale;

public abstract class AbstractAction {

    // 表示此对象直接饮用配置好的类对象(根据类型匹配)
    @Resource
    private MessageSource messageSource;

    /**
     * 根据指定的key的信息进行资源数据的读取控制
     * @param msgKey 表示要读取的资源文件的key的内容
     * @param args 占位符
     * @return 表示资源对应的内容
     */
    public String getValue(String msgKey, Object ...args) {
        return this.messageSource.getMessage(msgKey, args, Locale.getDefault());
    }
    //todo 公共的配置 如日期转化

}
