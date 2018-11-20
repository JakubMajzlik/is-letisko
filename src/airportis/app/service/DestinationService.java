package airportis.app.service;

import java.util.Map;

import airportis.app.model.DestinationModel;

public interface DestinationService {
	
		Map<Integer,String> getAllDestinations();	
		String getDestinationName(int id);
		int getDestinationDistance(int id);
		void save(DestinationModel destinationModel);
}
