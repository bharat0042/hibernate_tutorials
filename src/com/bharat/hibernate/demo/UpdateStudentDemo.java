package com.bharat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.bharat.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int id = 1;
			Student temp = session.get(Student.class, id);
			temp.setFirstName("You are updated");
			session.getTransaction().commit();
			session = factory.getCurrentSession();
			session.beginTransaction();
			int numberOfItemsUpdated = session.createQuery("Update Student s SET s.email = 'update@gmail.com' where s.email LIKE 'b%'").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Number of items updated is : " + numberOfItemsUpdated);
		}
		finally {
			factory.close();
		}
		
	}

}
