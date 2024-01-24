package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import Util.Vehicle_connection;

public class Vehicle 
{
//public static void main(String... args)
	public void vehicle_call()
{
	try
	{
		Scanner sc = new Scanner(System.in);
		
		Connection connection  =  Vehicle_connection.getConnection();
		PreparedStatement prepare = connection.prepareStatement("insert into vehicle value(?,?,?,?,?,?,?,?)");
		System.out.println("Enter the vahicleid");
		int vahicleid = sc.nextInt();
		System.out.println("Enter the Model no");
		int model_no = sc.nextInt();
		System.out.println("Enter the Brand Name");
		String make = sc.next();
		System.out.println("Enter the Year");
		int year = sc.nextInt();
		System.out.println("Enter the Color");
		String color = sc.next();
		System.out.println("Enter the Registration Number");
		int registrationnumber = sc.nextInt();
		System.out.println("Enter the availability");
		String availability = sc.next();
		System.out.println("Enter the DailyRate");
		int dailyrate = sc.nextInt();
		
		prepare.setInt(1,vahicleid);
		prepare.setInt(2,model_no);
		prepare.setString(3,make);
		prepare.setInt(4,year);
		prepare.setString(5,color);
		prepare.setInt(6,registrationnumber);
		prepare.setString(7, availability);
		prepare.setInt(8, dailyrate);
		
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
		Vehicle v = new Vehicle();
		v.vehicle_call();
	}
}
