package in.co.cg.spring.boot.mmbank.service;

import java.time.LocalDate;
import java.util.Collection;

import in.co.cg.spring.boot.mmbank.exception.CustomerNotFoundException;
import in.co.cg.spring.boot.mmbank.exception.InsufficientBalanceException;
import in.co.cg.spring.boot.mmbank.pojo.BankAccount;

public interface BankAccountServiceI {

	void AddNewAccount(BankAccount account);

	BankAccount searchAccount(int accountNO) throws CustomerNotFoundException;

	int getAccountNo();

	Collection<BankAccount> viewAccount();

	Collection<BankAccount> viewCustomer();

	BankAccount deposit(double amount, int accNo) throws CustomerNotFoundException;

	BankAccount withdrawl(double amount, int accNo) throws InsufficientBalanceException, CustomerNotFoundException;

	void updateInfo(int accountNO, long contactNumber, LocalDate dateOfBirth, String customerName, String emailId) throws CustomerNotFoundException;

	BankAccount Fundtransfer(int sender, int reciever, double amount) throws InsufficientBalanceException, CustomerNotFoundException;

}