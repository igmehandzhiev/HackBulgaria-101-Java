package bank;

import java.io.IOException;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class Main {

	public static void main(String[] args) {
		/*BankAccount ba = new BankAccount("Acc", "One", "32", "10050", "2123213");
		ba.add("20");
		ba.withdraw("60");
		ba.add("500");
		ba.withdraw("700");
		ba.add("60");
		ba.withdraw("90");
		
		BankAccount ba2 = new BankAccount("Acc", "Two", "23", "2000", "5322357");
		ba2.add("25");
		ba2.withdraw("80");
		ba2.add("523");
		ba2.withdraw("40");
		ba2.add("30");
		
		TheBank myBank = new TheBank();
		myBank.addClient(ba, "" + ba.getID());
		myBank.addClient(ba2, "" + ba2.getID());
		
		System.out.println(myBank.getBankAccountToString("5322357"));
		System.out.println(myBank.getBankAccountToString("2123213"));
		
		try {
			BankStateManger.saveBank(myBank, "/home/georgi/tmp/SavedBank1.ser");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		TheBank retrievedBank = null;
		try {
			retrievedBank = BankStateManger.retrieveBank("/home/georgi/tmp/SavedBank1.ser");
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(retrievedBank.getBankAccountToString("5322357"));
		System.out.println(retrievedBank.getBankAccountToString("2123213"));
	}
	
	

}
