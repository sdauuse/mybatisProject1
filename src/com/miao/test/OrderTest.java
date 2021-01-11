package com.miao.test;

import com.miao.domain.Order;
import com.miao.mapper.OrderMapper;
import com.miao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/11 - 20:11
 * @commet:
 */
public class OrderTest {

    //一对多查询
    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orders = orderMapper.queryAllOrder();
        for (Order order : orders) {
            System.out.println(order);
        }
        sqlSession.close();
    }

    //测试分布查询
    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.queryOrderById(2);
        /*开启了懒加载，如果不getCustomer，就分布查询不会执行*/
        System.out.println(order.getOrder_id());
        System.out.println(order);
        sqlSession.close();
    }
}
