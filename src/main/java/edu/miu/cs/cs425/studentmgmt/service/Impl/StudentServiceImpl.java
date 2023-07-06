package edu.miu.cs.cs425.studentmgmt.service.Impl;

import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.repositories.StudentRepository;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentRepository studentRepository;


    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void updateStudent(Student student, long id) {
        Student student1 = studentRepository.findById(id).orElse(null);
        assert student1 != null;
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setStudentNumber(student.getStudentNumber());
        student1.setCgpa(student.getCgpa());
        studentRepository.save(student1);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student searchStudent(String name) {
        return studentRepository.findStudentByFirstNameContaining(name);
    }
}
