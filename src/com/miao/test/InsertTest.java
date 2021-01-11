package com.miao.test;

import com.miao.domain.Customer;
import com.miao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author miaoyin
 * @date 2021/1/10 - 21:26
 * @commet:
 */
public class InsertTest {

    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.openSession();
        Customer customer = new Customer();
        customer.setCust_name("后裔2");
        customer.setCust_phone("13192261164");
        customer.setCust_profession("射手");
        customer.setEmail("45646542@qq.com");
        sqlSession.insert("insertCustomer", customer);
        //sql改变数据库数据时，需要提交事务
        //手动提交事务
        sqlSession.commit();
        System.out.println(customer);
        sqlSession.close();
    }

    //更新操作
    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.openSession();
        //可以先查询再更新
        Customer customer = sqlSession.selectOne("queryCustomerById", 15);
        customer.setCust_name("孙悟空");

        sqlSession.update("updateCustomer", customer);

        sqlSession.commit();
        sqlSession.close();
    }

    //删除操作
    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.openSession();
        //先查询再根据cust_id删除
        Customer customer = sqlSession.selectOne("queryCustomerById", 16);

        sqlSession.delete("deleteCustomer", customer);

        sqlSession.commit();
        sqlSession.close();
    }
}
