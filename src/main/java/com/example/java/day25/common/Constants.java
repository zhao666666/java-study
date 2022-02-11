package com.example.java.day25.common;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Author: zhaojie
 * @Date: 2022/1/21 15:16
 * @Version: 1.0
 * @Description:
 */
public interface Constants {
    int SERVER_PORT = 45678;

    Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;


    String SPACE_SPRING = " ";

    String MESSAGE_SEP_STR = String.valueOf(Character.UNASSIGNED);

    String ADMIN_NAME = "admin";

    String USER_NAME_PASS = "UserNamePass";

    String COMMAND_INTRODUCTION = " 欢迎来到聊天室，你可以使用@admin list查看所有在想用户，使用@用户名跟某个用户聊天，" +
            "后续的消息则无需再次输入@，可以使用@admin logoff 离开聊天室。";

    String CHAT_WITH_START = "@";

    String NO_NAME = "anonymous";

    String SERVER_COMMAND_LOGOFF = "logoff";

    String SERVER_COMMAND_LIST = "list";

    String BYE = "bye";

    /**
     * 消息分隔符
     */
    char MESSAGE_SEP = Character.UNASSIGNED;

    /**
     * 消息结束符
     */
    String MESSAGE_BREAK = "\n";


}
