package com.miao.test;

import com.miao.dao.Customer;
import com.miao.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/10 - 19:50
 * @commet:
 */
public class MyTest {

    //根据id查询一个用户
    @Test
    public void test1() throws IOException {
        /*//1.sqlSessionFactoryBuilder 加载配置文件
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //2.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMappingConfig.xml");

        //3.获取session工厂
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);

        //4.获取会话 ---jdbc连接
        SqlSession sqlSession = sessionFactory.openSession();*/
        SqlSession sqlSession = MybatisUtils.openSession();
        //5.执行sql
        Customer customer = sqlSession.selectOne("queryCustomerById", 1);

        System.out.println(customer);

        //6.关闭session
        sqlSession.close();
    }

    //查询所有用户
    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.openSession();
        List<Customer> customerList = sqlSession.selectList("queryCustomerAll");
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
        sqlSession.close();
    }

    //模糊查询姓名为：李
    //select * from customer where cust_name like '%#{name}%'
    //#{name} mybatis 实际执行结果: select * from customer where cust_name like '%?%'

    //select * from customer where cust_name like '%${value}%'  ${}不防sql注入攻击
    //${value}  mybatis 实际执行结果: select * from customer where cust_name like '%李%'
    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.openSession();
        List<Customer> customerList = sqlSession.selectList("queryCustomerLike", "%李%");
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
        sqlSession.close();
    }
}
