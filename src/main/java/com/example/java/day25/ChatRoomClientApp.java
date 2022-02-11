package com.example.java.day25;

import com.example.java.day25.client.ChatRoomClient;

import java.io.IOException;

/**
 * @Author: zhaojie
 * @Date: 2022/1/21 17:15
 * @Version: 1.0
 * @Description:
 */
public class ChatRoomClientApp {
    public static void main(String[] args) throws IOException {
        new ChatRoomClient("127.0.0.1").start();
    }
}
