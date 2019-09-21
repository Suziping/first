package com.szp.o2o.web.superadmin;

import com.szp.o2o.entity.Area;
import com.szp.o2o.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/superadmin")
public class AreaController {

    Logger logger = LoggerFactory.getLogger(AreaController.class);

    @Autowired//它会在我们的程序需要用的service的时候把它的实现类注入进来
    private AreaService areaService;

    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    @ResponseBody//将我们的返回值ModelMap自动转换成json对象返回给前端
    private Map<String,Object> listArea(){
        //程序通常使用info来记录程序的启动和结束
        logger.info("===start===");
        //获取当前时间的毫秒数
        long startTime = System.currentTimeMillis();
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Area> list = new ArrayList<Area>();

        try {
            list = areaService.getAreaList();
            //如果正确就把结果返回
            modelMap.put("rows",list);
            modelMap.put("total",list.size());
        }catch (Exception e){
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errMsg",e.toString());
        }
        logger.error("test error!");
        //获取当前时间的毫秒数
        long endTime = System.currentTimeMillis();
        //debug用来调优，调优涉及到时间
        logger.debug("costTime:[{}ms]",endTime - startTime);
        logger.info("===end===");
        return modelMap;
    }
}
