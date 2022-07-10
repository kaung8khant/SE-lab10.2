package edu.miu.cs.cs425.eregistrar.service.implementation;

import edu.miu.cs.cs425.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.repository.StudentRepository;
import edu.miu.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> allStudent() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return getStudentByID(id);
    }

    @Override
    public void delete(Long id) {
        Student student = getStudentByID(id);
        studentRepository.delete(student);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }


    private Student getStudentByID(Long id){
        Optional<Student> stu = studentRepository.findById(id);
        return stu.get();
    }
}
