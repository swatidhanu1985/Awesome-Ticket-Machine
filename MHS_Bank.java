import java.util.*;

public class MHS_Bank {
	public String bankName;
	public ArrayList<MHS_BankAccount> accountList = new ArrayList<MHS_BankAccount>();

	public MHS_Bank(String name) {
		bankName = name;
	}

	public void addAccount(String accountNumber, double balance) {
		MHS_BankAccount newAccount = new MHS_BankAccount(accountNumber, balance);
		accountList.add(newAccount);
	}

	public String tryPayment(String accountNumber, double price) {
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).accountNumber.equals(accountNumber)) {
				if (accountList.get(i).accountBalance >= price) {
					accountList.get(i).pay(price);
					return bankName;
				} else {
					return "No coverage";
				}
			}
		}
		return "Invalid bank-account specified";
	}
}