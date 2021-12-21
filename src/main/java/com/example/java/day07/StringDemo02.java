package com.example.java.day07;

import org.apache.tomcat.util.buf.StringUtils;

/**
 * @Author: zhaojie
 * @Date: 2021/12/16 10:40
 * @Version: 1.0
 * @Description:
 */
public class StringDemo02 {
    public static void main(String[] args) {
        System.currentTimeMillis();
        System.out.println(args.length);
        for (int i = 0; i <args.length; i++) {
            System.out.println(args[i]);
        }

    }

    public String answer(String querstion) {
        String ret = null;
        ret = handleCanStart(querstion);
        if(ret == null) {
            return ret;
        }
        return handleUnkown(querstion);

    }

    private String handleCanStart(String querstion){
        return null;
    }

    private String handleAskTail(String querstion){
        return null;
    }

    private String handleUnkown(String querstion){
        return null;
    }
}
