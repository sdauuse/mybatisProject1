package com.miao.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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

        /*使用分页插件*/
        /*第1页，一页5个数据*/
        Page<Customer> pageInfo = PageHelper.startPage(1,5);


        List<Customer> customerList = customerMapper.dynamicQueryCustomerByNameAndPro(null, null);

        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("每页显示记录数:"+pageInfo.getPageSize());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("总记录数:"+pageInfo.getTotal());
        /*System.out.println("是否有上一页:"+pageInfo.isHasPreviousPage());
        System.out.println("是否有下一页:"+pageInfo.isHasNextPage());
        System.out.println("导航页面:"+ Arrays.toString(pageInfo.getNavigatepageNums()));*/

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
