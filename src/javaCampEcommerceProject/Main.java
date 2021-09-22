package javaCampEcommerceProject;

import javaCampEcommerceProject.business.concretes.GmailCheckManager;
import javaCampEcommerceProject.business.concretes.MailCheckManager;
import javaCampEcommerceProject.business.concretes.UserCheckManager;
import javaCampEcommerceProject.business.concretes.UserManager;
import javaCampEcommerceProject.core.GoogleManagerAdapter;
import javaCampEcommerceProject.dataAccess.concretes.HibernateUserDao;
import javaCampEcommerceProject.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1 = new User(1,"Çağrı","AKINCI","cagri.akinci@outlook.com","123456");
		User user2 = new User(2,"Çağrı","AKINCI","abc.com","123456"); // E-posta hatası verir.
		User user3 = new User(3,"Ç","AKINCI","cagri.akinci@outlook.com","123456"); // isim hatası verir.
		User user4 = new User(4,"Çağrı","A","cagri.akinci@outlook.com","123456"); // soyisim hatası verir.
		User user5 = new User(5,"Çağrı","AKINCI","cagri.akinci@outlook.com","123"); // þifre hatası verir.
		User user6 = new User(6,"Çağrı","AKINCI","abcfsdas@asdgmail.com","123456"); // gmail hatası verir.
		
		UserManager userManager = new UserManager(new HibernateUserDao(),new MailCheckManager(),new UserCheckManager(), new GoogleManagerAdapter(), new GmailCheckManager());
		userManager.signUp(user1);
		userManager.signUp(user2); 
		userManager.signUp(user3);
		userManager.signUp(user4);
		userManager.signUp(user5);
		userManager.logIn(user1);
		userManager.signUpWithGoogle(user6);

	}

}
