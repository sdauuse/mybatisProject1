package com.miao.test;

import com.miao.domain.Teacher;
import com.miao.mapper.TeacherMapper;
import com.miao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/11 - 23:25
 * @commet:
 */
public class ManyToManyTest {

    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.openSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacherList = teacherMapper.queryAllTeachers();
        for(Teacher teacher:teacherList){
            System.out.println(teacher);
        }

        sqlSession.close();
    }
}
