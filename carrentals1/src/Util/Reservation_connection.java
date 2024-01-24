package Util;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Reservation_connection
{
private Reservation_connection()
{
	
}
public static Connection getConnection()
{
Connection con = null;
try
{
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hexaware1?useSSL=false&allowPublicKeyRetrieval=true","root","kaleem@12345");
}
catch(Exception e)
{
	System.out.println(e);
}
return con;
}
//public static Statement createStatement() {
//	// TODO Auto-generated method stub
//	return null;
//}
}
