package com.example.java.day13;

/**
 * @Author: zhaojie
 * @Date: 2021/12/27 10:45
 * @Version: 1.0
 * @Description: 异常，捕获异常
 */
public class Demo {
    public static void main(String[] args) {
        /*try {
            String a = "";
            a.substring(3);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            throw new MyRuntimeException("执行错误",e);
        }*/

        // try增加（） 后面可以添加资源
        try( MyAutoCloseable myAutoCloseable1 = new MyAutoCloseable("res1");
             MyAutoCloseable myAutoCloseable2 = new MyAutoCloseable("res2");) {
            while(true){
                System.out.println(myAutoCloseable1.read());
                System.out.println(myAutoCloseable2.read());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
