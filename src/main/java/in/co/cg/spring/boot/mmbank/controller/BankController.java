package in.co.cg.spring.boot.mmbank.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.co.cg.spring.boot.mmbank.pojo.BankAccount;
import in.co.cg.spring.boot.mmbank.service.BankAccountServiceI;

@RestController
public class BankController {
		
	
	
	@Autowired
	BankAccountServiceI accountService;
/*
	@RequestMapping(value="/addNew")
	public String addAcount(
		
			@PathVariable("c_Name") String c_Name ,
			@PathVariable("c_Email") String c_Email,
			@PathVariable("c_contact") long c_contact,
			@PathVariable("c_dob") String c_dob,
			@PathVariable("gender") String gender,
			@PathVariable("c_Address") String c_Address,
				@PathVariable("c_AccType") String c_AccType,
				@PathVariable("c_amount") String c_amount,
			@PathVariable("c_salary") String c_salary,
			@PathVariable("c_ODLimit") String c_ODLimit,
			Model model	)
	 {
			DateTimeFormatter JAVAFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Date format pattern for date of birth i.e. yyyy/MM/dd
		LocalDate dateOfBirth = LocalDate.parse(c_dob, JAVAFormat); // initializing customer date of birth to dateOfBirth
		Customer customer = new Customer(c_Name, c_Email,c_contact ,dateOfBirth ,c_Address ,gender );// invoking constructor of Customer  Class
	System.out.println("HELLOW");
																														
		if(c_AccType.equals("sav")) { // checks if account is Saving Account

			if ("c_salary".equals("salary")) { // checks if Saving Account is salaried

				SavingsAccount savingsAccount = new SavingsAccount(customer, true, "Savings"); // invoking constructor  of SavingsAccount Class

				accountService.AddNewAccount(savingsAccount); // Invoking AddNewAccount

				model.addAttribute("accNO", accountService.getAccountNo() - 1); // Invoking getAccountNo
				return "createSuccess";
			}

			else {// checks if Saving Account is Not salaried

				SavingsAccount savingsAccount = new SavingsAccount(customer,Double.parseDouble(c_amount), "Savings", false);// invoking constructor of SavingsAccount Class

				accountService.AddNewAccount(savingsAccount); // Invoking AddNewAccount

				model.addAttribute("accNO", accountService.getAccountNo() - 1); // Invoking getAccountNo
				return "createSuccess";
			}
		}

		else {

			CurrentAccount currentAccount = new CurrentAccount(customer,Double.parseDouble(c_amount) , "Current", Double.parseDouble(c_ODLimit)); // invoking constructor of CurrentAccount Class

			accountService.AddNewAccount(currentAccount); // Invoking AddNewAccount

			model.addAttribute("accNO", accountService.getAccountNo() - 1);
			return "createSuccess";
		}
		
	
	}

*/
	@RequestMapping(value="/viewaccount", method=RequestMethod.GET)
	public Collection<BankAccount> viewAllAccount(Model model) {
		return accountService.viewAccount();
	}
	
	@RequestMapping(value="/deposit/{acNO}/{amt}",method=RequestMethod.POST)
	public Resource<BankAccount> depositAmount(@PathVariable("acNO")int acNO, @PathVariable("amt") double c_amount) {

	    Resource<BankAccount> resource = new Resource<BankAccount>(accountService.deposit(c_amount, acNO));

		return resource;
	}
	
	@RequestMapping(value="/withdraw/{acNo}/{amount}",method=RequestMethod.POST)
	public Resource<BankAccount> withdrawAmount(@PathVariable("acNo")int acNo, @PathVariable("amount")double amount ) {
		/*double amountT=amount;
		TreeMap<Integer, Integer> deno= new TreeMap<Integer, Integer>(); //map to store notecount and value
		int notes[]= {2000,500,200,100,50,20,10,5,2,1};//all available notes
		int totalNotes=0,eachNoteCount=0;
		
		for(int i=0;i<10;i++) {
			eachNoteCount=(int) (amount/notes[i]);  //count no. of notes
			if(eachNoteCount!=0) {
				deno.put(notes[i], eachNoteCount); //put note value and count in map
			}
			totalNotes+=eachNoteCount; //total note count
			amount%=notes[i]; //remaining amount
			
		}
		model.addAttribute("toatlNotes",totalNotes); //Setting total number of notes withdrawSuccess.jsp
		model.addAttribute("deno",deno); //Setting deno attribute for denomination map to withdrawSuccess.jsp
		model.addAttribute("amount",amountT); //Setting deno attribute for denomination map to withdrawSuccess.jsp
		*/ 
		
		Resource<BankAccount> resource = new Resource<BankAccount>(accountService.withdrawl(amount, acNo));		//Invoking Withdrawl
		return resource;

	}
	
	@RequestMapping(value="/viewcustomers",method=RequestMethod.GET)
	public Collection<BankAccount> viewAllCustomer(Model model) {
		return accountService.viewCustomer();
	}

	@RequestMapping(value="/fundtransfer/{sender}/{reciever}/{amount}",method=RequestMethod.POST)
	public Resource<BankAccount> fundT(@PathVariable("sender")int sender,@PathVariable("reciever")int reciever,@PathVariable("amount")double amount) {
		Resource<BankAccount> resource = new Resource<BankAccount>(accountService.Fundtransfer(sender, reciever, amount));		//Invoking fundTransfer
		return resource;
	}
	
	@RequestMapping(value="/searchCustomer/{accno}",method=RequestMethod.POST)
	public  Resource<BankAccount>  searchCust(@PathVariable("accno") int accno) {
		Resource<BankAccount> resource = new Resource<BankAccount>(accountService.searchAccount(accno));		//Invoking deposit
		return resource;
	}
	
	/*
	@RequestMapping(value="/updateInfo/{}")
	public String updateInfo(@PathVariable("accId") int accno) {
		model.addAttribute("updateCust", accountService.searchAccount(accno)); //Invoking searchAccount
		return "UpdateCustomerForm";
	}
	
	@RequestMapping(value="/updateSuccess")
	public String updateSuccess(@PathVariable("accId") int accno,@PathVariable("c_contact") long contactNumber,@PathVariable("c_dob") String c_dob,@PathVariable("c_Name") String customerName,@PathVariable("c_Email") String emailId) {
		DateTimeFormatter	JAVAFormat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateOfBirth = LocalDate.parse(c_dob, JAVAFormat1);
		accountService.updateInfo(accno, contactNumber, dateOfBirth, customerName, emailId); //Invoking updateInfo
		model.addAttribute("updatesuccess", accountService.searchAccount(accno));//Invoking searchAccount
		return "UpdateSucess";
	}*/
}
