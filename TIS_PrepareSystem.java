import java.util.ArrayList;
import java.util.List;

public class TIS_PrepareSystem {

	public List<TIS_Ticket> generateTickets() {
		List<TIS_Ticket> ticketTypes = new ArrayList<TIS_Ticket>();

		ticketTypes.add(new TIS_Ticket("Child", 0, 10, "For alla personer som fyllt minst 1 ĺr och max 10 ĺr", 10.00));
		ticketTypes
				.add(new TIS_Ticket("Young", 11, 17, "För alla personer som fyllt minst 11 ĺr och max 17 ĺr", 15.50));
		ticketTypes
				.add(new TIS_Ticket("Adult", 18, 64, "För alla personer som fyllt minst 18 ĺr och max 64 ĺr", 22.50));
		ticketTypes.add(new TIS_Ticket("Senior", 65, 100, "För alla personer som fyllt minst 64 ĺr",           15.00));
		ticketTypes.add(new TIS_Ticket("Family", 0, 0, "För en samling av personer, bestĺende av",             40.00));
		ticketTypes.add(new TIS_Ticket(" ", 0, 0, "Minst 1 Adult eller Senior, max 2 Adult eller Senior", 0));
		ticketTypes.add(new TIS_Ticket("  ", 0, 0, "Minst 1 child, max 3 child",                            0));

		System.out.println("Ticket types loaded.....");

		return ticketTypes;
	}

}
