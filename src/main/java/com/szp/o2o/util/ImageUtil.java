package com.szp.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {

    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    static{
        try {
            basePath = URLDecoder.decode(basePath,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }//这样就能解决掉那个空格的问题了。

    //定义时间格式
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    //随机数对象
    private static final Random r = new Random();

    public static String generateThumbnail(InputStream thumbnailInputStream, String fileName,String targetAddr) {
        //获取文件随机名
        String realFileName = getRandomFileName();
        //获取拓展名
        String extension = getFileExtension(fileName);
        //文件就是存储在targetAddr
        makeDirPath(targetAddr);
        //获取相对路径
        String relativeAddr = targetAddr + realFileName + extension;
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        //创建缩略图
        try {
            Thumbnails.of(thumbnailInputStream).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "weixin.png")),0.25f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("创建缩略图失败：" + e.toString());
        }
        return relativeAddr;
    }

    /*
     * 创建目标路径所涉及的目录，到时所创建的目录的相应文件夹都会自动创建
     * */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /*
     * 获取输入文件流的拓展名
     * */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /*
     *  生成随机文件名，当前年月日小时分钟秒数+五位随机数
     *
     */
    public static String getRandomFileName() {
        //获取随机的五位数
        int rannum = r.nextInt(89999)+10000;
        String nowTimeStr =sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }
}
