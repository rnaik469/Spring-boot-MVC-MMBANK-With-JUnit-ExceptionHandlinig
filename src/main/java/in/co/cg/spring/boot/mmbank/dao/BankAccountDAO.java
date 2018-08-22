package in.co.cg.spring.boot.mmbank.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import in.co.cg.spring.boot.mmbank.pojo.BankAccount;
import in.co.cg.spring.boot.mmbank.pojo.CurrentAccount;
import in.co.cg.spring.boot.mmbank.pojo.Customer;
import in.co.cg.spring.boot.mmbank.pojo.SavingsAccount;

/**
 * @author Rohit Naik
 *
 */
public class BankAccountDAO implements BankAccountDAOI  {
	static	Map<Integer, BankAccount> bankAcc = new HashMap<Integer, BankAccount>();
static	{
		DateTimeFormatter JAVAFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Date format pattern for date of birth i.e. yyyy/MM/dd
		LocalDate dateOfBirth = LocalDate.parse("1996-12-31", JAVAFormat); // initializing customer date of birth to dateOfBirth
		
		bankAcc.put(101, new SavingsAccount(new Customer("Rohit", "Rn", 123, dateOfBirth, "abc", "M"), true, "Sav"));
		bankAcc.put(102, new SavingsAccount(new Customer("Naik", "Rn", 123, dateOfBirth ,"xyz", "F"), 1000, "Sav", false));
		bankAcc.put(103, new CurrentAccount(new Customer("Emmi", "Rn", 123,dateOfBirth , "ijk", "F"), 15000, "Cur", 10000));
		
	}

	/* (non-Javadoc)
	 * @see in.co.cg.spring.boot.mmbank.dao.BankAccountDAOI#AddNewAccount(in.co.cg.spring.boot.mmbank.pojo.BankAccount)
	 */
	@Override
	public void AddNewAccount(BankAccount account) {
		bankAcc.put(account.getAccountNumber(), account);
	}
	
	/* (non-Javadoc)
	 * @see in.co.cg.spring.boot.mmbank.dao.BankAccountDAOI#searchAccount()
	 */
	@Override
	public  Map<Integer, BankAccount> searchAccount() {
		return bankAcc;
	}

	/* (non-Javadoc)
	 * @see in.co.cg.spring.boot.mmbank.dao.BankAccountDAOI#viewAccount()
	 */
	@Override
	public  Map<Integer, BankAccount> viewAccount() {
		return bankAcc;
	}

	/* (non-Javadoc)
	 * @see in.co.cg.spring.boot.mmbank.dao.BankAccountDAOI#viewCustomer()
	 */
	@Override
	public Map<Integer, BankAccount> viewCustomer() {
		return bankAcc;
	}
}
