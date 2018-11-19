package airportis.app.service;

import java.util.Map;

public interface DestinationService {
	
		Map<Integer,String> getAllDestinations();	
		String getDestinationName(int id);
		int getDestinationDistance(int id);
}
