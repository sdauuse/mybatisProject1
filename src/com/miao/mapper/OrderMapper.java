package com.miao.mapper;

import com.miao.domain.Order;
import org.apache.tools.ant.taskdefs.condition.Or;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/11 - 20:06
 * @commet:
 */
public interface OrderMapper {

    public List<Order> queryAllOrder();

    public Order queryOrderById(Integer id);

    public void insertOrder(Order order);

    public void updateRelation(Integer id);
}
