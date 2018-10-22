import java.util.ArrayList;
import java.util.Date;

public class Mufasa {
	
	private Bank bank;
	private CaptchaServer captchaServer; 

	ArrayList<Account> accounts = new ArrayList<Account>(); 
	
	public Account createAccount(String firstName, String lastName, String userName, String password, 
			Date birthdate, String phoneNumber, String email) {
		
		if(!captchaServer.checkRealPerson(firstName, lastName, birthdate))
			return null; 
		
		Account newAccount = new Account();
		newAccount.setFirstAndLastName(firstName, lastName);
		newAccount.setUserName(userName);
		newAccount.setPassword(password);
		newAccount.setBirthdate(birthdate);
		newAccount.setPhoneNumber(phoneNumber);
		newAccount.setEmail(email);

		this.addAccount(newAccount);
		
		return newAccount;
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	public Account getAccount(int index) {
		return accounts.get(index);
	}
	
	public boolean checkBankAccountAttachment(int accountIndex, int cvcCode) {
		
		Account account = this.getAccount(accountIndex);
		
		if(!this.getBank().checkCode(account.getCardHolder(), account.getCardType(), 
				account.getCardNumber(), account.getExpireDate(), cvcCode))
			return false; 
		
		double previousBalance = account.getBalance();
		accounts.get(accountIndex).setBalance(previousBalance - 0.01);
		
		return true;
	}
	
	public boolean refundMoney(int accountIndex) {
		
		Account account = this.getAccount(accountIndex);
		
		if(!this.getBank().refundDeductedMoney(account.getCardHolder(), account.getCardType(), 
				account.getCardNumber(), account.getExpireDate()))
			return false; 
		
		double previousBalance = account.getBalance(); 
		accounts.get(accountIndex).setBalance(previousBalance + 0.01);
				
		return true;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public CaptchaServer getCaptchaServer() {
		return captchaServer;
	}

	public void setCaptchaServer(CaptchaServer captchaServer) {
		this.captchaServer = captchaServer;
	}
}
