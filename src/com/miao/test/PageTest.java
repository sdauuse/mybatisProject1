package com.miao.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miao.domain.Customer;
import com.miao.mapper.CustomerMapper;
import com.miao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/12 - 16:44
 * @commet:
 */
public class PageTest {
    /*分页插件的使用*/
    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        /*使用分页插件*/
        /*第1页，一页5个数据*/
        Page<Customer> page = PageHelper.startPage(1, 5);


        List<Customer> customerList = customerMapper.dynamicQueryCustomerByNameAndPro(null, null);

        PageInfo<Customer> pageInfo = new PageInfo(customerList, 4);
        System.out.println("当前页:" + pageInfo.getPageNum());
        System.out.println("每页显示记录数:" + pageInfo.getPageSize());
        System.out.println("总页数:" + pageInfo.getPages());
        System.out.println("总记录数:" + pageInfo.getTotal());
        System.out.println("是否有上一页:" + pageInfo.isHasPreviousPage());
        System.out.println("是否有下一页:" + pageInfo.isHasNextPage());
        System.out.println("导航页面:" + Arrays.toString(pageInfo.getNavigatepageNums()));

        for (Customer customer : pageInfo.getList()) {
            System.out.println(customer);
        }

        sqlSession.close();
    }
}
