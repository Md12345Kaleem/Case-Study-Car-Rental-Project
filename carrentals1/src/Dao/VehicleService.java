package Dao;
//import java.beans.Statement;
import java.sql.*;
import java.util.Scanner;

import Util.Customer_connection;
import Entity.Customer;
import Entity.Vehicle;
public class VehicleService 
{
public void GetVehicleById()
{
Connection  con = null;
try 
{
	int vehicle_id;
	ClassforName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hexaware1?useSSL=false&allowPublicKeyRetrieval=true","root","kaleem@12345");
	Statement state = con.createStatement();

ResultSet rs = state.executeQuery("select vehicle_id from vehicle");
while(rs.next())
{
System.out.print(rs.getInt("vehicle_id"));
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

public void GetAvailableVehicle()
{
	Connection  con = null;
	try 
	{
		String availability;
		ClassforName("com.mysql."
				+ "jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hexaware1?useSSL=false&allowPublicKeyRetrieval=true","root","kaleem@12345");
		Statement state = con.createStatement();

	ResultSet rs = state.executeQuery("select availability from vehicle");
	while(rs.next())
	{
	System.out.print(rs.getString("availability"));
	}
	}
	catch(Exception e)
	{
		System.out.print(e);
	}	
}
public void AddVehicle()
{
	Vehicle sr = new Vehicle();
	sr.vehicle_call();
}
public void UpdateVehicle()
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
    System.out.println("Enter the update Vehicle model ");
    String model= sc.next();
    System.out.println("Enter the Vehicle id ");
    int vehicle_id1 = sc.nextInt();
    
//	ResultSet rs = state.executeQuery("update vehicle set username = ? where customer_id = ? ");
    PreparedStatement pre = con.prepareStatement("update vehicle set model = ? where vehicle_id = ? ");
    
//	while(rs.next())
//	{
//	System.out.print(rs.getInt("customer_id"));
//	}
    
    pre.setString(1, model);
    pre.setInt(2, vehicle_id1);
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
public void RemoveVehicle()
{
	Connection  con = null;
	try 
	{
		int vehicle_id1 = 0;
		ClassforName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hexaware1?useSSL=false&allowPublicKeyRetrieval=true","root","kaleem@12345");
		Statement state = con.createStatement();

//	ResultSet rs = state.executeQuery("delete from customer where customer_id = ?");
		PreparedStatement prr = con.prepareStatement("delete from vehicle where vehicle_id = ?");
		prr.setInt(1, vehicle_id1);

	}
	catch(Exception e)
	{
		System.out.print(e);
	}	
}


//public static void main(String... args)
public static void vehicle_manu()
{
VehicleService cs = new VehicleService();
Scanner sc = new Scanner(System.in);
System.out.println("................Welcome Car Rental................");

System.out.println("Enter 1 for Get Vehicle id");
System.out.println("Enter 2 for Get availability");
System.out.println("Enter 3 for Register New Vehicle");
System.out.println("Enter 4 for Update the vehicle details");
System.out.println("Enter 5 for Delete vehicle details");

int a = sc.nextInt();
switch(a)
{
case 1:
	cs.GetVehicleById();
	break;
case 2:
	cs.GetAvailableVehicle();
	break;
case 3:
	cs.AddVehicle();
	break;
case 4:
	cs.UpdateVehicle();;
	break;
case 5:
	cs.RemoveVehicle();
	break;
default:
	System.out.println("Invalide value");
}
}
public static void main(String... args)
{
	VehicleService.vehicle_manu();
}
}
