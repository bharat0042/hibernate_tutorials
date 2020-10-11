package com.bharat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.bharat.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int id = 1;
			Student temp = session.get(Student.class, id);
			session.delete(temp);
			session.getTransaction().commit();
			session = factory.getCurrentSession();
			session.beginTransaction();
			int numberOfItemsDeleted = session.createQuery("delete from Student s where s.id = 2").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Number of items deleted is : " + numberOfItemsDeleted);
		}
		finally {
			factory.close();
		}
		
	}

}
