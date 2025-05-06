package com.xinyi.utils.file.io;

import java.io.*;

/**
 * 文件IO工具类，提供将输入流写入文件的方法
 *
 * @author 杨耿雷
 * @since 2025/3/17 10:51
 */
public final class FileIOUtil {

    private FileIOUtil() { }

    /**
     * 将输入流写入文件（不追加）
     *
     * @param filePath 文件路径
     * @param is 输入流
     * @return true: 写入成功；false: 写入失败
     */
    public static boolean writeFileFromIS(String filePath, InputStream is) throws IOException {
        return writeFileFromIS(FileUtil.getFileByPath(filePath), is, false);
    }

    /**
     * 将输入流写入文件
     *
     * @param filePath 文件路径
     * @param is 输入流
     * @param append 是否追加到文件末尾
     * @return true: 写入成功；false: 写入失败
     */
    public static boolean writeFileFromIS(String filePath, InputStream is, boolean append) throws IOException {
        return writeFileFromIS(FileUtil.getFileByPath(filePath), is, append);
    }

    /**
     * 将输入流写入文件（不追加）
     *
     * @param file 文件对象
     * @param is 输入流
     * @return true: 写入成功；false: 写入失败
     */
    public static boolean writeFileFromIS(File file, InputStream is) throws IOException {
        return writeFileFromIS(file, is, false);
    }

    /**
     * 将输入流写入文件
     *
     * @param file 文件对象
     * @param is 输入流
     * @param append 是否追加到文件末尾
     * @return true: 写入成功；false: 写入失败
     */
    public static boolean writeFileFromIS(File file, InputStream is, boolean append) throws IOException {
        if (!FileOperation.createOrExistsFile(file) || is == null) {
            return false;
        }
        OutputStream os = null;
        try {
            os = new BufferedOutputStream(new FileOutputStream(file, append));
            byte[] data = new byte[1024];
            int len;
            while ((len = is.read(data)) != -1) {
                os.write(data, 0, len);
            }
            return true;
        } finally {
            is.close();
            if (os != null) {
                os.close();
            }
        }
    }
}