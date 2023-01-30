package greenbus;

import java.util.*;

public class TicketBooking {
	Scanner input = new Scanner(System.in);
	public BookingDetails detail = new BookingDetails();
	public static MainClass main = new MainClass();
	int choice = 0, choose = 0, fare = 0, count = 0;

	public void bookingMenu() {
		choice = 1;
		while (choice != 0) {
			System.out.println("\n1) Chennai to Tenkasi \n2) Chennai to Coimbatore \n3) Tenkasi to Chennai \n4) Coimbatore to Chennai \n9) Go Back \n0) Exit");	
			System.out.print("\nEnter your choice :- ");
			choice = input.nextInt();
			switch (choice) {
			case 1:
				fare = 900;
				this.travel();
				break;

			case 2:
				fare = 850;
				this.travel();
				break;

			case 3:
				fare = 900;
				this.travel();
				break;

			case 4:
				fare = 850;
				this.travel();
				break;

			case 9:
				main.mainMenu();
				break;

			case 0:
				System.out.println("---Thank You---\n Visit Again...");
				System.exit(0);
				break;

			default:
				System.out.println("\n InValid choice... ");
				break;
			}
		}
	}

	public void travel() {
		if (choice == 1) {
			System.out.println(
					"\n\nFrom : Chennai \n\nTo : Tenkasi \n\nDeparture Time : 19:45 \n\nDuration : 13 Hours \n\nFare : "
							+ fare);
		}

		else if (choice == 2) {
			System.out.println(
					"\n\nFrom : Chennai \n\nTo : Coimbatore \n\nDeparture Time : 20:15 \n\nDuration : 10 Hours \n\nFare : "
							+ fare);
		}

		else if (choice == 3) {
			System.out.println(
					"\n\nFrom : Tenkasi \n\nTo : Chennai \n\nDeparture Time : 18:30 \n\nDuration : 13 Hours \n\nFare : "
							+ fare);
		}

		else if (choice == 4) {
			System.out.println(
					"\n\nFrom : Coimbatore \n\nTo : Chennai \n\nDeparture Time : 21:00 \n\nDuration : 10 Hours \n\nFare : "
							+ fare);
		}
		
		choose = 1;
		while (choose != 0) {
			System.out.println("\n\n1) To Continue \n9) Go Back");
			System.out.print("\nChoose Your Option :- ");
			choose = input.nextInt();

			if (choose == 1)
				this.details();

			else if (choose == 9)
				this.bookingMenu();

			else if (choose == 0) {
				System.out.println("---Thank You---\n Visit Again...");
				System.exit(0);
			}
			else
				System.out.print(" Invalid Option... ");
		}

	}

	public void details() {
		System.out.print("\nEnter your Name :- ");
		input.next();
		String name = input.nextLine();
		
		System.out.print("\nMobile Number :- ");
		long mobileNum = input.nextLong();
		
		System.out.print("\nNo. of Passangers :- ");
		count = input.nextInt();
		
		System.out.println("\nTotal Fare :- " + count * fare);

		choose = 1;
		while (choose != 0) {
			System.out.println("\n1) Confirm Booking \n9) Go Back \n0) Exit");
			System.out.print("\nChoose Your Option :- ");
			choose = input.nextInt();

			if (choose == 1)
				this.confirm(name, mobileNum);

			else if (choose == 9) 
				this.travel();
			else if (choose == 0) {
				System.out.println("---Thank You---\n Visit Again...");
				System.exit(0);
			}

			else
				System.out.print(" Invalid Option... ");
		}
	}

	public void confirm(String name, long mobNum) {
		Ticket currTicket = null;
		if (choice == 1) {
			System.out.println(
					"\n\nFrom : Chennai \n\nTo : Tenkasi \n\nDeparture Time : 19:45 \n\nDuration : 13 Hours \n\nFare : "
							+ count * fare);
			currTicket = new Ticket("Chennai", "Tenkasi", name, mobNum, "19:45", count * fare, count);
		}

		else if (choice == 2) {
			System.out.println(
					"\n\nFrom : Chennai \n\nTo : Coimbatore \n\nDeparture Time : 20:15 \n\nDuration : 10 Hours \n\nFare : "
							+ count * fare);
			currTicket = new Ticket("Chennai", "Coimbatore", name, mobNum, "20:15", count * fare, count);
		}

		else if (choice == 3) {
			System.out.println(
					"\n\nFrom : Tenkasi \n\nTo : Chennai \n\nDeparture Time : 18:30 \n\nDuration : 13 Hours \n\nFare : "
							+ count * fare);
			currTicket = new Ticket("Tenkasi", "Chennai", name, mobNum, "18:30", count * fare, count);
		}

		else if (choice == 4) {
			System.out.println(
					"\n\nFrom : Coimbatore \n\nTo : Chennai \n\nDeparture Time : 21:00 \n\nDuration : 10 Hours \n\nFare : "
							+ count * fare);
			currTicket = new Ticket("Coimbatore", " Chennai", name, mobNum, "21:00", count * fare, count);
		}

		BookingDetails.ticketList.add(currTicket);

		System.out.println(
				"\n\nWe have sent you the Payment link to your Mobile Number...\n After Payment the Booking is Confirmed... \n\t Thank You...");
		
		choose = 1;
		while (choose != 9) {
			System.out.println("\n\n9) Go Back \n0) Exit");
			System.out.print("\nChoose Your Option :- ");
			choose = input.nextInt();

			if (choose == 9) 
				this.travel();
			else if (choose == 0) { 
				System.out.println("---Thank You---\n Visit Again...");
				System.exit(0);
			}
			else
				System.out.print(" Invalid Option... ");
		}
	}
}

//---------------------------------------------------------------------------------

class Ticket {
	private static int bookingId = 101;
	int ticketId;
	String fromPlace;
	String toPlace;
	String name;
	long mobNum;
	String depTime;
	int fare;
	int passCount;
	TicketStatus status;

	// TicketType;
	public Ticket(String fromPlace, String toPlace, String name, long mobNum, String depTime, int fare, int passCount) {
		this.ticketId = bookingId++;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.name = name;
		this.mobNum = mobNum;
		this.depTime = depTime;
		this.fare = fare;
		this.passCount = passCount;
		this.status = TicketStatus.BOOKED;
	}

}
