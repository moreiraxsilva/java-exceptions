package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("CheckIn date: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("CheckOut date: ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("CheckIn date: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("CheckOut date: ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)){
				System.out.println("Error in reservation: Reservation date for update must be future dates");
			} else if(!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println(reservation);
			}

		}
		
		sc.close();
	}
}
