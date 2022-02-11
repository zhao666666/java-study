package com.example.java.day24;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: zhaojie
 * @Date: 2022/1/19 18:15
 * @Version: 1.0
 * @Description:
 */
public class ConcurrentMapMain {
    public static void main(String[] args) {
        // 将map 切分为 16个segment （相当于加了16个锁，不会造成锁冲突）
        Map<String, List<Integer>> map = new ConcurrentHashMap<>();
        String k1 = "k1";
        map.put(k1, new ArrayList<>());
        System.out.println("put:" + map.get(k1));

        //ConcurrentHashMap的key 和 value都不允许为null
//        map.put(null,new ArrayList<>());
//        map.put(k1,null);

        List<Integer> newList = new ArrayList<>();
        newList.add(999);
        // 如果没有就put
        map.putIfAbsent(k1, newList);

        System.out.println("putIfAbsent:" + map.get(k1));

        // 双操作数，有返回值的
        map.compute(k1, (k, v) -> {
            System.out.println("k" + k.length());
            v.add(1);
            return v;
        });

        System.out.println("compute:" + map.get(k1));

        // 如果key对应的值存在，则执行lambda
        map.computeIfPresent(k1, (k,v)->{
            v.add(999);
            return v;
        });

        System.out.println("computeIfAbsent:" + map.get(k1));

        // 只有在key不存在的时候才会执行
        map.computeIfAbsent(k1,(k)->new ArrayList<>(Integer.MAX_VALUE));

        System.out.println(map);


    }
}
