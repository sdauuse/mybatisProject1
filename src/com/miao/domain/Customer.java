package com.miao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

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

    //一个客户可以有多个订单
    private List<Order> orders;

}
