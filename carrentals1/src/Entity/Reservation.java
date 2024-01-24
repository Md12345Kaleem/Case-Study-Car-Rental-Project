package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import Util.Vehicle_connection;

public class Reservation 
{
//public static void main(String... args)
	public void Reservation_call()
{
	try
	{
		Scanner sc = new Scanner(System.in);
		
		Connection connection  =  Vehicle_connection.getConnection();
		PreparedStatement prepare = connection.prepareStatement("insert into reservation value(?,?,?,?,?,?,?)");
		System.out.println("Enter the Reservationid");
		int reservationid = sc.nextInt();
		System.out.println("Enter the CustomerId");
		int customerid = sc.nextInt();
		System.out.println("Enter the vehicleid");
		int vehicleid = sc.nextInt();
		System.out.println("Enter the Start date");
		String start_date = sc.next();
		System.out.println("Enter the End Date");
		String end_date = sc.next();
		System.out.println("Enter the Total Cost");
		double total_cost = sc.nextDouble();
		System.out.println("Enter the status");
		String status = sc.next();
		
				
		prepare.setInt(1,reservationid);
		prepare.setInt(2,customerid);
		prepare.setInt(3,vehicleid);
		prepare.setString(4,start_date);
		prepare.setString(5,end_date);
		prepare.setDouble(6,total_cost);
		prepare.setString(7, status);
		
		
		long i = prepare.executeUpdate();
		if(i>0)
		{
			System.out.println("inserted.....");
		}
		else
		{
			System.out.println("Failed.....");
		}
	}
	catch(Exception e)
	{
		System.out.print(e);
	}
}
	public static void main(String... args)
	{
		Reservation r = new Reservation();
		r.Reservation_call();
	}
}
