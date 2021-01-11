package com.miao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author miaoyin
 * @date 2021/1/11 - 19:52
 * @commet:
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Order {
    private Integer order_id;
    private String order_name;
    private String order_num;

    //一个用户可以有多个订单，而一个订单只属于一个用户
    private Customer customer;
}
