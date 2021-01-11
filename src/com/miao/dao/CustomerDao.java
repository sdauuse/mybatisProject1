package com.miao.dao;

import com.miao.domain.Customer;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/11 - 14:17
 * @commet:
 */
public interface CustomerDao {
    public Customer getCustomerById(Integer cust_id);
    public List<Customer> findAllCustomer();
    public void addCustomer(Customer customer);
    public void updateCustomer(Customer customer);

}
