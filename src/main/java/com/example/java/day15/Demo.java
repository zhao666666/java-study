package com.example.java.day15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zhaojie
 * @Date: 2022/1/5 10:57
 * @Version: 1.0
 * @Description: 泛型，协变用于读取，逆变用于写入
 * 1.编译期检查并类型擦除
 * 2.使用时的类型转换
 */
public class Demo {
    public static void main(String[] args) {
        Animal[] animalsArray = new Cat[2];
        animalsArray[0] = new Cat();
        // java.lang.ArrayStoreException,数组存储异常
        //animals[1] = new Dog();

        Animal animal = animalsArray[0];
        Animal animal1 = new Cat();
        // 如果Cat是Animal的子类型，那么Cat[]也是Animal[]的子类型，我们称这种性质为「协变」（covariance）。Java中，数组是协变的。

        List<Integer> list = new LinkedList<>();
        list.add(123);
        // 泛型的类型推导功能，使用泛型以后，我们的代码看起来变得简洁又安全了，译报错
        //list.add("123");
        int a = (int) list.get(0);
        // java.lang.ClassCastException,泛型的不确定性
        //int b = (int) list.get(1);


        // Java中的泛型是不变（invariance）的
        // 列表优先于数组,Java在使用列表+泛型时，吸取了上面数组的教训。也就是List<Cat> 不是 List<Animal> 的子类型
        List<Cat> cats = new LinkedList<>();
        // 报错
        //List<Animal> animalss = cats;


        //List<? extends Animal> animals = new ArrayList<>();
        // 以下四行代码都不能编译通过
        // animals.add(new Dog());
        // animals.add(new Cat());
        // animals.add(new Animal());
        // animals.add(new Object());
        // 可以添加null，但没意义
        // animals.add(null);
        // Java在编译器层面「通过禁止写入的方式，保证了协变下的安全性」。

        //  List<Animal>是List<? super Cat>的子类型。
        List<? super Animal> animals  = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Animal());
        animals.add(new Animal());
        Object object = animals.get(0);
        System.out.println(object);

        List<? super Cat> catList = new LinkedList<Animal>();
        //extends决定了上界，super决定了下界,
        // 「上界和下界，其实本质上指的是，在定义泛型的时候，子类型的边界」。换句话说，「在运行时真正的类型」。

        List<?> anyOne = new LinkedList<Animal>();
        List<?> anyTwo = new LinkedList<Cat>();
        List<?> anyThree = new LinkedList<>();
        // 这种写法编译不通过
        //anyOne.add(new Animal());

        /**
         * 那它与List<Object>有什么区别呢？根据前面的推断，有两个比较明显的区别：
         * List<Object>可以调用add方法，但List<?>不能。
         * List<?>可以协变，上界是Object，但List<Object>不能协变。
         */


        Collection<Animal> animalCollection = new LinkedList<>();
        animalCollection.add(new Cat());
        animalCollection.add(new Animal());

        Collection<Cat> catCollection = new LinkedList<>();
        Collection<Object> objects = new LinkedList<>();
        // 受协变的限制
        animalCollection.addAll(catCollection);
        // 以下代码编译不通过，因为不安全
        //animalCollection.addAll(objects);
        animalCollection.containsAll(catCollection);
        animalCollection.containsAll(objects);

    }
}
