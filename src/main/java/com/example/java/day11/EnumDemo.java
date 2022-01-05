package com.example.java.day11;

/**
 * @Author: zhaojie
 * @Date: 2021/12/23 15:16
 * @Version: 1.0
 * @Description:
 */
@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
public enum EnumDemo {

    SUCCESS(200,"成功"),
    ERROR(500,"失败");

    private int id;
    private String description;

    /**
     * 构造方法是私有的，不写也是private
     * @param id 参数
     */
    EnumDemo(int id,String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
