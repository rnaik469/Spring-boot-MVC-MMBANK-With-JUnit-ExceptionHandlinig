package in.co.cg.spring.boot.mmbank.service;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.stereotype.Component;

import in.co.cg.spring.boot.mmbank.dao.BankAccountDAO;
import in.co.cg.spring.boot.mmbank.dao.BankAccountDAOI;
import in.co.cg.spring.boot.mmbank.exception.CustomerNotFoundException;
import in.co.cg.spring.boot.mmbank.exception.InsufficientBalanceException;
import in.co.cg.spring.boot.mmbank.pojo.BankAccount;
import in.co.cg.spring.boot.mmbank.pojo.SavingsAccount;

/**
 * @author Rohit Naik
 *
 */
@Component
public class BankAccountService implements BankAccountServiceI {

	private BankAccountDAOI accountDAO = new BankAccountDAO(); // Instantiating BankAccountDAO
	private BankAccount customer = null; // creating reference of BankAccount
	private BankAccount Bsender; // creating reference of BankAccount
	private BankAccount Breceiver; // creating reference of BankAccount

	/*
	 * (non-Javadoc) Add New account
	 * 
	 * @see
	 * in.co.cg.spring.boot.mmbank.service.BankAccountServiceI#AddNewAccount(in.co.cg.mmbank.
	 * pojo.BankAccount)
	 * 
	 */
	@Override
	public void AddNewAccount(BankAccount account) {
		accountDAO.AddNewAccount(account);
	}

	/*
	 * (non-Javadoc) Search account
	 * 
	 * @return object of BankAccount if found or null if not
	 * 
	 * @see in.co.cg.spring.boot.mmbank.service.BankAccountServiceI#searchAccount(int)
	 */
	@Override
	public BankAccount searchAccount(int accountNO) throws CustomerNotFoundException {
		for (BankAccount bankAccount : viewAccount()) {
			System.out.println(accountNO);
			if (bankAccount.getAccountNumber() == accountNO) {
				System.out.println();
				customer = bankAccount;
				break;
			}
		
		}
		System.out.println(customer);	
		if(customer!=null)
		return customer;
		else
			throw new CustomerNotFoundException("Customer Not Found");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @@return account number
	 * 
	 * @see in.co.cg.spring.boot.mmbank.service.BankAccountServiceI#getAccountNo()
	 */
	@Override
	public int getAccountNo() {
		System.out.println(BankAccount.getNextAccountNumber());
		return BankAccount.getNextAccountNumber();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @returns all accounts
	 * 
	 * @see in.co.cg.spring.boot.mmbank.service.BankAccountServiceI#viewAccount()
	 */
	@Override
	public Collection<BankAccount> viewAccount() {

		return accountDAO.viewAccount().values();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @returns all customers
	 * 
	 * @see in.co.cg.spring.boot.mmbank.service.BankAccountServiceI#viewCustomer()
	 */
	@Override
	public Collection<BankAccount> viewCustomer() {

		return accountDAO.viewCustomer().values();
	}

	/*
	 * (non-Javadoc) Deposit to account
	 * 
	 * @return account object
	 * 
	 * @see in.co.cg.spring.boot.mmbank.service.BankAccountServiceI#deposit(double, int)
	 */
	@Override
	public BankAccount deposit(double amount, int accNo) throws CustomerNotFoundException {
		customer = searchAccount(accNo);
			customer.deposit(amount);
			return customer;
	}

	/*
	 * (non-Javadoc) withdraw to account
	 * 
	 * @return account object
	 * 
	 * @see in.co.cg.spring.boot.mmbank.service.BankAccountServiceI#withdrawl(double, int)
	 */
	@Override
	public BankAccount withdrawl(double amount, int accNo) throws InsufficientBalanceException, CustomerNotFoundException {
		customer = searchAccount(accNo);
			customer.withdraw(amount);
			return customer;
	}

	/*
	 * (non-Javadoc) update customer info
	 * 
	 * @see in.co.cg.spring.boot.mmbank.service.BankAccountServiceI#updateInfo(int, long,
	 * java.time.LocalDate, java.lang.String, java.lang.String)
	 */
	@Override
	public void updateInfo(int accountNO, long contactNumber, LocalDate dateOfBirth, String customerName,
			String emailId) throws CustomerNotFoundException {
		customer.updateCustomerDetails(searchAccount(accountNO), contactNumber, dateOfBirth,customerName, emailId);

	}

	/*
	 * (non-Javadoc) transfer amount
	 * 
	 * @returns false if account not found or insufficient amount
	 * 
	 * @see in.co.cg.spring.boot.mmbank.service.BankAccountServiceI#Fundtransfer(int, int,
	 * double, java.lang.String)
	 */
	@Override
	public BankAccount Fundtransfer(int sender, int reciever, double amount) throws InsufficientBalanceException, CustomerNotFoundException {
		
		Bsender = searchAccount(sender);
		Breceiver = searchAccount(reciever);
		System.out.println(Bsender+" --------------  "+Breceiver);
			Bsender.withdraw(amount);
			Breceiver.deposit(amount);
			return Breceiver;

	}

}
