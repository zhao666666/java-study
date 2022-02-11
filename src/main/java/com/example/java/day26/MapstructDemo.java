package com.example.java.day26;

/**
 * @Author: zhaojie
 * @Date: 2022/1/24 18:20
 * @Version: 1.0
 * @Description:
 */
public class MapstructDemo {
    public static void main(String[] args) {
        Student student = new Student(20,"赵杰","19");
        StudentDTO studentDTO = StudentMapper.INSTANCE.toDto(student);
        System.out.println(studentDTO.getNo());
        System.out.println(studentDTO.getName());
        System.out.println(studentDTO.getSex());
    }
}
