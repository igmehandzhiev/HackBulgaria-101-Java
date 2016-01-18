package bank;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Queue;

//exceptions in different classes
class InsuffitientFundsException extends RuntimeException {
	
	public InsuffitientFundsException() {
		super();
	}
	
	public InsuffitientFundsException(String message) {
		super(message);
	}
	
}

//or cantwithdrawexception
class InterestHigherThanPermittedException extends RuntimeException {
	
	public InterestHigherThanPermittedException() {
		super();
	}
	
	public InterestHigherThanPermittedException(String message) {
		super(message);
	}
	
}

public class BankAccount implements Serializable {
	//enum operations and enum interest type
	//input exception (?)
	
	private Owner mOwner;
	private double mBalance;
	private double interest;
	private Queue <Double> history;
	private int mID;
	
	public BankAccount (String firstNameOwner, String lastNameOwner, String age, String balance, String id) {
		UserInputChecker check = new UserInputChecker();
		
		UserInputChecker.PersonNameValidator validateName = check.new PersonNameValidator();
		validateName.validate(firstNameOwner);
		validateName.validate(lastNameOwner);
		
		
		
		UserInputChecker.PersonAgeValidator validateAge = check.new PersonAgeValidator();
		
		validateAge.validate(age);
		
		
		double dBalance = Double.parseDouble(balance);
		if(dBalance < 0) {
			throw new IllegalArgumentException("Invalid balance!");
		}
		
		history = new ArrayDeque<>();
		mOwner = new Owner(firstNameOwner, lastNameOwner, Integer.parseInt(age));
		mBalance = dBalance;
		interest = 0.5;
		mID = Integer.parseInt(id);
	}
	
	
	public int getID() {
		return mID;
	}
	
	 public void add(String toAdd) {
		 // if toAdd < 0 exc
		 if(!toAdd.matches("[0-9]+")) {
			throw new IllegalArgumentException("Invalid number to add!");
		 }
		 double iToAdd = Double.parseDouble(toAdd);
		 mBalance += iToAdd;
		 initHistory(iToAdd);
	 } 
	 
	 public void withdraw(String toWithdraw) {
		 //toWithdraw < 0 => exc
		 if(interest > 1.0) {
			throw new InterestHigherThanPermittedException("Interest is " + interest);
		 }
		 
		 if(!toWithdraw.matches("[0-9]+")) {
				throw new IllegalArgumentException("Invalid number to withdraw!");
		 }
		 
		 double dToWithdraw = Double.parseDouble(toWithdraw);
		 if (mBalance - dToWithdraw < 0) {
			 throw new InsuffitientFundsException("Can not withdraw: " + dToWithdraw);
		 }
		 
		 mBalance -= dToWithdraw;
		 initHistory((-1) * dToWithdraw);
	 } 
	 
	 // transfer (ot, do, bankaccsum)
	 public void transferTo(BankAccount toTransfer, String sum) {
		 withdraw(sum);
		 toTransfer.add(sum);
	 } 
	 
	 public Queue <Double> history() {
		 
		 return history;
	 } 
	
	 private void initHistory(double toAdd) {
		 if(history.size() == 5) {
			 history.remove();
		 }
		 
		 history.add(toAdd);
	 }
	
	 
	 @Override
	public String toString() {
		String result = mOwner.toString() + " Balance: " + mBalance + ", ID: " + mID + ", history: " + history;
		return result;
		
	}
	 
}
