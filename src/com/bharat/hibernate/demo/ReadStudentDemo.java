package com.bharat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.bharat.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			Student tempStudent = new Student("Donald", "Trumps", "dt@spring.com");
			session.beginTransaction();
			session.save(tempStudent);
			session.getTransaction().commit();
			
			System.out.println(">> Getting the student from database using id : " + tempStudent.getId());
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student retrieved = session.get(Student.class, tempStudent.getId());
			session.getTransaction().commit();
			System.out.println(retrieved);
		}
		finally {
			factory.close();
		}
		
	}

}
