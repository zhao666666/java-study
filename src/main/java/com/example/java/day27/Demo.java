package com.example.java.day27;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @Author: zhaojie
 * @Date: 2022/1/25 16:27
 * @Version: 1.0
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        String jsonString = "{NAME:'Antony',AGE:'12',SEX:'male',ADDRESS_ID:'male'}";
        //String jsonString = "{name:'Antony',age:'12',sex:'male',addressId:'88888'}";
        StaffDTO staffDTO = new StaffDTO("赵杰", 11, "男", "111");
        Staff staff = JSON.parseObject(jsonString, Staff.class);
        System.out.println(staff);
    }
}
