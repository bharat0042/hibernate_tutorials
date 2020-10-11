package com.bharat.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {

		String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("Connecting to database : " + jdbcURL);
			Connection myCon = DriverManager.getConnection(jdbcURL, user, pass);
			System.out.println("Connecting to database successful");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

