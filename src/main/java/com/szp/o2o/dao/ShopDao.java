package com.szp.o2o.dao;

import com.szp.o2o.entity.Shop;

//新增店铺
public interface ShopDao {
    //新增店铺
    int insertShop(Shop shop);

    //更新店铺信息
    int updateShop(Shop shop);

}
