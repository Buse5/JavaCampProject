package javaCampEcommerceProject.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javaCampEcommerceProject.business.abstracts.GmailCheckService;
import javaCampEcommerceProject.entities.concretes.User;

public class GmailCheckManager implements GmailCheckService {

	List<String> mailList=new ArrayList<String>();
	
	
	@Override
	public boolean checkPassword(User user) {
		if(user.getPassword().length()<6){
			System.out.println("Þifre en az 6 karakterli olmalý!!");
			return false;
		}else if (user.getPassword().isEmpty()) {
			System.out.println("Parola boþ geçilemez!!");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkFirstName(User user) {
		if(user.getFirstName().length()<2){
			System.out.println("Ýsim en az 2 karakterli olmalýdýr!!");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkLastName(User user) {
		if(user.getFirstName().length()<2){
			System.out.println("Soyisim en az 2 karakterli olmalýdýr!!");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkGmail(User user) {
		String regex="^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.com$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		if (pattern.matcher(user.getMail()).find() == false) {
			System.out.println("Girdiðiniz mail g-mail formatýnda deðil.");
			return false;
		} else if (user.getMail().isEmpty()) {
			System.out.println("Mail alaný boþ býrakýlamaz.");
			return false;
		}
		return true;
	}

	@Override
	public boolean mailIsValid(User user) {
		boolean result = true;
		if(mailList.contains(user.getMail())) {
			System.out.println("Bu mail ile daha önce kayýt olunmuþ. Baþka mail ile kaydolmayý deneyiniz.");
			return false;
		}else {
			mailList.add(user.getMail());
			result=true;
		}
		return result;
	}

	@Override
	public boolean confirmation(User user) {
		if (checkFirstName(user) && checkLastName(user) && checkGmail(user) && checkPassword(user)
				&& mailIsValid(user) == true) {
			return true;
		}
		return false;
	}

}
