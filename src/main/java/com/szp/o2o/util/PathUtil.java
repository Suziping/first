package com.szp.o2o.util;

public class PathUtil {
    //获取文件的分隔符
    private static String seperator = System.getProperty("file.separator");

    //根据业务需求，返回项目的根路径,即项目的所有图片存放的路径
    public static String getImgBasePath(){

        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")){
            basePath = "D:/image/";
        }else {
            //其他系统的存储路径例如Linux
            basePath = "/home/szp/image/";
        }
        //获取文件的分隔符然后进行替换
        basePath = basePath.replace("/",seperator);
        return basePath;
    }

    //根据不同的业务需求，返回项目的子路径，在image的基础上的一层子路径，店铺图片的存储路径
    public static String getShopImagePath(long shopId){
        String imagePath = "upload/item/shop/"+ shopId + "/";
        return imagePath.replace("/",seperator);
    }
}
