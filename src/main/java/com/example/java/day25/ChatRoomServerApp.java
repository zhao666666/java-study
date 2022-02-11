package com.example.java.day25;

import com.example.java.day19.Chat;
import com.example.java.day25.server.ChatRoomServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.example.java.day19.SimpleServer.SERVER_PORT;

/**
 * @Author: zhaojie
 * @Date: 2022/1/21 17:15
 * @Version: 1.0
 * @Description:
 */
public class ChatRoomServerApp {

    public static void main(String[] args) throws IOException {
        ChatRoomServer chatRoomServer = new ChatRoomServer();
        chatRoomServer.start();
    }
}
