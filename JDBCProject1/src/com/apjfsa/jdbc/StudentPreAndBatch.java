/*1. Write a program to insert, update, delete records from student table using jdbc

  a. Using Prepared Statement 

  b. Using Batch operations*/

package com.apjfsa.jdbc;
//necessary imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
//declaring class
public class StudentPreAndBatch {

	 //main method
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			//1.Load the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.establishing the connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement", "root" , "Neela@1209");
			
			//3.Create PreparedStatement
			//using PreparedStatement to insert record into student1 table
			PreparedStatement pstInsert=connection.prepareStatement("INSERT INTO student1 (id, name, age, location, phno) VALUES (?, ?, ?, ?, ?)");
			pstInsert.setInt(1, 107);
			pstInsert.setString(2, "Rahul");
			pstInsert.setInt(3, 22);
			pstInsert.setString(4, "Mumbai");
			pstInsert.setLong(5, 654783239);
			
			System.out.println("Insert Operation Result: " +pstInsert.executeUpdate());
			//using PreparedStatement to update record
			 PreparedStatement pstUpdate = connection.prepareStatement("update student1 set location=? where id=?");
			 pstUpdate.setString(1,"Jaipur");
			 pstUpdate.setInt(2, 103);
			 System.out.println("Update Operation Result: " +pstUpdate.executeUpdate());
			//using PreparedStatement to delete record
			 PreparedStatement pstDelete = connection.prepareStatement("DELETE FROM student1 WHERE id=?");
			 pstDelete.setInt(1, 106);
			 System.out.println("Delete Operation Result: " +pstDelete.executeUpdate());
			
			
			//3.Create Statement
			Statement statement=connection.createStatement();
			//using Batch to insert/update/delete records from student1 table
			statement.addBatch("insert into student1 values(108,'Antony',23,'Bangalore',9845264731)");
			statement.addBatch("update student1 set location='vijayawada' where id=102");
			statement.addBatch("delete from student1 where id=101");
			
			int[] batch=statement.executeBatch();
			System.out.println("No.of Records inserted/updated/deleted="+batch.length);
			//close the connections
			statement.close();
			pstInsert.close();
			pstUpdate.close();
			pstDelete.close();
			
		    connection.close();

	}

}
/*output:
Insert Operation Result: 1
Update Operation Result: 1
Delete Operation Result: 1
No.of Records inserted/updated/deleted=3

 */


/*	Before insert/update/delete
 * 
 *  id	name	age	location	phno
	101	James	22	Hydrabad	8190345621
	102	Mathy	21	Vizag	9190562821
	103	Marry	23	US	1905629821
	104	Rose	22	Chennai	1905629821
	105	Jack	25	Bangalore	905659801
	106	Adam	24	Pune	675432890
					*/
/*After insert/update/delete
id	name	age	location	phno
102	Mathy	21	vijayawada	9190562821
103	Marry	23	Jaipur	1905629821
104	Rose	22	Chennai	1905629821
105	Jack	25	Bangalore	905659801
107	Rahul	22	Mumbai	654783239
108	Antony	23	Bangalore	9845264731
				*/