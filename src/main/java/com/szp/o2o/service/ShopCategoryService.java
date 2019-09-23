package com.szp.o2o.service;

import com.szp.o2o.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryService {

    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
    //编写完接口去编写它的实现类
}
