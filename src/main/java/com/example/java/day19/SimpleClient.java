package com.example.java.day19;

import java.io.IOException;
import java.net.Socket;

import static com.example.java.day19.SimpleServer.SERVER_PORT;

/**
 * @Author: zhaojie
 * @Date: 2022/1/10 19:01
 * @Version: 1.0
 * @Description:
 */
public class SimpleClient {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端端启动，在端口"+SERVER_PORT+"监听。。。");
        // 127.0.0.1
        try(  Socket socket = new Socket("localhost",SERVER_PORT);) {
            Chat chat = new Chat("服务器端", null, socket);
            chat.chatting();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("程序退出");
    }
}
