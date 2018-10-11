package airportis.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import airportis.app.entity.User;
import airportis.app.model.UserModel;

public interface UserService extends UserDetailsService {
	User findUserByEmail(String email);
	void save(UserModel user);
}
