import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/
	
	@Test 
	public void testSetFirstAndLastName_Valid() {
		//Arrange 
		String firstname = "Peter"; 
		String lastname = "Pan";
		boolean result; 
		Account account = new Account(); 
		//Act
		result = account.setFirstAndLastName(firstname, lastname); 
		//Assert 
		assertTrue(result); 
	}
	
	@Test 
	public void testSetFirstAndLastName_Invalid() {
		//Arrange 
		String firstname = "Peter"; 
		String lastname = "P@n";
		boolean result; 
		Account account = new Account(); 
		//Act
		result = account.setFirstAndLastName(firstname, lastname); 
		//Assert 
		assertFalse(result); 
	}
	
	@Test 
	public void testSetUserName_Valid() {
		//Arrange 
		String userName = "User_1234"; 
		boolean result; 
		Account account = new Account(); 
		//Act
		result = account.setUserName(userName);
		//Assert 
		assertTrue(result); 
	}
	
	@Test 
	public void testSetUserName_Invalid_Double_Underscore() {
		//Arrange 
		String userName = "User_1234_"; 
		boolean result; 
		Account account = new Account(); 
		//Act
		result = account.setUserName(userName);
		//Assert 
		assertFalse(result); 
	}
	
	@Test 
	public void testSetUserName_Invalid_Too_Long() {
		//Arrange 
		String userName = "UserName_0123456789"; 
		boolean result; 
		Account account = new Account(); 
		//Act
		result = account.setUserName(userName);
		//Assert 
		assertFalse(result); 
	}
	
	@Test 
	public void testSetUserName_Invalid_Special_Character() {
		//Arrange 
		String userName = "User_123@"; 
		boolean result; 
		Account account = new Account(); 
		//Act
		result = account.setUserName(userName);
		//Assert 
		assertFalse(result); 
	}
	
	@Test 
	public void testPassword_Valid() {
		//Arrange 
		String password = "password123"; 
		boolean result; 
		Account account = new Account(); 
		//Act
		result = account.setPassword(password);
		//Assert 
		assertTrue(result); 
	}
	
	@Test 
	public void testPassword_Invalid_Too_Short() {
		//Arrange 
		String password = "passwrd"; 
		boolean result; 
		Account account = new Account(); 
		//Act
		result = account.setPassword(password);
		//Assert 
		assertFalse(result); 
	}
	
	@Test 
	public void testPhoneNumber_Valid() {
		//Arrange 
		String phoneNumber = "0043885534223"; 
		boolean result; 
		Account account = new Account(); 
		//Act
		result = account.setPhoneNumber(phoneNumber);
		//Assert 
		assertTrue(result); 
	}
	
	@Test 
	public void testPhoneNumber_Invalid_Not_Only_Numbers() {
		//Arrange 
		String phoneNumber = "00A3885534223"; 
		boolean result; 
		Account account = new Account(); 
		//Act
		result = account.setPhoneNumber(phoneNumber);
		//Assert 
		assertFalse(result); 
	}
}
