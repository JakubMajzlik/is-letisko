package airportis.app.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import airportis.app.dao.RoleDAO;
import airportis.app.dao.UserDAO;
import airportis.app.entity.PassengerDetail;
import airportis.app.entity.Role;
import airportis.app.entity.User;
import airportis.app.model.UserRegisterModel;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	RoleDAO roleDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDAO.findUserByEmail(username);
		System.out.println(user);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public User findUserByEmail(String email) {
		return userDAO.findUserByEmail(email);
	}

	@Override
	@Transactional
	public void save(UserRegisterModel userRegisterModel) {
		PassengerDetail details = new PassengerDetail(
				userRegisterModel.getIdentificationNumber(),
				userRegisterModel.getEmail(),
				userRegisterModel.getCity(),
				userRegisterModel.getFirstName(),
				userRegisterModel.getLastName(),
				userRegisterModel.getCity(),
				userRegisterModel.getStreet(),
				userRegisterModel.getHouseNumber(),
				userRegisterModel.getZip(),
				userRegisterModel.getCity());
		
		User user = new User(userRegisterModel.getEmail(),
							passwordEncoder.encode(userRegisterModel.getPassword1()));
		
		user.setDetails(details);
		user.setRoles(Arrays.asList(roleDAO.getRoleByName("ROLE_USER")));
		
		userDAO.save(user);
	}

}
