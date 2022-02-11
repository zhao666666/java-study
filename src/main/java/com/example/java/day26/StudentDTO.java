package com.example.java.day26;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zhaojie
 * @Date: 2022/1/24 18:18
 * @Version: 1.0
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private int no;

    private String name;

    private String sex;
}
