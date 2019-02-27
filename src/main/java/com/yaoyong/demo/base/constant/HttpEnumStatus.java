package com.yaoyong.demo.base.constant;


public enum HttpEnumStatus {



    LOGIN_SUCCESS("登录成功", 5000),
    LOGIN_FAILURE("登录成功", 5010),


    INSERT_SUCCESS("创建成功", 1000),
    UPDATE_SUCCESS("更新成功", 1010),
    DELETE_SUCCESS("删除成功", 1020),
    INSERT_FAILURE("创建失败", 1030),
    UPDATE_FAIURE("更新失败", 1040),
    DELETE_FAILURE("删除失败", 1050),
    OK("获得数据成功",1),
	NO_DATA("沒有数据", 2000);

    private String name;
    private Integer index;

    // 构造方法
    private HttpEnumStatus(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法

    public static String getName(int index) {
        for (HttpEnumStatus c : HttpEnumStatus.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
