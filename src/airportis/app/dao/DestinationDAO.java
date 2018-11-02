package airportis.app.dao;

import java.util.Map;

import airportis.app.entity.Destination;

public interface DestinationDAO {
	
	void save(Destination destination);
	void remove(Destination destination);
	Destination getDestination(int id);
	Destination getDestination(String country, String city);
	Map<Integer,String> getAllDestinations();

	
}
