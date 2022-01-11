package com.example.java.day19;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static com.example.java.day19.SimpleServer.*;

/**
 * @Author: zhaojie
 * @Date: 2022/1/10 19:05
 * @Version: 1.0
 * @Description:
 */
public class Chat {
    private String from;
    private String greeting;
    private Socket socket;

    public Chat(String from, String greeting, Socket socket) {
        this.from = from;
        this.greeting = greeting;
        this.socket = socket;
    }

    public void chatting(){
        Scanner in = new Scanner(System.in);
        // 输入流
        try( BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),SERVER_CHARSET));
             // 输出流
             PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),SERVER_CHARSET));
             ) {
            System.out.println("Socket连接成功，建立输入输出");
            if(greeting != null){
                pw.println("你好，"+from+"."+greeting);
                pw.flush();
            }
            while(true){
                String line = reader.readLine();
                if(line.trim().equalsIgnoreCase(BYE)){
                    System.out.println("断开连接");
                    pw.println(BYE);
                    pw.flush();
                    break;
                }else{
                    System.out.println("来自\""+from+"\"的消息"+line);
                }
                line = in.nextLine();
                pw.println(line);
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("聊天结束");
    }
}
