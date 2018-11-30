package airportis.app.service;

import java.util.List;
import java.util.Map;

import airportis.app.entity.Destination;
import airportis.app.model.DestinationModel;

public interface DestinationService {
	
		Map<Integer,String> getAllDestinations();	
		String getDestinationName(int id);
		void save(DestinationModel destinationModel);
		DestinationModel getDestinationModel(int id);
		List<Destination> getListOfDestinations();
}
