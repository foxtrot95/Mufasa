import static org.junit.Assert.*;

import java.util.Date;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class MufasaTest {

	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/
	Mufasa mufasa;
	Bank bank;
	CaptchaServer captchaServer;
	
	@Before
	public void setup(){
		mufasa = new Mufasa();
		
		//Mock create
		bank = EasyMock.createMock(Bank.class);
		captchaServer = EasyMock.createMock(CaptchaServer.class); 
		mufasa.setBank(bank); 
		mufasa.setCaptchaServer(captchaServer);
	}
	
	@Test//verifying external dependency
	public void testCeckBankAccountAttachment_Valid_Deduct_Certain_Amount() {
		//Arrange
		Date expireDate = new Date(2019, 10, 22);
		EasyMock.expect(bank.checkCode("Peter Pan", "Mastercard", "553645671234", 
				expireDate, 123)).andReturn(true);
		int accountIndex = 0; 
		//Mock ready
		EasyMock.replay(bank);
		Account account = new Account("Peter", "Pan", "Peter Pan", "Mastercard", "553645671234",
				expireDate, 10.0); 
		mufasa.addAccount(account);
		//Act
		mufasa.checkBankAccountAttachment(accountIndex, 123);
		//Assert
		assertEquals(9.99, mufasa.getAccount(accountIndex).getBalance(), 0.0);
	}

	@Test//verifying external dependency
	public void testCeckBankAccountAttachment_Invalid_No_Deduction() {
		//Arrange
		Date expireDate = new Date(2019, 10, 22);
		EasyMock.expect(bank.checkCode("Hans Pan", "Mastercard", "553645671234", 
				expireDate, 123)).andReturn(false);
		int accountIndex = 0;
		//Mock ready
		EasyMock.replay(bank);
		Account account = new Account("Hans", "Pan", "Hans Pan", "Mastercard", "553645671234",
				expireDate, 10.0); 
		mufasa.addAccount(account);
		//Act
		mufasa.checkBankAccountAttachment(accountIndex, 123);
		//Assert
		assertEquals(10.0, mufasa.getAccount(accountIndex).getBalance(), 0.0);
	}
	
	@Test//verifying external dependency
	public void testRefundMoney_Valid_Refund_Certain_Amount() {
		//Arrange
		Date expireDate = new Date(2019, 10, 22);
		EasyMock.expect(bank.refundDeductedMoney("Sepp Hold", "Visa", "553645671234", 
				expireDate)).andReturn(true);
		int accountIndex = 0;
		//Mock ready
		EasyMock.replay(bank);
		Account account = new Account("Sepp", "Hold", "Sepp Hold", "Visa", "553645671234",
				expireDate, 15.99); 
		mufasa.addAccount(account);
		//Act
		mufasa.refundMoney(accountIndex);
		//Assert
		assertEquals(16.0, mufasa.getAccount(accountIndex).getBalance(), 0.0);
	}
	
	@Test//verifying external dependency
	public void testRefundMoney_Invalid_No_Refund() {
		//Arrange
		Date expireDate = new Date(2019, 10, 22);
		EasyMock.expect(bank.refundDeductedMoney("Sepp Isi", "Visa", "553645671234", 
				expireDate)).andReturn(false);
		int accountIndex = 0;
		//Mock ready
		EasyMock.replay(bank);
		Account account = new Account("Sepp", "Isi", "Sepp Isi", "Visa", "553645671234",
				expireDate, 15.99); 
		mufasa.addAccount(account);
		//Act
		mufasa.refundMoney(accountIndex);
		//Assert
		assertEquals(15.99, mufasa.getAccount(accountIndex).getBalance(), 0.0);
	}
	
	@Test//verifying external dependency
	public void testCreateAccount_Valid_Add_Account_To_System() {
		//Arrange
		Date birthdate = new Date(1991, 9, 20);
		EasyMock.expect(captchaServer.checkRealPerson("Herbert", "Moor", birthdate)).andReturn(true);
		//Mock ready
		EasyMock.replay(captchaServer);
		Account expectedAccount = new Account("Herbert", "Moor", "herbie", "password123", 
				birthdate, "0043567834", "herbie@gmx.at"); 
		//Act
		Account createdAccount = mufasa.createAccount("Herbert", "Moor", "herbie", "password123", 
				birthdate, "0043567834", "herbie@gmx.at");
		//Assert
		//overwritten the equals method of class Account
		assertEquals(expectedAccount, createdAccount);
	}
	
	@Test//verifying external dependency
	public void testCreateAccount_Invalid_No_Account_Creation() {
		//Arrange
		Date birthdate = new Date(1991, 9, 20);
		EasyMock.expect(captchaServer.checkRealPerson("Simon", "Maier", birthdate)).andReturn(false);
		//Mock ready
		EasyMock.replay(captchaServer);
		Account expectedAccount = null;
		//Act
		Account createdAccount = mufasa.createAccount("Simon", "Maier", "simoi", "password123", 
				birthdate, "0043677887", "simoi@gmx.at");
		//Assert
		//overwritten the equals method of class Account
		assertEquals(expectedAccount, createdAccount);
	}
}
