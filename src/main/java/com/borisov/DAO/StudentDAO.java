package com.borisov.DAO;

import com.borisov.entity.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> getAllStudents();

    public void save(Student student);
}
