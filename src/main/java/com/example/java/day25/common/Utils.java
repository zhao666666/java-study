package com.example.java.day25.common;

import static com.example.java.day25.common.Constants.*;

/**
 * @Author: zhaojie
 * @Date: 2022/1/21 15:48
 * @Version: 1.0
 * @Description:
 */
public class Utils {

    public static String isValidUserName(String userName) {
        String ret = isValidToUserName(userName);
        if (ret != null) {
            return ret;
        }
        if(userName.toLowerCase().contains(ADMIN_NAME)){
            return "用户名不可以包含"+ADMIN_NAME;
        }
        return null;
    }

    public static String isValidToUserName(String userName) {
        if(userName.trim().length()==0){
            return "用户名不可以为空";
        }
        if (userName.contains(MESSAGE_SEP_STR)){
            return "用户名不可以包含分隔符";
        }
        if(userName.contains(CHAT_WITH_START)){
            return "用户名不可以包含"+CHAT_WITH_START;
        }
        if(userName.toLowerCase().contains(NO_NAME)){
            return "用户名不可以包含"+NO_NAME;
        }
        if(userName.contains(SPACE_SPRING)){
            return "用户名不可以包含空格";
        }
        return null;
    }
}
