package edu.miu.cs.cs425.studentmgmt;

import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class MyStudentManagmentAppWebApplication implements CommandLineRunner {
	@Autowired
	StudentService studentService;

	public static void main(String[] args) {

		SpringApplication.run(MyStudentManagmentAppWebApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
System.out.println("Hello World");


	}



}
