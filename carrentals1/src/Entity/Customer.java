	package Entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Scanner;

import Util.Customer_connection;
public class Customer 
{
public void customer_call()

//public static void main(String... args)
{
	try
	{
		Scanner sc = new Scanner(System.in);
		Connection connection = Customer_connection.getConnection();
		PreparedStatement prepare = connection.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?,?)");
		System.out.println("Enter the Customer id");
		int customer_id = sc.nextInt();
		System.out.println("Enter the first name");
		String first_name = sc.next();
		System.out.println("Enter the last name");
		String last_name = sc.next();
		System.out.println("Enter the email");
		String email = sc.next();
		System.out.println("Enter phonenumber");
		int phonenumber = sc.nextInt();
		System.out.println("Enter the address");
		String address = sc.next(); 
		System.out.println("Enter the Username");
		String username = sc.next();
		System.out.println("Enter the password");
		int password = sc.nextInt();
		System.out.println("Enter the registration date");
		String registrationdate = sc.next();
		
		prepare.setInt(1,customer_id);
		prepare.setString(2, first_name);
		prepare.setString(3,last_name);
		prepare.setString(4,email);
		prepare.setInt(5,phonenumber);
		prepare.setString(6,address);  
		prepare.setString(7,username);
		prepare.setInt(8,password);
		prepare.setString(9, registrationdate);
		
		long i = prepare.executeUpdate();
		if(i>0)
		{
			System.out.println("Successfully Register...");
		}
		else 
		{
			System.out.println("No Register....");
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
public static void main(String... args)
{
	Customer c =  new Customer();
	c.customer_call();
}
}
