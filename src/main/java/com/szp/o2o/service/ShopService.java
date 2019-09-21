package com.szp.o2o.service;

import com.szp.o2o.dto.ShopExecution;
import com.szp.o2o.entity.Shop;
import com.szp.o2o.exceptions.ShopOperationException;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;

public interface ShopService {

    @Transactional
    //事务支持
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName)throws ShopOperationException;

}
