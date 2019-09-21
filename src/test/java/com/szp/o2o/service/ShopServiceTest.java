package com.szp.o2o.service;

import com.szp.o2o.BaseTest;
import com.szp.o2o.dto.ShopExecution;
import com.szp.o2o.entity.Area;
import com.szp.o2o.entity.PersonInfo;
import com.szp.o2o.entity.Shop;
import com.szp.o2o.entity.ShopCategory;
import com.szp.o2o.enums.ShopStateEnum;
import com.szp.o2o.exceptions.ShopOperationException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {

    //如果这里显示没有shopService这个接口的注入，那么问题应该是出在在实现类里面没有进行@Service注解，没有让spring进行管理
    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop() throws FileNotFoundException, ShopOperationException {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setArea(area);
        shop.setOwner(owner);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺3");
        shop.setShopAddr("test3");
        shop.setPhone("2351349371");
        shop.setShopDesc("test3");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("D:\\image\\1.jpg");
        InputStream is  = new FileInputStream(shopImg);
        ShopExecution se = shopService.addShop(shop,is,shopImg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
    }
}
