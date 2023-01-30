package greenbus;

import java.util.*;

public class BookingDetails {
	Scanner input = new Scanner(System.in);
	public static ArrayList<Ticket> ticketList = new ArrayList<>();
	Ticket tempTicket;

	public void viewTickets() {
		tempTicket = null;
		int count = 0;
		long mobileNum = 1;
		while (mobileNum != 0) {
			System.out.println("\n\t\t BOOKING DETAILS \nTo Continue Enter your Registered Mobile Number :- \n9) Go Back \n 0) Exit \nEnter the Number :- ");
			mobileNum = input.nextLong();

			if (mobileNum == 9)
				return;
			else if (mobileNum == 0)
				System.exit(0);
			else {
				for (int i = 0; i < ticketList.size(); i++) {
					tempTicket = ticketList.get(i);
					if (mobileNum == tempTicket.mobNum)
						System.out.println("\nWelcome " + tempTicket.name + "\tTicket Number : " + tempTicket.ticketId
							+ ")\tFrom : " + tempTicket.fromPlace + "\tTo : " + tempTicket.toPlace
							+ "\tDeparture Time : " + tempTicket.depTime + "\tPassengers Count : "
							+ tempTicket.passCount + "\tTicket Status : " + tempTicket.status);
					else
						count++;
				}

				if (count == ticketList.size())
					System.out.println("\nMobile Number is not Registered...");
			}
		}
	}

	public void ticketCancel() {
		tempTicket = null;
		int count = 0;
		long mobileNum = 1;
		while (mobileNum != 0) {
			System.out.print("\n\t\t TICKET CANCELLATION \nTo Continue Enter your Registered Mobile Number :- \n9) Go Back \n 0) Exit \nEnter the Number :- ");
			mobileNum = input.nextLong();

			if (mobileNum == 9)
				return;
			else if (mobileNum == 0)
				System.exit(0);
			else {
				for (int i = 0; i < ticketList.size(); i++) {
					tempTicket = ticketList.get(i);
					if (mobileNum == tempTicket.mobNum && tempTicket.status != TicketStatus.CANCELLED)
						System.out.println(" \nWelcome " + tempTicket.name + "\tTicket Number : " + tempTicket.ticketId
							+ ")\tFrom : " + tempTicket.fromPlace + "\tTo : " + tempTicket.toPlace
							+ "\tDeparture Time : " + tempTicket.depTime + "\tPassengers Count : "
							+ tempTicket.passCount + "\tTicket Status : " + tempTicket.status);
					else
						count++;
				}
			}

			if (count == ticketList.size())
				System.out.println("\nMobile Number is not Registered...");
			else {
				int ticketNum = 1;
				count = 0;
				while (ticketNum != 0) {
					System.out.print("\nEnter the Ticket Number to Cancel \n9) Go Back \n 0) Exit \nEnter the Number :- ");
					ticketNum = input.nextInt();

					if (mobileNum == 9)
						this.ticketCancel();
					else if (mobileNum == 0)
						System.exit(0);

					for (int i = 0; i < ticketList.size(); i++) {
						tempTicket = ticketList.get(i);
						if (ticketNum == tempTicket.ticketId && tempTicket.status != TicketStatus.CANCELLED) {
							tempTicket.status = TicketStatus.CANCELLED;
							System.out.println("\nTicket Cancelled Successfully...");
							break;
						}
						else
							count++;
					}

					if (count == ticketList.size())
						System.out.println("Ticket not Found...");
				}
			}
		}
	}
}
