package com.szp.o2o.util;

import javax.servlet.http.HttpServletRequest;

//负责处理HttpServletRequest参数
public class HttpServletRequestUtil {
    //把传过来的键值对key转化成int整形参数
    public static int getInt(HttpServletRequest request,String key){
        try{
            return Integer.decode(request.getParameter(key));
        }catch (Exception e){
            return -1;
        }
    }

    //把传过来的键值对key转化成长整形参数
    public static long getLong(HttpServletRequest request, String key){
        try{
            return Long.valueOf(request.getParameter(key));
        }catch (Exception e){
            return -1;
        }
    }

    //把传过来的键值对key转化成double参数
    public static double getDouble(HttpServletRequest request, String key){
        try{
            return Double.valueOf(request.getParameter(key));
        }catch (Exception e){
            return -1d;
        }
    }

    //把传过来的键值对key转化成boolean参数
    public static Boolean getBoolean(HttpServletRequest request, String key){
        try{
            return Boolean.valueOf(request.getParameter(key));
        }catch (Exception e){
            return false;
        }
    }

    //把传过来的键值对key转化成boolean参数
    public static String getString(HttpServletRequest request, String key){
        try{
            String result = request.getParameter(key);
            if (request != null){
                result = result.trim();
            }
            if ("".equals(result)){
                result = null;
            }
            return result;
        }catch (Exception e){
            return null;
        }
    }




}
