package com.example.java.day25.common;

import lombok.Data;

import java.util.Objects;

import static com.example.java.day25.common.Constants.MESSAGE_BREAK;
import static com.example.java.day25.common.Constants.MESSAGE_SEP;

/**
 * @Author: zhaojie
 * @Date: 2022/1/21 15:13
 * @Version: 1.0
 * @Description:
 */
@Data
public class ChatMessage {
    private String from;
    private String to;
    private String message;

    public ChatMessage(String from, String to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;
    }

    public ChatMessage() {

    }

    /**
     * 解密
     * @param message
     * @return
     */
    public static ChatMessage buildFrom(String message) {
        ChatMessage ret = new ChatMessage();
        int fromEnd = message.indexOf(MESSAGE_SEP);
        ret.from = message.substring(0,fromEnd);
        int toEnd = message.indexOf(MESSAGE_SEP,fromEnd+1);
        ret.to = message.substring(fromEnd+1,toEnd);
        ret.message = message.substring(toEnd+1).trim();
        return ret;
    }

    /**
     * 加密
     * @return
     */
    public String toMessageString(){
        StringBuilder ret = new StringBuilder();
        ret.append(from).append(MESSAGE_SEP).append(to).append(MESSAGE_SEP).append(message).append(MESSAGE_BREAK);
        return ret.toString();
    }

    public static void main(String[] args) {
        ChatMessage chatMessage = new ChatMessage("testfrom","testto","这是一个测试");
        String strMessage = chatMessage.toMessageString().trim();
        System.out.println(strMessage);
        ChatMessage parsed = buildFrom(strMessage);
        System.out.println(parsed.equals(strMessage));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatMessage)) {
            return false;
        }
        ChatMessage that = (ChatMessage) o;
        return Objects.equals(from, that.from) &&
                Objects.equals(to, that.to) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, message);
    }
}
