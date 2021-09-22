package javaCampEcommerceProject.business.concretes;

import javaCampEcommerceProject.business.abstracts.GmailCheckService;
import javaCampEcommerceProject.business.abstracts.MailCheckService;
import javaCampEcommerceProject.business.abstracts.UserCheckService;
import javaCampEcommerceProject.business.abstracts.UserService;
import javaCampEcommerceProject.core.GoogleService;
import javaCampEcommerceProject.dataAccess.abstracts.UserDao;
import javaCampEcommerceProject.entities.concretes.User;

public class UserManager implements UserService {


	UserDao userDao;
	MailCheckService mailCheckService;
	UserCheckService userCheckService;
	GoogleService googleService;
	GmailCheckService gmailCheckService;

	public UserManager(UserDao userDao, MailCheckService mailCheckService, UserCheckService userCheckService,
			GoogleService googleService, GmailCheckService gmailCheckService) {
		super();
		this.userDao = userDao;
		this.mailCheckService = mailCheckService;
		this.userCheckService = userCheckService;
		this.googleService = googleService;
		this.gmailCheckService = gmailCheckService;

	}

	@Override
	public void signUp(User user) {
		if (userCheckService.confirmation(user) == true) {
			System.out.println(user.getFirstName() + " " + user.getLastName() + " " + "sisteme eklendi.");
			mailCheckService.verificationMail(user.getMail());
			userDao.add(user);
		}

	}

	@Override
	public void logIn(User user) {
		mailCheckService.verificationLink(user.getMail());
		if (userDao.getMail(user.getMail()) && userDao.getMail(user.getMail()) == true) {
			System.out.println("Giriþ baþarýlý.");
		} else {
			System.out.println("Giriþ baþarýsýz.");
		}

	}

	@Override
	public void signUpWithGoogle(User user) {
		if (gmailCheckService.confirmation(user) == true) {
			System.out.println(user.getFirstName() + " " + user.getLastName() + " " + "sisteme eklendi.");
			mailCheckService.verificationMail(user.getMail());
			userDao.add(user);
		}

	}

}
