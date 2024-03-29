package com.bharat.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.bharat.hibernate.demo.entity.Student;

public class QueryStudentsDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			List<Student> list = session.createQuery("from Student").getResultList();
			displayStudents(list);
			list = session.createQuery("from Student s where s.lastName = 'Gupta'").getResultList();
			System.out.println("\n\nDisplay the student with last name of Gupta");
			displayStudents(list);
			list = session.createQuery("from Student s where s.lastName = 'Gupta' OR s.firstName = 'Black'").getResultList();
			System.out.println("\n\nDisplay the student with last name of Gupta or first name of Black");
			displayStudents(list);
			list = session.createQuery("from Student s where s.email LIKE 'b%'").getResultList();
			System.out.println("\n\nDisplay the student with email starting with b");
			displayStudents(list);
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> list) {
		for(Student tempStudent : list) {
			System.out.println(tempStudent);
		}
	}

}
