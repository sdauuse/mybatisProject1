package com.miao.mapper;

import com.miao.domain.Student;
import com.miao.domain.Teacher;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/11 - 23:18
 * @commet:
 */
public interface StudentMapper {

    public List<Student> queryStudentByTeacher(Integer teacher_id);

    public void insertStudent(Student student);
}
