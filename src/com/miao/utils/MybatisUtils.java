package com.miao.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author miaoyin
 * @date 2021/1/10 - 20:31
 * @commet:
 */
public class MybatisUtils {

    public static final SqlSessionFactory sessionFactory;
    //静态代码块，只需要加载一次
    static {
        //1.sqlSessionFactoryBuilder 加载配置文件
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //2.读取配置文件
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("SqlMappingConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3.获取session工厂
        sessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
    }

    public static SqlSession openSession(){
        return sessionFactory.openSession();
    }
}
