package com.zhy.util;

import com.zhy.util.file.UploadFileUtil;
import org.springframework.context.MessageSource;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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

    /**
     * 生成图片名称
     * @param photo
     * @return
     */
    public String createFileName(MultipartFile photo) {
        if (photo.isEmpty()) {
            // 没有文件上传
            // 默认自己生成一个文件
            return "nophoto.png";
        } else {
            // 需要自己生成一个文件
            return UploadFileUtil.createFileName(photo.getContentType());
        }
    }

    /**
     * 进行文件的保存处理
     * @param photo
     */
    public boolean saveFile(MultipartFile photo, String fileName, HttpServletRequest request) {
        if (!photo.isEmpty()) {
            String filePath = request.getServletContext().getRealPath(this.getFileUploadDir()) + fileName;
            System.out.println(filePath);
            try {
                return UploadFileUtil.save(photo.getInputStream(), new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 保存上传文件的路径
     * @return
     */
    public abstract String getFileUploadDir();

    //todo 公共的配置 如日期转化

}
