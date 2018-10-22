import java.util.Date;

//external dependency

public interface Bank {
	public boolean checkCode(String cardHolder, String cardType, String cardNumber, Date expireDate, int cvcCode);

	public boolean refundDeductedMoney(String cardHolder, String cardType, String cardNumber, Date expireDate);
}
