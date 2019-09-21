package com.szp.o2o.enums;
/*
 * 构造器为什么设置成私有化，因为不希望第三方程序程序外面去改变这些值，只能通过内部构造器来改变
 * ，也就是当做常量来使用，什么时候需要再添加
 * */
public enum ShopStateEnum {
    CHECK(0,"审核中"),OFFLINE(-1,"非法店铺"),SUCCESS(1,"操作成功"),
    PASS(2,"通过认证"),INNER_ERROR(-1001,"内部系统错误"),
    NULL_SHOPID(-1002,"ShopId为空"),NULL_SHOP(-1003,"shop信息为空");

    private int state;
    private String stateInfo;

    private ShopStateEnum(int state, String stateInfo ){
        this.state = state;
        this.stateInfo = stateInfo;
    }

    /*
     * 依据传入的state返回相应的enum值*/
    public static ShopStateEnum stateOf(int state){
        for (ShopStateEnum stateEnum:values()){
            if (stateEnum.getState() == state){
                return stateEnum;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
