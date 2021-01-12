package com.miao.mapper;

import com.miao.domain.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/11 - 23:18
 * @commet:
 */
public interface TeacherMapper {
    public List<Teacher> queryAllTeachers();

    /*插入老师*/
    public void  insertTeacher(Teacher teacher);

    /*插入关系*/
    public void insertStuTeacherRel(@Param("teacher_id") Integer teacher_id, @Param("stu_id") Integer stu_id);
}
