package airportis.app.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import airportis.app.entity.User;
import airportis.app.model.UserEditModel;
import airportis.app.model.UserRegisterModel;

public interface UserService extends UserDetailsService {
	User findUserByEmail(String email);
	User findUserById(int id);
	List<User> getAllUsers();
	UserEditModel getUserModel(int id);
	
	void update(UserEditModel user);
	void save(UserRegisterModel user);
	void remove(User user);
}
