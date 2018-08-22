//This class extends the BankAccount .
//it has specific instances related to CurrentAccount and their setters and getters.

package in.co.cg.spring.boot.mmbank.pojo;

import in.co.cg.spring.boot.mmbank.exception.InsufficientBalanceException;

/**
 * @author rohit Naik
 *
 */
public  class CurrentAccount extends BankAccount {
	private double odLimit;
	private String salary="NA"; 

	
	
	/**
	 * @param accountHolder
	 * @param accountBalance
	 * @param accountType
	 * @param odLimit
	 */
	public CurrentAccount(Customer accountHolder, double accountBalance, String accountType, double odLimit) {
		super(accountHolder, accountBalance, accountType);
			this.odLimit=odLimit;
	}


	
	/*
	 * (non-Javadoc) Withdraw for Current Account
	 * 
	 * @returns yes on success withdraw
	 * 
	 * @see in.co.cg.mmbank.pojo.BankAccount#withdraw(double)
	 */
	@Override
	public void withdraw(double amountToBeWithDrawn) throws InsufficientBalanceException {
		if(odLimit+getAccountBalance()>=amountToBeWithDrawn)
		{
			setAccountBalance(((getAccountBalance()-amountToBeWithDrawn)));
		}
		else {
			throw new InsufficientBalanceException("Insufficient Balance");
		}

	}

	@Override
	public String toString() {
		return "CurrentAccount [odLimit=" + odLimit + ", toString()=" + super.toString() + "]";
	}
	//getters and setters
	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}	
	public double getOdLimit() {
		return odLimit;
	}
	public void setOdLimit(double odLimit) {
		this.odLimit = odLimit;
	}
}
