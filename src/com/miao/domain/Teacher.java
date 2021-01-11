package com.miao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/11 - 23:03
 * @commet:
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Teacher {
    private Integer teacher_id;
    private String teacher_name;

    //一个学生有多个老师，一个老师有多个学生
    private List<Student> students = new ArrayList<Student>();
}
