package com.miao.test;

import com.miao.domain.Customer;
import com.miao.mapper.CustomerMapper;
import com.miao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/12 - 13:53
 * @commet:
 */
public class DynamicTest {

    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customerList = customerMapper.dynamicQueryCustomerByNameAndPro("李白", "刺客");
        for (Customer customer : customerList) {
            System.out.println(customer);
        }

        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        Customer customer = new Customer();
        customer.setCust_name("李白白");
        customer.setCust_profession("肉盾");
        customer.setCust_id(2);

        customerMapper.updateCustomer(customer);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customers = customerMapper.queryCustomers(new Integer[]{1,3,5,7,9});
        for (Customer customer: customers) {
            System.out.println(customer);
        }
        sqlSession.close();
    }
}
