package javaCampEcommerceProject.dataAccess.abstracts;

import javaCampEcommerceProject.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(User user);
	boolean getMail(String mail);
	boolean getPassword(String password);
}
