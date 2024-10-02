package com.apjfsa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SubjectOps {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//1.Load the Driver class
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//2.establishing the connection
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement", "root" , "Neela@1209");
				
				//3.Create Statement
				Statement statement=connection.createStatement();
				
				/*String query="update subject set practical=20 where sid=101";
				int n=statement.executeUpdate(query);
				System.out.println("No .of Rows updated="+n);
				
				String query1="delete from subject where sid=103";
				int n2=statement.executeUpdate(query1);
				System.out.println("No .of Rows deleted="+n2);*/
				
				statement.addBatch("insert into subject values(105,'chemistry',30,70)");
				statement.addBatch("insert into subject values(106,'Biology',40,60)");
				statement.addBatch("insert into subject values(103,'English',20,80)");
				statement.addBatch("insert into subject values(107,'Social',30,70)");
				statement.addBatch("update subject set marks=90 where sid=102");
				statement.addBatch("update subject set practical=10 where sid=101");
				int[] batch=statement.executeBatch();
				
				System.out.println("No.of Records inserted/updated="+batch.length);
				statement.close();
				connection.close();

	}

}
