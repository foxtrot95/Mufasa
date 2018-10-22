import java.util.Date;

public interface CaptchaServer {
	public boolean checkRealPerson(String firstName, String lastName, Date birthdate); 
}
