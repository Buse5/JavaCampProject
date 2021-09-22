package javaCampEcommerceProject.business.concretes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javaCampEcommerceProject.business.abstracts.UserCheckService;
import javaCampEcommerceProject.entities.concretes.User;

public class UserCheckManager implements UserCheckService{

	List<String> mailList = new ArrayList<String>();

	@Override
	public boolean checkPassword(User user) {
		if (user.getPassword().length() < 6) {
			System.out.println("Parola 6 karakterden az olamaz.");
			return false;
		} else if (user.getPassword().isEmpty()) {
			System.out.println("Parola boþ býrakýlamaz.");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkFirstName(User user) {
		if(user.getFirstName().length()<2) {
			System.out.println("Adýnýz 2 karakterden az olamaz.");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkLastName(User user) {
		if(user.getLastName().length()<2) {
			System.out.println("Soyadýnýz 2 karakterden az olamaz.");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkMail(User user) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		if(pattern.matcher(user.getMail()).find()==false) {
			System.out.println("Girdiðiniz mail e-posta formatýnda deðil.");
			return false;
		}else if(user.getMail().isEmpty()) {
			System.out.println("Mail alaný boþ býrakýlamaz.");
			return false;
		}
		return true;
	}

	@Override
	public boolean mailIsValid(User user) {
		boolean result = true;
		if(mailList.contains(user.getMail())) {
			System.out.println("Bu mail ile daha önce kayýt olunmuþ. Lütfen baþka bir mail adresi giriniz.");
			result = false;
		}else {
			mailList.add(user.getMail());
			result = true;
		}	
		return result;
	}

	@Override
	public boolean confirmation(User user) {
		if(checkFirstName(user)&&checkLastName(user)&&checkMail(user)&&checkPassword(user)&&mailIsValid(user)==true) {
			return true;
		}
		return false;
	}

}
