package com.example.java.day27;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zhaojie
 * @Date: 2022/1/25 16:39
 * @Version: 1.0
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDTO {
    private String NAME;

    private Integer AGE;

    private String SEX;

    private String ADDRESS_ID;

}
