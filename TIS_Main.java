import java.util.List;
import java.util.Scanner;

public class TIS_Main {

	public static void main(String[] args) {

		int isExit = 0;
		int userChoice;
		int ticketTypeSelected = 0;
		String accountNumber = "";

		TIS_PrepareSystem prepare = new TIS_PrepareSystem();
		TIS_Transaction transaction = new TIS_Transaction();

		List<TIS_Ticket> ticketTypes = prepare.generateTickets();

		while (isExit != 3) {
			showMenu();
			userChoice = readUsersChoice();

			switch (userChoice) {

			case 1:
				showTicketOptions(ticketTypes);
				break;
			case 2:
				ticketTypeSelected = getTicketType();
				if (ticketTypeSelected < 1 || ticketTypeSelected > 5) {
					System.out.println("Wrong Choice");
					break;
				}

				accountNumber = getAccountNumber();

				String returnStatement = transaction.makePayment(accountNumber, userChoice, ticketTypes);
				if (returnStatement.equals("Invalid clearing-number specified") || returnStatement.equals("No coverage")
						|| returnStatement.equals("Invalid bank-account specified")) {
					System.out.println("Transaction failed.. please try with correct bank account or check balance.");
				} else {
					transaction.displayReceipt(userChoice, accountNumber, ticketTypes);
				}

				break;

			case 3:
				isExit = 3;
				System.out.println("System is offline now. Please restart.");
				break;

			default:
				System.out.println("Wrong Choice!!! Please Try again!!!");
				break;

			}
		}

	}

	public static void showMenu() {
		// show menu 1. buy 2. exit

		System.out.println("Select Your Choice:");
		System.out.println("1: Show all tickets");
		System.out.println("2: Buy new ticket");
		System.out.println("3: Exit");

		System.out.print("Choose your Choice: ");

	}

	public static int readUsersChoice() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();

	}

	public static void showTicketOptions(List ticketTypes) {
		System.out.println("------------------------------------------------------------------------------- ");
		for (int i = 0; i < ticketTypes.size(); i++) {
			TIS_Ticket ticket = (TIS_Ticket) ticketTypes.get(i);
			System.out.println(ticket.type + "\t\t" + ticket.tAgeLowerLimit + "-" + ticket.tAgeUpperLimit + "\t"
					+ ticket.tInfo + "\t\t\t\t" + ticket.tPrice);
		}

		System.out.println("-------------------------------------------------------------------------------- ");
		System.out.println("\n");
	}

	public static String getAccountNumber() {
		System.out.println("Enter Account number ( Follow this format:12XX-123xxx) :");
		Scanner scan = new Scanner(System.in);
		return scan.next();

	}

	public static int getTicketType() {
		System.out.println(
				"Enter ticket type: (1 for child   2 for Young   3 for Adult   4 for senior    5 for Family):");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();

	}

	public void showError() {
		System.out.println("******Account number is incorrect. Try again please.********\n");
	}

}
