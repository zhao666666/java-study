package com.example.java.day25.server;

import com.example.java.day25.common.ChatMessage;
import com.example.java.day25.common.DataExchange;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.*;

import static com.example.java.day25.common.Constants.*;
import static com.example.java.day25.common.Utils.isValidUserName;

/**
 * @Author: zhaojie
 * @Date: 2022/1/21 16:05
 * @Version: 1.0
 * @Description:
 */
public class ChatRoomServer {
    private int port;

    private Map<String, DataExchange> dataExchangeMap = new ConcurrentHashMap<>();

    private ThreadPoolExecutor server = new ThreadPoolExecutor(3,5, 1,
            TimeUnit.SECONDS,new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

    public ChatRoomServer(int port) {
        this.port = port;
    }

    public ChatRoomServer() {
    }

    public void start() throws IOException {
        System.out.println("服务已启动");
        ServerSocket ss = new ServerSocket(SERVER_PORT);
        while (true){
            Socket socket = ss.accept();
            handleClientSocket(socket);
        }
    }

    private void handleClientSocket(Socket socket) {
        server.submit(new ClientHandler(socket));
    }

    /**
     * 一个线程对应一个消息对象
     */
    private class ClientHandler implements Runnable {
        private Socket socket;

        private String userName = null;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("处理来自"+socket.getRemoteSocketAddress()+"的连接");
            DataExchange dataExchange = null;
            try {
                dataExchange = new DataExchange(socket);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            // 校验
            initUser(dataExchange);

            // 收消息
            while(true){
                try {
                    ChatMessage chatMessage = dataExchange.receive();
                    String toName = chatMessage.getTo();
                    // 不区分大小写
                    if(toName.equalsIgnoreCase(ADMIN_NAME)){
                        handleServerCommand(chatMessage);
                    }else{
                        handleChatMessage(dataExchange,chatMessage,toName);
                    }
                } catch (IOException e) {
                    dataExchangeMap.remove(userName).close();
                    e.printStackTrace();

                }
            }
        }

        private void handleChatMessage(DataExchange dataExchange, ChatMessage chatMessage, String toName) {
            DataExchange toEx = dataExchangeMap.get(toName);
            if(toEx == null){
                dataExchange.send(new ChatMessage(ADMIN_NAME,chatMessage.getFrom(),
                        "用户名"+toName));
            }else{
                toEx.send(chatMessage);
            }
        }

        private void handleServerCommand(ChatMessage chatMessage) {
            DataExchange from = dataExchangeMap.get(chatMessage.getFrom());
            String command = chatMessage.getMessage();
            if (command.equalsIgnoreCase(SERVER_COMMAND_LOGOFF)) {
                from.send(new ChatMessage(ADMIN_NAME,chatMessage.getFrom(),BYE));
                from.close();
                System.out.println("用户"+chatMessage.getTo()+"离开聊天室");
            }else if(command.equalsIgnoreCase(SERVER_COMMAND_LIST)){
                String allNames = getAllNames();
                from.send(new ChatMessage(ADMIN_NAME,chatMessage.getFrom(),"所有在线用户："+allNames));
            }
        }

        private void initUser(DataExchange dataExchange) {
            String errorMsg = null;
            while(true){
                String allNames = getAllNames();
                dataExchange.send(new ChatMessage(ADMIN_NAME,NO_NAME,
                        (errorMsg == null ? "" : "用户名非法，错误信息为" + errorMsg + ":") +"现有的用户名有"+ allNames + ".请输入你的用户名："));

                try {
                    ChatMessage chatMessage = dataExchange.receive();
                    String userName = chatMessage.getMessage();
                    errorMsg = isValidUserName(userName);
                    if(errorMsg == null && (!dataExchangeMap.containsKey(userName))){
                        this.userName = userName;
                        dataExchangeMap.put(userName,dataExchange);
                        dataExchange.send(new ChatMessage(ADMIN_NAME,userName,USER_NAME_PASS));
                        dataExchange.send(new ChatMessage(ADMIN_NAME,userName,COMMAND_INTRODUCTION));
                        return ;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    dataExchange.close();
                    return;
                }
            }
        }

        private String getAllNames() {
            String split = ",";
            if(dataExchangeMap.isEmpty()){
                return CHAT_WITH_START + ADMIN_NAME;
            }else{
                return CHAT_WITH_START + ADMIN_NAME + split + CHAT_WITH_START +
                        String.join(split+CHAT_WITH_START,dataExchangeMap.keySet());
            }
        }
    }
}
