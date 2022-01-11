package com.example.java.day19;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Author: zhaojie
 * @Date: 2022/1/10 19:01
 * @Version: 1.0
 * @Description:
 */
public class SimpleServer {

    public static final int SERVER_PORT = 45632;
    public static final Charset  SERVER_CHARSET = StandardCharsets.UTF_8;
    public static final String BYE = "bye";

    public static void main(String[] args) throws IOException {
        System.out.println("SERVER端启动，在端口"+SERVER_PORT+"监听。。。");
        try ( ServerSocket ss = new ServerSocket(SERVER_PORT);
              Socket s = ss.accept();
              ){
            Chat chat = new Chat("客户端", "你已经成功连接，我们可以开始对话", s);
            chat.chatting();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("程序退出");
    }
}
