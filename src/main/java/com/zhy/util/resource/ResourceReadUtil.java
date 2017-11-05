package com.zhy.util.resource;

import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;

/**
 * @author 消息读取类
 */
public class ResourceReadUtil {

    /**
     * 实现消息的手工配置读取
     * @param handlerMethod
     * @param msgKey
     * @return
     */
    public static String getValue(HandlerMethod handlerMethod, String msgKey) {
        try {
            Method getValuesMethod = handlerMethod.getBean().getClass().getMethod("getValue", String.class, Object[].class);
            return (String) getValuesMethod.invoke(handlerMethod.getBean(), msgKey, null);

        } catch (Exception e) {
            return null;
        }

    }

    /**
     * 读取错误页的配置消息
     * @param handlerMethod
     * @return
     */
    public static String getErrorPageValue(HandlerMethod handlerMethod) {
        String pageKey = handlerMethod.getBean().getClass().getSimpleName() + "." + handlerMethod.getMethod().getName() + ".error.page";
        String pageUrl = getValue(handlerMethod, pageKey);
        if (pageUrl == null) {
            pageUrl = getValue(handlerMethod, "error.page");
        }
        return pageUrl;
    }


}
