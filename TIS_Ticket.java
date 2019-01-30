public class TIS_Ticket {

	String type;
	int tAgeLowerLimit;
	int tAgeUpperLimit;
	String tInfo;
	double tPrice;

	TIS_Ticket(String type, int ageLower, int ageUpper, String info, double price) {
		this.type = type;
		this.tAgeLowerLimit = ageLower;
		this.tAgeUpperLimit = ageUpper;
		this.tInfo = info;
		this.tPrice = price;
	}

}
