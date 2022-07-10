package edu.miu.cs.cs425.eregistrar.service;


import edu.miu.cs.cs425.eregistrar.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> allStudent();

    Student getStudent(Long id);

    void delete(Long id);

    void save(Student student);

}
