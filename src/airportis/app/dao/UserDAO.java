package airportis.app.dao;

import java.util.List;

import airportis.app.entity.User;

public interface UserDAO {

	User findUserByEmail(String email);
	User findUserById(int id);
	List<User> getAllUsers();
	String getUserName(String email);
	String getUserSurname(String email);
	void save(User user);
	void remove(User user);
}
