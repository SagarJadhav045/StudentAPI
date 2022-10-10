package com.student.StudentDemo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
		
	@GetMapping("getstudent")
	public ArrayList<Student> getStudents(){
		ArrayList<Student> students = studentService.getStudent();
		return students;
	}
	
	@PostMapping("addstudent")
	public Student addStudent(@RequestBody Student student) {
		studentService.addorUpdateStudent(student);
		return student ;
	}
	
	@PutMapping("updatestudent")
	public Student updateStudent(@RequestBody Student student) {
		studentService.addorUpdateStudent(student);
		return student;
	}
	
	@DeleteMapping("deletestudent/{id}")
	public int deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
		return id;
	}
}
