package com.zhy.util.file;

import sun.plugin.util.UIUtil;

import java.io.*;
import java.util.UUID;

/**
 * 进行文件的保存处理
 * @author zhy
 */
public class UploadFileUtil {

    /**
     * 创建要保存的名称
     * @param mime
     * @return
     */
    public static String createFileName(String mime) {
        // 需要创建一个文件名称
        String fileName = UUID.randomUUID() + "." + mime.split("/")[1];
        return fileName;
    }
    /**
     * 进行文件的保存操作
     * @param inputStream 上传的原始文件数据输入流
     * @param destFile 要保存的目标文件路径
     * @return 保存成功返回true，否则返回false
     */
    public static boolean save(InputStream inputStream, File destFile) {
        boolean flag = false;
        OutputStream outputStream = null;
        // 父路径不存在
        if (!destFile.getParentFile().exists()) {
            // 创建父路径
            destFile.getParentFile().mkdir();
        }
        try {
            outputStream = new FileOutputStream(destFile);
            // 每块数据的保存大小
            byte data[] = new byte[2048];
            int temp = 0;
            // 保存每次的个数
            while ((temp = inputStream.read(data)) != -1) {
                outputStream.write(data, 0, temp);
            }
            flag = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
