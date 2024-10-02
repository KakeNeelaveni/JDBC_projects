package com.apjfsa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SubjectImp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.Load the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.establishing the connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement", "root" , "Neela@1209");
		
		//3.Create Statement
		Statement statement=connection.createStatement();
		
		//4.Define Sql query 5.Executing query
		//int count=statement.executeUpdate("insert into subject values(104,'Science',30,70)");
		
		//6.Display the result
		//System.out.println("No.of records inserted="+count);
		
		ResultSet rset=statement.executeQuery("select * from subject");
		
		while(rset.next())
			System.out.println(rset.getInt(1)+" "+rset.getString(2)+" "+rset.getInt(3)+" "+rset.getInt(4));
		
		//7.close the connections
		statement.close();
		connection.close();
		

	}
	

}

/*public static void main(String[] args) throws SQLException {
		
		Connection connection=null;
		Statement statement=null;
		try {
      //1.Load the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2. establishing the connection
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmgmt", 
				"root", "chaitanya@12");
		
		//3. Create Statement
	    statement=connection.createStatement();
		
		//4.Define Sql query 5.Executing query
		int count=statement.executeUpdate("insert into subject values(103,'English',100,0)");
		
		// 6.Display the result
		System.out.println("No.of records inserted="+count);
		
		ResultSet rset = statement.executeQuery("select * from subject");
		
		while(rset.next())
			System.out.println(rset.getInt(1)+" "+rset.getString(2)+" "+rset.getInt(3)+" "+
		     rset.getInt(4));
			
		}catch(SQLException e) {
			System.out.println(e);
			
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		finally {
		//7.close the connections
		statement.close();
		connection.close();
		}
	}*/
