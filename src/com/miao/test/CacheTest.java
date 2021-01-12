package com.miao.test;

import com.miao.domain.Customer;
import com.miao.mapper.CustomerMapper;
import com.miao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author miaoyin
 * @date 2021/1/12 - 15:13
 * @commet:
 */
public class CacheTest {

    /*一级缓存失效的情况
    *   1.如果在查询之前,执行了增\删\改 缓存就会失效
        2.手动清空缓存
        3.如果两次的查询条件不一样,缓存也会失效
        4.如果两个查询在不同的sqlsession当中
    * */
    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = customerMapper.queryCustomerById(2);
        System.out.println(customer);

        /*一级缓存，即SqlSession级缓存，当SqlSession没有关闭时，再次查询相同的数据，则会在缓存中找到数据，而不会重新发送sql，一级缓存默认开启*/
        Customer customer1 = customerMapper.queryCustomerById(2);
        System.out.println(customer1);
        System.out.println(customer == customer1);
        sqlSession.close();

        /*如果开启了二级缓存，则在一级缓存sqlSession关闭时，会把一级缓存的内容放入二级缓存中，即放入mapper缓存中
         * */
        SqlSession sqlSession1 = MybatisUtils.openSession();
        CustomerMapper customerMapper1 = sqlSession1.getMapper(CustomerMapper.class);
        Customer customer2 = customerMapper1.queryCustomerById(2);
        System.out.println(customer2);
        //System.out.println(customer2 == customer);

        sqlSession1.close();
    }
}
