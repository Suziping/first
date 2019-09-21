package com.szp.o2o.dto;

import com.szp.o2o.entity.Shop;
import com.szp.o2o.enums.ShopStateEnum;

import java.util.List;

/*
 * 定义存储店铺的信息，和店铺的状态值
 * */
public class ShopExecution  {
    //结果状态
    private int state;

    //状态标识,定义状态标识是为了以文字的形式表达结果状态
    private String stateInfo;

    //店铺数量
    private int count;

    //操作的shop（增删改查的时候用到）
    private Shop shop;

    //shop列表（供查询店铺列表的时候使用)
    private List<Shop> shopList;

    //
    public ShopExecution(){

    }

    //店铺操作失败的时候使用的构造器
    public ShopExecution(ShopStateEnum stateEnum){
        //获取整形的状态值
        this.state = stateEnum.getState();
        //获取字符型的对状态值得说明
        this.stateInfo = stateEnum.getStateInfo();
    }

    //店铺操作成功的时候使用的构造器
    public ShopExecution(ShopStateEnum stateEnum,Shop shop){
        //获取整形的状态值
        this.state = stateEnum.getState();
        //获取字符型的对状态值得说明
        this.stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }

    //店铺操作成功的时候使用的构造器
    public ShopExecution(ShopStateEnum stateEnum,List<Shop> shopList){
        //获取整形的状态值
        this.state = stateEnum.getState();
        //获取字符型的对状态值得说明
        this.stateInfo = stateEnum.getStateInfo();
        this.shopList = shopList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
