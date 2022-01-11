package com.example.java.day18;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * @Author: zhaojie
 * @Date: 2022/1/7 13:57
 * @Version: 1.0
 * @Description:
 */
public class CreateDirAndFileAppMain {
    /**
     * 当前路径下创建文件
     */
    private static final String ROOT = "."+ File.separator;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        File dir= createDirs();
        File newDir = renameDir(dir,"111");
        if(newDir == null){
            return ;
        }
        String fileName = createFiles(newDir);
        String fileNameNew = renameFiles(newDir, fileName);
        deleteFiles(newDir,fileName);
        deleteDir(newDir);
    }

    private static void deleteDir(File newDir) {
        newDir.delete();
    }

    private static void deleteFiles(File newDir, String fileName) {
        newDir.delete();
    }

    private static String renameFiles(File newDir, String fileName) {
        new File(newDir, fileName);
        return null;
    }

    private static String createFiles(File newDir) {
        new File(newDir,"1"+".txt");
        return null;
    }

    private static File renameDir(File newDir,String fileName) {
        new File(newDir,fileName+".txt");
        return null;
    }

    private static File createDirs() throws IllegalAccessException {
        List<String> pathList = new ArrayList<>();
        while(true){
            String path = scanner.nextLine();
            pathList.add(path);
            if(path.isEmpty()){}{
                break;
            }
        }
        return createDir(pathList.toArray(new String[0]));
    }

    private static File createDir(String... toArray) throws IllegalAccessException {
        String rest = joinRestDir(toArray);
        System.out.println("将在"+ROOT+"下创建"+rest);
        File file = new File(ROOT, rest);
        // file.exists()   file.isDirectory()
        if(file.exists() && file.isDirectory()){
            System.out.println("文件已经存在");
            return file;
        }else{
            if(file.mkdirs()){
                return file;
            }else{
                throw new IllegalAccessException("无法创建文件");
            }
        }
    }

    private static String joinRestDir(String... toArray) {
        // a b c a\b\c
        return Arrays.stream(toArray).map(String::trim).collect(Collectors.joining(File.separator));
    }
}
