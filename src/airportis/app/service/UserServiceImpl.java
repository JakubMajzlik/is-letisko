package airportis.app.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import airportis.app.entity.User;
import airportis.app.model.UserModel;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(UserModel user) {
		// TODO Auto-generated method stub
		
	}

}
