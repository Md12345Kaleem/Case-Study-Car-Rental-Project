package Dao;
//import java.beans.Statement;
import java.sql.*;
import java.util.Scanner;

import Util.Customer_connection;
import Entity.Customer;
public class CustomerService 
{
public void GetCustomerId()
{
Connection  con = null;
try 
{
	int customer_id;
	ClassforName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hexaware1?useSSL=false&allowPublicKeyRetrieval=true","root","kaleem@12345");
	Statement state = con.createStatement();

ResultSet rs = state.executeQuery("select customer_id from customer");
while(rs.next())
{
System.out.print(rs.getInt("customer_id"));
}
}
catch(Exception e)
{
	System.out.print(e);
}
}
private void ClassforName(String string) {
	// TODO Auto-generated method stub
	
}
public void GetCustomerbyusername()
{
	Connection  con = null;
	try 
	{
		String username;
		ClassforName("com.mysql."
				+ "jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hexaware1?useSSL=false&allowPublicKeyRetrieval=true","root","kaleem@12345");
		Statement state = con.createStatement();

	ResultSet rs = state.executeQuery("select username from customer");
	while(rs.next())
	{
	System.out.print(rs.getString("username"));
	}
	}
	catch(Exception e)
	{
		System.out.print(e);
	}	
}
public void RegisterCustomer()
{
	Customer sr = new Customer();
	sr.customer_call();
}
public void UpdateCustomer()
{
	Connection  con = null;
	try 
	{
		int customer_id;
		ClassforName("com.mysql."
				+ "jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hexaware1?useSSL=false&allowPublicKeyRetrieval=true","root","kaleem@12345");
		Statement state = con.createStatement();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the update user name ");
    String username = sc.next();
    System.out.println("Enter the customer id ");
    int customer_id1 = sc.nextInt();
    
//	ResultSet rs = state.executeQuery("update customer set username = ? where customer_id = ? ");
    PreparedStatement pre = con.prepareStatement("update customer set username = ? where customer_id = ? ");
    
//	while(rs.next())
//	{
//	System.out.print(rs.getInt("customer_id"));
//	}
    
    pre.setString(1, username);
    pre.setInt(2, customer_id1);
    long i = pre.executeUpdate();
    if(i>0)
    {
    	System.out.println("Done..");
    }
    else
    {
    	System.out.println("Sorry....");
    }
	}
	catch(Exception e)
	{
		System.out.print(e);
	}
}
public void DeleteCustomer()
{
	Connection  con = null;
	try 
	{
		int customer_id1 = 0;
		ClassforName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hexaware1?useSSL=false&allowPublicKeyRetrieval=true","root","kaleem@12345");
		Statement state = con.createStatement();

//	ResultSet rs = state.executeQuery("delete from customer where customer_id = ?");
		PreparedStatement prr = con.prepareStatement("delete from customer where customer_id = ?");
		prr.setInt(1, customer_id1);
		long i = prr.executeUpdate();
	    if(i>0)
	    {
	    	System.out.println("Done..");
	    }
	    else
	    {
	    	System.out.println("Sorry....");
	    }

	}
	catch(Exception e)
	{
		System.out.print(e);
	}	
}


//public static void main(String... args)
public static void mainual()

{
CustomerService cs = new CustomerService();
Scanner sc = new Scanner(System.in);
System.out.println("................Welcome Car Rental................");

System.out.println("Enter 1 for Get Customer id");
System.out.println("Enter 2 for Customer Username");
System.out.println("Enter 3 for Register Customer");
System.out.println("Enter 4 for Update the customer details");
System.out.println("Enter 5 for Delete customer details");

int a = sc.nextInt();
switch(a)
{
case 1:
	cs.GetCustomerId();
	break;
case 2:
	cs.GetCustomerbyusername();
	break;
case 3:
	cs.RegisterCustomer();
	break;
case 4:
	cs.UpdateCustomer();
	break;
case 5:
	cs.DeleteCustomer();
	break;
default:
	System.out.println("Invalide value");
}
}
public static void main(String... args)
{
	CustomerService.mainual();
}
}
