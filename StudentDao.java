package com.student.StudentDemo;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ArrayList<Student> getStudents(){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		ArrayList<Student> stulist = (ArrayList<Student>) criteria.list();
		return stulist;
	}
	
	public void saveAndUpdateStudent(Student student) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(student);
		tx.commit();
	}
	
	public void deleteStudent(int id) {
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.delete(student);
		tx.commit();
	}
}
