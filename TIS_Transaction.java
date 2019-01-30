
import java.util.List;

public class TIS_Transaction {

	MHS_Main mhs = new MHS_Main();

	static void displayReceipt(int ticketTypeSelected, String accountNumber, List<TIS_Ticket> ticketTypes) {

		System.out.println("Payment is successful...");

		System.out.println("*******Ticket Receipt********");
		System.out.println("------------------------------\n");
		System.out.println("Ticket Type issued: " + getTicketTypeName(ticketTypes, ticketTypeSelected -1));
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Ticket price: " + getTicketPrice(ticketTypes, ticketTypeSelected -1));
		System.out.println("-----Thank you------\n");

	}

	public String makePayment(String accountNumber, int userChoice, List<TIS_Ticket> ticketTypes) {

		double ticketPrice = getTicketPrice(ticketTypes, userChoice);
		return mhs.tryTransaction(ticketPrice, accountNumber);
	}

	static double getTicketPrice(List<TIS_Ticket> ticketTypes, int ticketTypeSelected) {
		return ticketTypes.get(ticketTypeSelected - 1).tPrice;
	}

	static String getTicketTypeName(List<TIS_Ticket> ticketTypes, int ticketTypeSelected) {
		return ticketTypes.get(ticketTypeSelected).type;
	}
}
