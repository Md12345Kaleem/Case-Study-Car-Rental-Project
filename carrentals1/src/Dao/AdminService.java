package Dao;
//import java.beans.Statement;
import java.sql.*;
import java.util.Scanner;

import Util.Customer_connection;
import Entity.Admin;
import Entity.Customer;
import Entity.Reservation;
import Entity.Vehicle;
public class AdminService 
{
public void GetAdminById()
{
Connection  con = null;
try 
{
	int adminId;
	ClassforName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hexaware1?useSSL=false&allowPublicKeyRetrieval=true","root","kaleem@12345");
	Statement state = con.createStatement();

ResultSet rs = state.executeQuery("select adminId from admins");
while(rs.next())
{
System.out.print(rs.getInt("adminId"));
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

public void GetAdminByUsername()
{
	Connection  con = null;
	try 
	{
		String admin_username;
		ClassforName("com.mysql."
				+ "jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hexaware1?useSSL=false&allowPublicKeyRetrieval=true","root","kaleem@12345");
		Statement state = con.createStatement();

	ResultSet rs = state.executeQuery("select username from admins");
	while(rs.next())
	{
	System.out.print(rs.getInt("username"));
	}
	}
	catch(Exception e)
	{
		System.out.print(e);
	}	
}
public void RegisterAdmin()
{
	Admin sr = new Admin();
	sr.Admin_call();
}
public void UpdateAdmin()
{
	Connection  con = null;
	try 
	{
//		String username1;
		ClassforName("com.mysql."
				+ "jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hexaware1?useSSL=false&allowPublicKeyRetrieval=true","root","kaleem@12345");
		Statement state = con.createStatement();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the update status ");
    String username = sc.next();
    System.out.println("Enter the registration id ");
    int admin_id = sc.nextInt();
    
//	ResultSet rs = state.executeQuery("update vehicle set username = ? where customer_id = ? ");
    PreparedStatement pre = con.prepareStatement("update admins set username = ? where adminId=?");
    
//	while(rs.next())
//	{
//	System.out.print(rs.getInt("customer_id"));
//	}
    
    pre.setString(1,username);
    pre.setInt(2,admin_id);
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
public void DeleteAdmin()
{
	Connection  con = null;
	try 
	{
		int admin_id=0;
		ClassforName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hexaware1?useSSL=false&allowPublicKeyRetrieval=true","root","kaleem@12345");
		Statement state = con.createStatement();

//	ResultSet rs = state.executeQuery("delete from customer where customer_id = ?");
		PreparedStatement prr = con.prepareStatement("delete from admins where admiId=?");
		prr.setInt(1, admin_id);
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
public static void admin_manu()
{
AdminService cs = new AdminService();
Scanner sc = new Scanner(System.in);
System.out.println("................Welcome Car Rental................");

System.out.println("Enter 1 for Get reservation id");
System.out.println("Enter 2 for Get customer_id");
System.out.println("Enter 3 for Create New reservation");
System.out.println("Enter 4 for Update the reservation details");
System.out.println("Enter 5 for Cancle reservation ");

int a = sc.nextInt();
switch(a)
{
case 1:
	cs.GetAdminById();
	break;
case 2:
	cs.GetAdminByUsername();
	break;
case 3:
	cs.RegisterAdmin();
	break;
case 4:
	cs.UpdateAdmin();
	break;
case 5:
	cs.DeleteAdmin();
	break;
default:
	System.out.println("Invalide value");
}
}
public static void main(String... args)
{
	AdminService.admin_manu();
}
}
