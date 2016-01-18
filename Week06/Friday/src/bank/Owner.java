package bank;

import java.io.Serializable;

public class Owner implements Serializable {
	private String mFirstName;
	private String mLastName;
	private int mAge;
	
	public Owner(String firstName, String lastName, int age) {
		mFirstName = firstName;
		mLastName = lastName;
		mAge = age;
	}
	
	public String getFirstName() {
		return mFirstName;
	}
	public void setFirstName(String firstName) {
		this.mFirstName = firstName;
	}
	public String getLastName() {
		return mLastName;
	}
	public void setLastName(String lastName) {
		this.mLastName = lastName;
	}
	public int getAge() {
		return mAge;
	}
	public void setAge(int age) {
		this.mAge = age;
	}
	
	@Override
	public String toString() {
		String result = "Name: " + mFirstName + " " + mLastName + ", age: " + mAge;
		return result;
	}
}
