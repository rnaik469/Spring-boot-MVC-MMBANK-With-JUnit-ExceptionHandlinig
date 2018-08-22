package in.co.cg.spring.boot.mmbank.dao;

import java.util.Map;

import in.co.cg.spring.boot.mmbank.pojo.BankAccount;

public interface BankAccountDAOI {

	/**
	 * Add new Account in Map
	 * @param account
	 */
	void AddNewAccount(BankAccount account);

	/**
	 * @return Account Map
	 */
	Map<Integer, BankAccount> searchAccount();

	/**
	 * @return Account Map
	 */
	Map<Integer, BankAccount> viewAccount();

	/**
	 * @return Account Map
	 */
	Map<Integer, BankAccount> viewCustomer();

}