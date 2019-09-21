package com.szp.o2o.service;

import com.szp.o2o.BaseTest;
import com.szp.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class AreaServiceTest extends BaseTest {

    @Autowired//一旦AreaServiceTest用到了areaService，在运行的时候，spring就会往里面注入他的实现类
    private AreaService areaService;

    @Test
    public void testGetAreaList(){
        List<Area> areaList = areaService.getAreaList();
        assertEquals("德新街",areaList.get(0).getAreaName());
    }
}
