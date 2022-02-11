package com.example.java.day25.client;

import com.example.java.day25.common.ChatMessage;
import com.example.java.day25.common.DataExchange;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executors;

import static com.example.java.day25.common.Constants.*;
import static com.example.java.day25.common.Utils.isValidToUserName;

/**
 * @Author: zhaojie
 * @Date: 2022/1/21 16:50
 * @Version: 1.0
 * @Description:
 */
public class ChatRoomClient {
    private String server;
    DataExchange dataExchange;
    private String userName;
    private String currentToName;
    Scanner in = new Scanner(System.in);

    public ChatRoomClient(String server) throws IOException {
        System.out.println("客户端连接中");
        this.server = server;
        Socket socket  = new Socket(server,SERVER_PORT);
        System.out.println("客户端已连接到服务器："+socket.getRemoteSocketAddress());
        dataExchange = new DataExchange(socket);
        this.server = server;
    }

    public void start() throws IOException {
        initName();
        Thread readTread = new Thread(()->{
            while (true){
                try {
                    ChatMessage chatMessage = dataExchange.receive();
                    if(chatMessage.getFrom().equalsIgnoreCase(ADMIN_NAME) &&
                    chatMessage.getMessage().trim().equalsIgnoreCase(BYE)){
                        dataExchange.close();
                        System.out.println("已经离开聊天室，程序结束");
                        System.exit(0);
                    }
                    System.out.println("from"+chatMessage.getFrom()+":"+chatMessage.getMessage());
                } catch (IOException e) {
                    e.printStackTrace();
                    dataExchange.close();
                    System.exit(-2);
                }
            }
        });

        readTread.start();

        Thread writerThread = new Thread(()->{
            while (true){
                try {
                   dataExchange.send(createChatMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(-3);
                }
            }
        });
        writerThread.start();
    }

    private ChatMessage createChatMessage() {
        while (true){
            String line = in.nextLine().trim();
            String to;
            String message;
            try{
                if (line.startsWith(CHAT_WITH_START)) {
                    to = line.substring(1,line.indexOf(SPACE_SPRING)).trim();
                    String error = isValidToUserName(to);
                    if(error == null){
                        currentToName = to;
                        message = line.substring(line.indexOf(SPACE_SPRING) +1);
                    }else{
                        System.out.println("用户名\""+to+"\"不合法："+error);
                        continue;
                    }
                }else{
                    if(currentToName == null){
                        System.out.println("请使用@输入想和谁聊天，以后如果和同一个人聊天，就可以不使用@啦");
                    }
                    message = line;
                }
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }

            return new ChatMessage(userName,currentToName,message);
        }
    }

    private void initName() throws IOException {
        String typeedName = null;
        while(true){
            ChatMessage chatMessage = dataExchange.receive();
            String message = chatMessage.getMessage();
            if(message.equalsIgnoreCase(USER_NAME_PASS)){
                userName = typeedName;
                break;
            }else{
                System.out.println(message);
                typeedName = in.nextLine();
                dataExchange.send(new ChatMessage(NO_NAME,ADMIN_NAME,typeedName.trim()));
            }
        }
    }
}
