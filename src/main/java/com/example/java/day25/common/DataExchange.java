package com.example.java.day25.common;

import lombok.Data;

import java.io.*;
import java.net.Socket;

import static com.example.java.day25.common.Constants.DEFAULT_CHARSET;

/**
 * @Author: zhaojie
 * @Date: 2022/1/21 15:37
 * @Version: 1.0
 * @Description:    数据交换的类
 */
@Data
public class DataExchange {
    private Socket socket;

    private BufferedReader reader;

    private PrintWriter writer;

    private boolean isClosed = false;

    public DataExchange(Socket socket) throws IOException {
        this.socket = socket;
        init(socket);
    }

    private void init(Socket socket) throws IOException {
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),DEFAULT_CHARSET));
        writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),DEFAULT_CHARSET));
    }

    public void send(ChatMessage chatMessage){
        writer.println(chatMessage.toMessageString());
        writer.flush();
    }

    public ChatMessage receive() throws IOException {
        String line = null;
        while(true){
            line =reader.readLine();
            if(line != null && line.length() > 0){
                break;
            }
        }
        return ChatMessage.buildFrom(line);
    }

    public void close(){
        try {
            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        isClosed = true;
    }
}
