package edu.miu.cs.cs425.studentmgmt.controller;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value = {"/sysadmin/student"})
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = {"/list"})
   public ModelAndView getAllStudents(){
        var modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.getAllStudents());
        modelAndView.setViewName("sysadmin/student/list");
         return modelAndView;
    }

    @PostMapping(value = {"/new"})
    public String addNewStudent(@Valid @ModelAttribute("student") Student newStudent) {
        studentService.saveStudent(newStudent);
        return "sysadmin/student/new";
    

    }

    @GetMapping(value = {"/update/{id}"})
    public Student updateStudentForm(@PathVariable("id")  long id) {
        Student student = studentService.getStudentById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student", student);
        modelAndView.setViewName("sysadmin/student/edit");

        return student;
    }

    @PostMapping(value = {"/update/{id}"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student, @PathVariable("id") long id) {

        studentService.updateStudent(student, student.getStudentId());
        return "/sysadmin/student/list";
    }

    @GetMapping(value = {"/delete/{id}"})
    public String deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
        return "/sysadmin/student/list";
    }

    @GetMapping(value = {"/student/search"})
    public ModelAndView searchStudent(@RequestParam("search") String search){
        ModelAndView modelAndView = new ModelAndView();
        var student = studentService.searchStudent(search);
        modelAndView.addObject("student", student);
        modelAndView.setViewName("/sysadmin/student/list");
        return modelAndView;


    }
}
