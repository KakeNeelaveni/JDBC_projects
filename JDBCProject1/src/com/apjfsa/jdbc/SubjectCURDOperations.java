package com.apjfsa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SubjectCURDOperations {
	
	PreparedStatement pstatement;
    Scanner sc;
    //insert
    void insertSubject(Connection con,Scanner scanner) {
    	try {
			pstatement=con.prepareStatement("insert into subject values(?,?,?,?)");
			System.out.println("Enter the values for the subject to insert the record\n sid:");
			sc=scanner;
			int sid=sc.nextInt();
			pstatement.setInt(1, sid);
			System.out.println("Enter name of the subject:");
			String s_name=sc.next();
			pstatement.setString(2, s_name);
			System.out.println("Enter practical marks for the subject:");
			int practical=sc.nextInt();
			pstatement.setInt(3, practical);
			System.out.println("Enter  marks for the subject:");
			int marks=sc.nextInt();
			pstatement.setInt(4, marks);
			//execute the query
			System.out.println("No.of records inserted:"+pstatement.executeUpdate());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //update
    void updateSubject(Connection con,Scanner scanner) {
    	try {
    		System.out.println("Enter your choice\n1.update subject name\n2.update practical marks \n3.update theory marks ");
    		sc=scanner;
    		int option=sc.nextInt();
    		switch(option){
    		case 1:pstatement=con.prepareStatement("update subject set s_name=? where sid=?");
    		       System.out.println("Enter subject name and id");
    		       pstatement.setString(1, sc.next());
    		       pstatement.setInt(2, sc.nextInt());
    		       System.out.println("Update records"+ pstatement.executeUpdate());
    		       break;
    		case 2:pstatement=con.prepareStatement("update subject set practical=? where sid=?");
		       System.out.println("Enter subject practical marks and id");
		       pstatement.setInt(1, sc.nextInt());
		       pstatement.setInt(2, sc.nextInt());
		       System.out.println("Update records"+ pstatement.executeUpdate());
		       break;
    		case 3:pstatement=con.prepareStatement("update subject set marks=? where sid=?");
		       System.out.println("Enter subject marks and id");
		       pstatement.setInt(1, sc.nextInt());
		       pstatement.setInt(2, sc.nextInt());
		       System.out.println("Update records"+ pstatement.executeUpdate());
		       break;
		    default:
		    	System.out.println("Enter valid option");
    		     break;  
    		}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //delete
    void deleteSubject(Connection con, Scanner scanner) {
    	try {
			pstatement=con.prepareStatement("delete from subject where sid=?");
			System.out.println("Enter sid for deleting the record");
			sc=scanner;
			int sid=sc.nextInt();
			pstatement.setInt(1, sid);
			System.out.println("No.of records deleted:"+pstatement.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    }
    //select all
    void getAllSubject(Connection con) {
    	try {
			pstatement=con.prepareStatement("select * from subject");
			
			ResultSet rSet=pstatement.executeQuery();
			System.out.println("------------------------------------------------------------------------");
			while(rSet.next())
				System.out.println(rSet.getInt(1)+" "+rSet.getString(2)+" "+rSet.getInt(3)+" "+rSet.getInt(4)+" ");
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    }
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//1.Load the Driver class
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//2.establishing the connection
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement", "root" , "Neela@1209");
		//PreparedStatement pst=connection.prepareStatement("update subject set theory=? where sid=?");

		SubjectCURDOperations subjectc=new SubjectCURDOperations();
		
		while(true) {
			System.out.println("Select Your Choice.\n 1.Insert Subject\n2.Update Subject\n3.Delete Record\n4.Get All Subjects\n5.Exit:\nEnter your choice:");
			Scanner scanner=new Scanner(System.in);
			int choice=scanner.nextInt();
			switch(choice) {
			case 1:
				subjectc.insertSubject(connection, scanner);
				break;
			case 2:
				subjectc.updateSubject(connection,scanner);
				break;
			case 3:
				subjectc.deleteSubject(connection, scanner);
				break;
			case 4:
				subjectc.getAllSubject(connection);
				break;
			case 5:
				System.out.println("That it for today. Bye Bye!");
				System.exit(0);
				break;
			default:
				System.out.println("Enter the valid option");
				break;
			}
		}

	}

}
