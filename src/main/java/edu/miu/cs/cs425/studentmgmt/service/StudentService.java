package edu.miu.cs.cs425.studentmgmt.service;

import edu.miu.cs.cs425.studentmgmt.model.Student;

import java.util.List;


public interface StudentService {

    public abstract Student saveStudent(Student student);

    public abstract List<Student> getAllStudents();

    public abstract Student getStudentById(long id);

    public abstract void updateStudent(Student student, long id);

    public abstract void deleteStudent(long id);

    public abstract Student searchStudent(String name);
}
