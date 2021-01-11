package com.miao.test;

import com.miao.domain.Customer;
import com.miao.domain.Order;
import com.miao.mapper.CustomerMapper;
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

    /*一对多关系的插入*/
    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        Order order = new Order();
        order.setOrder_name("新订单111");
        order.setOrder_num("2000001");

        Customer customer = new Customer();
        customer.setCust_name("新客户111");
        customer.setCust_phone("13284495568");
        customer.setCust_profession("新职业111");
        customer.setEmail("742334324@qq.com");

        //要先插入，再setCustomer，因为插入后customer中的cust_id才会有值
        customerMapper.insertCustomer(customer);
        order.setCustomer(customer);

        orderMapper.insertOrder(order);
        sqlSession.commit();
        sqlSession.close();

    }

    /*多对一关系的查询，即从多的一方开始查询*/
    @Test
    public void test4() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customerList = customerMapper.queryCustomerByIdAndOrder(3);
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
        sqlSession.close();
    }

    /*多对一关系新增*/
    @Test
    public void test5() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        Order order1 = new Order();
        order1.setOrder_name("新订单1");
        order1.setOrder_num("xin20000011");

        Order order2 = new Order();
        order2.setOrder_name("新订单2");
        order2.setOrder_num("xin20000012");

        Customer customer = new Customer();
        customer.setCust_name("新用户名");
        customer.setEmail("xin@qq.com");
        customer.setCust_phone("1313131922");

        order1.setCustomer(customer);
        order2.setCustomer(customer);

        customerMapper.insertCustomer(customer);
        orderMapper.insertOrder(order1);
        orderMapper.insertOrder(order2);

        sqlSession.commit();
        sqlSession.close();

    }

    /*多对一删除操作*/
    @Test
    public void test6() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        Customer customer = new Customer();
        customer.setCust_id(16);
        orderMapper.updateRelation(16);
        customerMapper.deleteCustomer(customer);

        sqlSession.commit();
        sqlSession.close();
        //customerMapper.deleteCustomer();
    }
}
