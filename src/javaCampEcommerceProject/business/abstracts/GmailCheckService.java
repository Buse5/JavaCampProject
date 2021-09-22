package javaCampEcommerceProject.business.abstracts;

import javaCampEcommerceProject.entities.concretes.User;

public interface GmailCheckService {
	boolean checkPassword(User user);

	boolean checkFirstName(User user);

	boolean checkLastName(User user);

	boolean checkGmail(User user);

	boolean mailIsValid(User user);

	boolean confirmation(User user);
}
