package com.example.java.day19;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Author: zhaojie
 * @Date: 2022/1/10 15:07
 * @Version: 1.0
 * @Description:
 */
public class WriterToFileAppMain {
    private static final Scanner in =new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        File targetFile = createFile();
        writerToFile(targetFile);
        System.out.println("程序执行完成");
    }

    private static void writerToFile(File file) throws IOException{
        // try() 括号中创建的是预准备
        // 创建一个OutputSteam
        // IO，装饰者模式，一层一层增加
        try (FileOutputStream fos = new FileOutputStream(file);
             // 创建一个可以消费OutputStream的writer，指定字符集
             OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
             // 使用printWirter，方便写入一行字符
             PrintWriter pw = new PrintWriter(osw);){
            System.out.println("请输入文件内容，如果输入空行则结束");
            while(true){
                String trim = in.nextLine().trim();
                if (trim.trim().isEmpty()) {
                    System.out.println("输入结束");
                    break;
                }else{
                    System.out.println("输入内容为："+trim);
                    pw.println(trim);
                    // 缓存写入文件
                    pw.flush();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static File createFile() throws IOException {
        System.out.println("请输入文件名:");
        String fileName = in.nextLine().trim();
        File file = new File("." + File.separator + fileName + ".txt");
        // 是否存在这个文件
        if (file.isFile()) {
            System.out.println("目标文件存在，删除"+ file.delete());
        }
        System.out.println(file.createNewFile());
        return file;
    }
}
