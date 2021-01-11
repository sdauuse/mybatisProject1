package com.miao.test;

import com.miao.dao.CustomerDao;
import com.miao.dao.CustomerDaoImpl;
import com.miao.domain.Customer;
import com.miao.mapper.CustomerMapper;
import com.miao.utils.MybatisUtils;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/11 - 14:35
 * @commet:
 */
public class DaoTest {

    @Test
    public void test1(){
        CustomerDao customerDao = new CustomerDaoImpl();

        Customer customer = customerDao.getCustomerById(3);
        System.out.println(customer);

    }

    //测试mybatis动态代理
    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customerList = customerMapper.queryCustomerAll();
        for (Customer customer:customerList) {
            System.out.println(customer);
        }

        sqlSession.close();
    }

    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = customerMapper.queryCustomerByIdAndName(2,"李白");
        System.out.println(customer);
        sqlSession.close();
    }

    //测试count(*)
    @Test
    public void test4(){
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        int count = customerMapper.queryCustomerCount();
        System.out.println(count);

        sqlSession.close();
    }
}
