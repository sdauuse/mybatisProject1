package com.miao.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author miaoyin
 * @date 2021/1/10 - 19:38
 * @commet:
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Customer {
    private Integer cust_id;
    private String cust_name;
    private String cust_profession;
    private String cust_phone;
    private String email;
}
