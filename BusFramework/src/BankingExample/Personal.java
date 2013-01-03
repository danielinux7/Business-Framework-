package BankingExample;

import BusinessFramework.Customer;

public class Personal extends Customer {
	private String DOB;

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
}
