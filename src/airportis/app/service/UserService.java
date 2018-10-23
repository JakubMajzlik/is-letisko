package airportis.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import airportis.app.entity.User;
import airportis.app.model.UserRegisterModel;

public interface UserService extends UserDetailsService {
	User findUserByEmail(String email);
	void save(UserRegisterModel user);
}
