package com.miao.mapper;

import com.miao.domain.Order;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/11 - 20:06
 * @commet:
 */
public interface OrderMapper {

    public List<Order> queryAllOrder();

    public Order queryOrderById(Integer id);
}
