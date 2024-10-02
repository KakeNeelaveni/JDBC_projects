/*1. Write a program to insert a record and fetch the records from Student table using JDBC.
 *   Student table must have student ID(primary key), name, age, location, phone number as columns
 */
package com.apjfsa.jdbc;
//necessary imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//declaring class
public class StudentImp {
    //main method
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.Load the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.establishing the connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement", "root" , "Neela@1209");
		
		//3.Create Statement
		Statement statement=connection.createStatement();
		
		//4.Define Sql query 5.Executing query
		int count=statement.executeUpdate("insert into student1 values(105,'Jack',25,'Bangalore',905659801)");
		
		//6.Display the result
		System.out.println("No.of records inserted="+count);
		
		ResultSet rset=statement.executeQuery("select * from student1");
		
		while(rset.next())
			System.out.println(rset.getInt(1)+" "+rset.getString(2)+" "+rset.getInt(3)+" "+rset.getString(4)+" "+rset.getLong(5)+" ");
		
		//7.close the connections
		statement.close();
		connection.close();
		

	}
}

/* output:-
 No.of records inserted=1
101 James 22 Hydrabad 8190345621 
102 Mathy 21 Vizag 9190562821 
103 Marry 23 US 1905629821 
104 Rose 22 Chennai 1905629821 
105 Jack 25 Bangalore 905659801 */

/*
creating table
create table student1(id int primary key,name varchar(20),age int,location varchar(20),phno bigint);
fetching student records
select * from student1;
	id	name	age	location	phno
	101	James	22	Hydrabad	8190345621
	102	Mathy	21	Vizag	9190562821
	103	Marry	23	US	1905629821
	104	Rose	22	Chennai	1905629821
	105	Jack	25	Bangalore	905659801
					*/
				

