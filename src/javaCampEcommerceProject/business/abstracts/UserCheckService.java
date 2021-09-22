package javaCampEcommerceProject.business.abstracts;

import javaCampEcommerceProject.entities.concretes.User;

public interface UserCheckService {
	boolean checkPassword(User user);
	boolean checkFirstName(User user);
	boolean checkLastName(User user);
	boolean checkMail(User user);
	boolean mailIsValid(User user);
	boolean confirmation(User user);
}
