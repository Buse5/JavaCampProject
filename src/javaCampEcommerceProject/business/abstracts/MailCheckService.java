package javaCampEcommerceProject.business.abstracts;

public interface MailCheckService {
	void verificationMail(String mail);
	void verificationLink(String mail);
	boolean verifyAccount(String mail);
}
