package com.miao.test;

import com.miao.domain.Student;
import com.miao.domain.Teacher;
import com.miao.mapper.StudentMapper;
import com.miao.mapper.TeacherMapper;
import com.miao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
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

    /*查询一个老师带的学生*/
    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.queryStudentByTeacher(2);
        for(Student student:students){
            System.out.println(student);
        }

        sqlSession.close();
    }

    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.openSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student student1 = new Student();
        student1.setStu_name("新学生1");

        Student student2 = new Student();
        student2.setStu_name("新学生2");


        Teacher teacher = new Teacher();
        teacher.setTeacher_name("新老师");

        teacherMapper.insertTeacher(teacher);
        studentMapper.insertStudent(student1);
        studentMapper.insertStudent(student2);

        teacherMapper.insertStuTeacherRel(teacher.getTeacher_id(),student1.getStu_id());
        teacherMapper.insertStuTeacherRel(teacher.getTeacher_id(),student2.getStu_id());

        sqlSession.commit();
        sqlSession.close();

    }
}
