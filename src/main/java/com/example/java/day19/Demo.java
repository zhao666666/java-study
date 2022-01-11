package com.example.java.day19;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author: zhaojie
 * @Date: 2022/1/10 10:25
 * @Version: 1.0
 * @Description:
 */
public class Demo {
    public static void main(String[] args) throws UnknownHostException {
        // 输入输出字节
        InputStream inputStream;
        OutputStream outputStream;

        // 增加降字节编码为字符的功能，只输入输出字符
        Reader reader;
        Writer writer;

        // 输入输出是站到程序的角度来说的，input，reader就是输入；output，writer就是输出

        ServerSocket serverSocket;
        Socket socket;
        InetAddress address = InetAddress.getByName("www.geekbang.com");
        System.out.println(address);
    }
}
