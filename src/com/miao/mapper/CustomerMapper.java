package com.miao.mapper;

import com.miao.domain.Customer;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/11 - 14:30
 * @commet:
 */
public interface CustomerMapper {

    public Customer queryCustomerById(Integer cust_id);

    public Customer queryCustomerByIdAndName(Integer cust_id, String cust_name);

    public List<Customer> queryCustomerAll();

    public Integer queryCustomerCount();

    public Customer queryCustomerLike(String name);

    public void insertCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(Customer customer);
}
