
public class Account {
	
	private String firstName; 
	
	private String lastName;
	
	private String userName; 
	
	private String password; 
	
	private String birthdate; 
	
	private String phoneNumber; 
	
	private String email; 
	
	public boolean setFirstAndLastName(String FirstName, String LastName){
		
		if(!FirstName.matches("[a-zA-Z]+"))
			return false; 
		
		if(!LastName.matches("[a-zA-Z]+"))
			return false; 
		
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

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	

}
