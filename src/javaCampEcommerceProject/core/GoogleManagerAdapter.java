package javaCampEcommerceProject.core;

import javaCampEcommerceProject.entities.concretes.User;

public class GoogleManagerAdapter implements GoogleService{

	@Override
	public void signUpWithGoogle(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName() + " " + "kayýt oldu.");
		
	}

}
