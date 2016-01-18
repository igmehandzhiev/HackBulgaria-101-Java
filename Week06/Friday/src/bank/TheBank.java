package bank;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TheBank implements Serializable {
	Map<Integer, BankAccount> accounts;
	
	public TheBank() {
		accounts = new HashMap<>();
	}
	
	public void addClient(BankAccount account, String accountID) {
		Integer accID = Integer.parseInt(accountID);
		accounts.put(accID, account);
	}
	
	public String getBankAccountToString(String accountID) {
		
		if( accounts.containsKey(Integer.parseInt(accountID)) ) {
			return accounts.get(Integer.parseInt(accountID)).toString();
		} else {
			return null;
		}
	}
	
	
	
}
