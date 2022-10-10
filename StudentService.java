package com.student.StudentDemo;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

		@Autowired
		StudentDao studentDao;
		
		@Transactional
		public ArrayList<Student> getStudent(){
			ArrayList<Student> alstudent = studentDao.getStudents();
			return alstudent;
		}
		
		@Transactional
		public void addorUpdateStudent(Student student) {
			studentDao.saveAndUpdateStudent(student);
		}
		
		@Transactional
		public void deleteStudent(int id) {
			studentDao.deleteStudent(id);
		}
}
