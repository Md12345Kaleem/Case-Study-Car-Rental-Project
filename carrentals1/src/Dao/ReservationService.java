package Dao;
//import java.beans.Statement;
import java.sql.*;
import java.util.Scanner;

import Util.Customer_connection;
import Entity.Customer;
import Entity.Reservation;
import Entity.Vehicle;
public class ReservationService 
{
public void GetReservationById()
{
Connection  con = null;
try 
{
	int reservatoin_id;
	ClassforName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hexaware1?useSSL=false&allowPublicKeyRetrieval=true","root","kaleem@12345");
	Statement state = con.createStatement();

ResultSet rs = state.executeQuery("select reservationId from reservation");
while(rs.next())
{
System.out.print(rs.getInt("reservationId"));
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

public void GetReservationByCustomerId()
{
	Connection  con = null;
	try 
	{
		int customer_id;
		ClassforName("com.mysql."
				+ "jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hexaware1?useSSL=false&allowPublicKeyRetrieval=true","root","kaleem@12345");
		Statement state = con.createStatement();

	ResultSet rs = state.executeQuery("select customer_id from reservation");
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
public void CreateReservation()
{
	Reservation sr = new Reservation();
	sr.Reservation_call();
}
public void UpdateReservation()
{
	Connection  con = null;
	try 
	{
		int reservation_id;
		ClassforName("com.mysql."
				+ "jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hexaware1?useSSL=false&allowPublicKeyRetrieval=true","root","kaleem@12345");
		Statement state = con.createStatement();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the update status ");
    String status = sc.next();
    System.out.println("Enter the registration id ");
    int reservation_id1 = sc.nextInt();
    
//	ResultSet rs = state.executeQuery("update vehicle set username = ? where customer_id = ? ");
    PreparedStatement pre = con.prepareStatement("update vehicle set statuse = ? where reservationId=?");
    
//	while(rs.next())
//	{
//	System.out.print(rs.getInt("customer_id"));
//	}
    
    pre.setString(1,status);
    pre.setInt(2,reservation_id1);
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
public void CancleReservation()
{
	Connection  con = null;
	try 
	{
		int reservation_id=0;
		ClassforName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hexaware1?useSSL=false&allowPublicKeyRetrieval=true","root","kaleem@12345");
		Statement state = con.createStatement();

//	ResultSet rs = state.executeQuery("delete from customer where customer_id = ?");
		PreparedStatement prr = con.prepareStatement("delete from reservation where reservationId =?");
		prr.setInt(1, reservation_id);
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
public static void reservation_manu()
{
ReservationService cs = new ReservationService();
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
	cs.GetReservationById();
	break;
case 2:
	cs.GetReservationByCustomerId();
	break;
case 3:
	cs.CreateReservation();
	break;
case 4:
	cs.UpdateReservation();
	break;
case 5:
	cs.CancleReservation();
	break;
default:
	System.out.println("Invalide value");
}
}
public static void main(String... args)
{
	ReservationService.reservation_manu();
}
}
