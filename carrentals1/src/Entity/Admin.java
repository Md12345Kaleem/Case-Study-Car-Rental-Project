package Entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Scanner;

import Util.Customer_connection;

public class Admin 
{
//public static void main(String... args)
	public void Admin_call()
{
	try
	{
		Scanner sc = new Scanner(System.in);
		Connection connection = Customer_connection.getConnection();
		PreparedStatement prepare = connection.prepareStatement("insert into admins values(?,?,?,?,?,?,?,?,?)");
		System.out.println("Enter the Admin id");
		int admin_id = sc.nextInt();
		System.out.println("Enter the first name");
		String first_name = sc.next();
		System.out.println("Enter the last name");
		String last_name = sc.next();
		System.out.println("Enter the email");
		String email = sc.next();
		System.out.println("Enter phonenumber");
		int phonenumber = sc.nextInt();
		System.out.println("Enter the Username");
		String username = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		System.out.println("Enter the role admin");
		String role_admin= sc.next(); 
		System.out.println("Enter the join date");
		String join_date = sc.next();
		
		prepare.setInt(1,admin_id);
		prepare.setString(2, first_name);
		prepare.setString(3,last_name);
		prepare.setString(4,email);
		prepare.setInt(5,phonenumber);
		prepare.setString(8,role_admin);  
		prepare.setString(6,username);
		prepare.setString(7,password);
		prepare.setString(9, join_date);
		
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
		Admin ad = new Admin();
		ad.Admin_call();
	}
}
