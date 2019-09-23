package com.szp.o2o.service.impl;

import com.szp.o2o.dao.ShopCategoryDao;
import com.szp.o2o.entity.ShopCategory;
import com.szp.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//这个就告诉spring这是一个service层的类，同时这是托管在spring容器里面的，在用的时候给我创建出来，注入到我需要用的地方去
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    //service层是依赖于DAO层的，所以要把shopCategoryDao作为它的成员变量注入进来使用
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
        return shopCategoryDao.queryShopCategory(shopCategoryCondition);
    }
}
