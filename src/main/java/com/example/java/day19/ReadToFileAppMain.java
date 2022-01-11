package com.example.java.day19;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author: zhaojie
 * @Date: 2022/1/10 16:08
 * @Version: 1.0
 * @Description:
 */
public class ReadToFileAppMain {
    private static final String SOURCE_FILE_NAME = "zhaojie.txt";

    public static void main(String[] args) throws IOException {
        File file = new File("."+File.separator+SOURCE_FILE_NAME);
        Scanner in =  new Scanner(System.in);
        classicWay(file);
        coolerWay(file);
    }

    private static void coolerWay(File file) throws IOException {
        System.out.println("新式");
        try(FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(isr)){
           reader.lines().map(String::trim).map(String::toUpperCase).forEach(s->{
               System.out.println("读到的数据:"+s);
           });
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void classicWay(File file) throws IOException {
        System.out.println("老式");
        try(FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(isr)){
            String line = null;
            while((line = reader.readLine()) !=null ){
                System.out.println("读到的数据:"+line.trim().toUpperCase());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
