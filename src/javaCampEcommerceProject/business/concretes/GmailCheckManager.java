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
			System.out.println("�ifre en az 6 karakterli olmal�!!");
			return false;
		}else if (user.getPassword().isEmpty()) {
			System.out.println("Parola bo� ge�ilemez!!");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkFirstName(User user) {
		if(user.getFirstName().length()<2){
			System.out.println("�sim en az 2 karakterli olmal�d�r!!");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkLastName(User user) {
		if(user.getFirstName().length()<2){
			System.out.println("Soyisim en az 2 karakterli olmal�d�r!!");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkGmail(User user) {
		String regex="^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.com$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		if (pattern.matcher(user.getMail()).find() == false) {
			System.out.println("Girdi�iniz mail g-mail format�nda de�il.");
			return false;
		} else if (user.getMail().isEmpty()) {
			System.out.println("Mail alan� bo� b�rak�lamaz.");
			return false;
		}
		return true;
	}

	@Override
	public boolean mailIsValid(User user) {
		boolean result = true;
		if(mailList.contains(user.getMail())) {
			System.out.println("Bu mail ile daha �nce kay�t olunmu�. Ba�ka mail ile kaydolmay� deneyiniz.");
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
