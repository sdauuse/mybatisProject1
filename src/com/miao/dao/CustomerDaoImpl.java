package com.miao.dao;

import com.miao.domain.Customer;
import com.miao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/11 - 14:18
 * @commet:
 */
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public Customer getCustomerById(Integer cust_id) {
        SqlSession sqlSession = MybatisUtils.openSession();
        Customer customer = sqlSession.selectOne("queryCustomerById", cust_id);
        sqlSession.close();
        return customer;
    }

    @Override
    public List<Customer> findAllCustomer() {
        SqlSession sqlSession = MybatisUtils.openSession();
        List<Customer> customerList = sqlSession.selectList("queryCustomerAll");
        sqlSession.close();
        return customerList;
    }

    @Override
    public void addCustomer(Customer customer) {

        SqlSession sqlSession = MybatisUtils.openSession();
        sqlSession.insert("insertCustomer", customer);
        sqlSession.close();
    }

    @Override
    public void updateCustomer(Customer customer) {

        SqlSession sqlSession = MybatisUtils.openSession();
        sqlSession.update("updateCustomer", customer);
        sqlSession.close();
    }
}
