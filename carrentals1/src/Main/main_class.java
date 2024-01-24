package Main;

import java.util.Scanner;
import Dao.AdminService;
import Dao.CustomerService;
import Dao.ReservationService;
import Dao.VehicleService;

public class main_class 
{
	public static void main(String... args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("................Welcome Car Rental................");

		System.out.println("Enter 1 for Admin Service");
		System.out.println("Enter 2 for Customer Service");
		System.out.println("Enter 3 for Reservation Service");
		System.out.println("Enter 4 for Vehicle Service");


		int a = sc.nextInt();
		switch(a)
		{
		case 1:
			AdminService.admin_manu();
			break;
		case 2:
			CustomerService.mainual();
			break;
		case 3:
			ReservationService.reservation_manu();
			break;
		case 4:
			VehicleService.vehicle_manu();
			break;
		default:
			System.out.println("Invalide value");
		}
		}
	}