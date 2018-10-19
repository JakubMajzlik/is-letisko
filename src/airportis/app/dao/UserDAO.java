package airportis.app.dao;

import airportis.app.entity.User;

public interface UserDAO {

	User findUserByEmail(String email);
	
}
