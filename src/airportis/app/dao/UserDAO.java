package airportis.app.dao;

import java.util.List;

import airportis.app.entity.User;

public interface UserDAO {

	User findUserByEmail(String email);
	User findUserById(int id);
	List<User> getAllUsers();
	
	void save(User user);
	void remove(User user);
}
