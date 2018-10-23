package airportis.app.dao;

import airportis.app.entity.PassengerDetail;
import airportis.app.entity.User;

public interface UserDAO {

	User findUserByEmail(String email);
	
	void save(User user);
	
}
