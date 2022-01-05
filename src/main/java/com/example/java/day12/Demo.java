package com.example.java.day12;

/**
 * @Author: zhaojie
 * @Date: 2021/12/24 10:36
 * @Version: 1.0
 * @Description: 抽象类，可以使用抽象方法定义，不需要实现，只需要在需要用的时候，再去自定义实现那个抽象方法
 * 优先级  父类 ====> 类 ====> 默认
 * 1.类中的方法优先级最高，类或父类中声明的方法的优先级高于任何声明为默认方法的优先级。
 * 2.如果第一条无法判断，那么子接口的优先级更高：方法签名相同时，优先选择拥有最具体实现的默认方法的接口， 即如果B继承了A，那么B就比A更加具体。
 * 3.最后，如果还是无法判断，继承了多个接口的类必须通过显式覆盖和调用期望的方法， 显式地选择使用哪一个默认方法的实现。
 */
public class Demo implements InterfaceDemo{
    int a;

    @Override
    public int delete(int age) {
        return 0;
    }

    public static void main(String[] args) {

        class A implements InterfaceDemo{

            @Override
            public void add() {

            }
        }

        // 后面的{}就是匿名内部类，就是有一个匿名类
        AbstractDemo abstractDemo = new AbstractDemo(){
            @Override
            void add() {

            }

            @Override
            void update() {
            }
        };

        new Demo().delete(1);

        // 局部内部类
        class Demo02{
            int a;
        }

        // 成员内部类不能使用static，静态
        /*static class Demo03{

        }*/
    }


    @Override
    public void add() {

    }

    // 成员内部类
    class Demo02{
       int b;
    }

    // 静态内部类
    // 静态static，单例模式，只有一个实例,
    static class Demo01{
        int a;
    }
}
