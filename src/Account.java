import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Account {
	
	private String firstName; 
	
	private String lastName;
	
	private String userName; 
	
	private String password; 
	
	private Date birthdate; 
	
	private String phoneNumber; 
	
	private String email; 
	
	private String streetAddress; 
	
	private String cardHolder;
	
	private String cardType;
	
	private String cardNumber;
	
	private Date expireDate; 
	
	private double balance; 
	
	public Account() {}
	
	public Account(String firstName, String lastName, String userName, String password, 
			Date birthdate, String phoneNumber, String email) {
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.userName = userName;
		this.password = password; 
		this.birthdate = birthdate; 
		this.phoneNumber = phoneNumber; 
		this.email = email;
	}
	
	public Account(String firstName, String lastName) {
		this.firstName = firstName; 
		this.lastName = lastName; 
	}
	
	public Account(String firstName, String lastName, String cardHolder, 
			String cardType, String cardNumber, Date expireDate, double balance) {
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.cardHolder = cardHolder; 
		this.cardType = cardType; 
		this.cardNumber = cardNumber; 
		this.expireDate = expireDate;
		this.balance = balance; 
	}
	
	public boolean setFirstAndLastName(String FirstName, String LastName){
		
		if(!FirstName.matches("[a-zA-Z]+"))
			return false; 
		
		if(!LastName.matches("[a-zA-Z]+"))
			return false; 
		
		this.setFirstName(FirstName);
		this.setLastName(LastName);
		
		return true; 
	}
	
	public boolean setUserName(String userName) {
		
		if(userName.length() > 15)
			return false;
		
		if(!userName.matches("[a-zA-Z0-9_]+"))
			return false;
		
		int underscoreCount = 0;
		
		for(int i = 0; i < userName.length(); i++) {
			if(userName.charAt(i) == '_') {
				underscoreCount++; 
				if(underscoreCount > 1)
					return false;
			}
		}
		
		this.userName = userName; 
		
		return true;
	}
	
	public boolean setPassword(String password) {
		if(password.length() < 8)
			return false; 
		this.password = password; 
		
		return true; 
	}
	
	public boolean setPhoneNumber(String phoneNumber) {
		if(!phoneNumber.matches("[0-9]+"))
			return false; 
		
		this.phoneNumber = phoneNumber; 
		
		return true; 
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Override
	public boolean equals(Object obj) {
		if(this.firstName != ((Account) obj).firstName)
			return false;
		if(this.lastName != ((Account) obj).lastName)
			return false;
		if(this.userName != ((Account) obj).userName)
			return false;
		if(this.password != ((Account) obj).password)
			return false;
		if(this.birthdate.compareTo((((Account) obj).birthdate)) != 0) 
			return false;
		if(this.phoneNumber != ((Account) obj).phoneNumber)
			return false;
		if(this.email != ((Account) obj).email)
			return false;
		
		return true; 
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

}
