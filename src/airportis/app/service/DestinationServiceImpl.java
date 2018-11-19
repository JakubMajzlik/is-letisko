package airportis.app.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import airportis.app.dao.DestinationDAO;

@Service
public class DestinationServiceImpl implements DestinationService{

	@Autowired
	DestinationDAO destinationDAO;
	
	@Override
	@Transactional
	public Map<Integer, String> getAllDestinations() {
		return destinationDAO.getAllDestinations();
	}

	@Override
	@Transactional
	public String getDestinationName(int id) {
		String name = destinationDAO.getDestination(id).getCity() 
				+ ", "
				+ destinationDAO.getDestination(id).getCountry();
		return name;
	}

	@Override
	@Transactional
	public int getDestinationDistance(int id) {
		return destinationDAO.getDestination(id).getDistance();
	}

}
