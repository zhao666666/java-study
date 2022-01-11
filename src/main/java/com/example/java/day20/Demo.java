package com.example.java.day20;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * @Author: zhaojie
 * @Date: 2022/1/11 13:49
 * @Version: 1.0
 * @Description:
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        System.out.println("解析域名");
        InetAddress inetAddress = InetAddress.getByName("www.hao123.com");
        System.out.println("网站地址为"+inetAddress);
        System.out.println("尝试连接到主机");
        Socket socket = new Socket();
        SocketAddress socketAddress = new InetSocketAddress(inetAddress, 80);
        socket.connect(socketAddress,1000);
        System.out.println("已经连接到主机，开始模拟发送http请求");

        // 输出流
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
        StringBuffer sb = new StringBuffer();

        // 这是标志的http协议标志的请求头
        sb.append("GET /index.html HTTP/1.1\r\n");
        sb.append("Host: www.hao123.com\r\n");
        sb.append("Connection: Keep-Alive\r\n");
        sb.append("\r\n");
        pw.write(sb.toString());
        pw.flush();

        System.out.println("请求已经发送，开始读取主页内容");
        // 输入流
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        reader.lines().forEach(System.out::println);


    }
}
