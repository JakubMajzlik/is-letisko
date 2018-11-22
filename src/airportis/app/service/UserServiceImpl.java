package airportis.app.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import airportis.app.dao.RoleDAO;
import airportis.app.dao.UserDAO;
import airportis.app.entity.PassengerDetail;
import airportis.app.entity.Role;
import airportis.app.entity.User;
import airportis.app.model.UserEditModel;
import airportis.app.model.UserRegisterModel;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	DestinationService destinationService;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	RoleDAO roleDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(destinationService== null) System.out.println("destSer je NULA");
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
				userRegisterModel.getPhoneNumber(),
				userRegisterModel.getFirstName(),
				userRegisterModel.getLastName(),
				userRegisterModel.getCity(),
				userRegisterModel.getStreet(),
				userRegisterModel.getHouseNumber(),
				userRegisterModel.getZip(),
				userRegisterModel.getCountry());
		
		User user = new User(userRegisterModel.getEmail(),
							passwordEncoder.encode(userRegisterModel.getPassword1()));
		
		user.setDetails(details);
		user.setRoles(Arrays.asList(roleDAO.getRoleByName("ROLE_USER")));
		
		userDAO.save(user);
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	@Transactional
	public User findUserById(int id) {
		return userDAO.findUserById(id);
	}

	@Override
	@Transactional
	public UserEditModel getUserModel(int id) {
		User user = userDAO.findUserById(id);
		if(user == null) {
			return null;
		}
		PassengerDetail details = user.getDetails();
		System.out.println(details);
		UserEditModel userModel = new UserEditModel(
				user.getId(),
				details.getFirstName(),
				details.getLastName(),
				details.getEmail(),
				user.getPassword(),
				user.getPassword(),
				details.getCity(),
				details.getStreet(),
				details.getHouseNumber(),
				details.getZip(),
				details.getCountry(),
				details.getIdentificationNumber(),
				details.getPhoneNumber());			
		
		return userModel;
	}

	@Override
	@Transactional
	public void update(UserEditModel userEditModel) {
		User user = userDAO.findUserByEmail(userEditModel.getEmail());
		user.setPassword(userEditModel.getPassword1());
		
		PassengerDetail details = user.getDetails();
				
		details.setIdentificationNumber(userEditModel.getIdentificationNumber());
		details.setEmail(userEditModel.getEmail());
		details.setPhoneNumber(userEditModel.getPhoneNumber());
		details.setFirstName(userEditModel.getFirstName());
		details.setLastName(userEditModel.getLastName());
		details.setCity(userEditModel.getCity());
		details.setStreet(userEditModel.getStreet());
		details.setHouseNumber(userEditModel.getHouseNumber());
		details.setZip(userEditModel.getZip());
		details.setCountry(userEditModel.getCountry());
		
		user.setDetails(details);		
		userDAO.save(user);
		
	}

	@Override
	@Transactional
	public void remove(User user) {
		userDAO.remove(user);	
	}

}
