package com.miao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/11 - 23:02
 * @commet:
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Student {
    private Integer stu_id;
    private String stu_name;

    //一个学生有多个老师，一个老师有多个学生
    private List<Teacher> teachers = new ArrayList<Teacher>();
}
