package com.apjfsa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SubjectPreparedStstementOps {

	public static void main(String[] args) throws  SQLException {
		//1.Load the Driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//2.establishing the connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement", "root" , "Neela@1209");
		
		//3.Create Statement
		PreparedStatement pst=connection.prepareStatement("update subject set marks=? where sid=?");
		
		pst.setInt(1, 25);
		pst.setInt(2, 106);
		
		System.out.println(pst.executeUpdate());
		
	    pst.close();
	    connection.close();

	}

}
