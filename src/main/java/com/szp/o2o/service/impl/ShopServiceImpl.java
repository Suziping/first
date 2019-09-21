package com.szp.o2o.service.impl;

import com.szp.o2o.dao.ShopDao;
import com.szp.o2o.dto.ShopExecution;
import com.szp.o2o.entity.Shop;
import com.szp.o2o.enums.ShopStateEnum;
import com.szp.o2o.exceptions.ShopOperationException;
import com.szp.o2o.service.ShopService;
import com.szp.o2o.util.ImageUtil;
import com.szp.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;

/*
* 这是一个实现类，实现的是ShopService接口
* */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional//事务支持
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws RuntimeException{
        //先检查传入的参数是否合法,空置判断
        if (shop == null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }try {
                //给店铺信息赋初始值，配置默认信息
                shop.setEnableStatus(0);
                shop.setCreateTime(new Date());
                shop.setLastEditTime(new Date());
                //添加店铺信息
                int effectedNum = shopDao.insertShop(shop);
                if (effectedNum <= 0){
                    throw new ShopOperationException("店铺创建失败");
                }else {
                    if (shopImgInputStream != null){
                        //存储图片
                        try {
                            addShopImg(shop,shopImgInputStream,fileName);
                        }catch (Exception e){
                            throw new RuntimeException("addShopImg error:" + e.getMessage());
                        }
                        //更新店铺的图片地址
                        effectedNum = shopDao.updateShop(shop);
                        if (effectedNum <= 0){
                            throw new RuntimeException("更新图片地址失败");
                        }
                    }
                }
        }catch (Exception e){
            throw new RuntimeException("addShop error:" + e.getMessage());
        }

        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {
        //获取shop图片目录的相对值路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream,fileName,dest);
        shop.setShopImg(shopImgAddr);
    }

}
