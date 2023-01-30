package greenbus;

import java.util.*;


public class MainClass {
	Scanner input = new Scanner(System.in);
	static Stack<Object> stack = new Stack<>();
	public TicketBooking book = new TicketBooking();
	public BookingDetails detail = new BookingDetails();
	int choice;
	String name;
	long mobileNum;
	public void mainMenu() {
		choice = 1;
		System.out.println("Welcome to ---\"GREENBUS\"---");

		while (choice != 0) {
			System.out.println("\n1) Ticket Booking \n2) Booking Details \n3) Ticket Cancellation \n0) Exit");
			System.out.print("\nEnter your choice :- ");
			choice = input.nextInt();
			switch (choice) {
			case 1:
				book.bookingMenu();
				break;

			case 2:
				detail.viewTickets();
				break;

			case 3:
				detail.ticketCancel();
				break;

			case 0:
				System.exit(0);
				break;

			default:
				System.out.println("\n InValid choice... ");
				break;
			}
		}
	}

	public static void main(String[] args) {
		MainClass main = new MainClass();
		main.mainMenu();

	}
}
