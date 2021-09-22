package javaCampEcommerceProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import javaCampEcommerceProject.business.abstracts.MailCheckService;

public class MailCheckManager implements MailCheckService {

	List<String> verificatedMails = new ArrayList<String>();
	
	@Override
	public void verificationMail(String mail) {
		verificatedMails.add(mail);
		
	}

	@Override
	public void verificationLink(String mail) {
		System.out.println(mail + " mailine doðrulama gönderildi.");
		
	}

	@Override
	public boolean verifyAccount(String mail) {
		if(verificatedMails.contains(mail)) {
			return true;
		}
		return false;
	}

}
