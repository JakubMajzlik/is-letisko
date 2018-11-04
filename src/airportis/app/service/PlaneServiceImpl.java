package airportis.app.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import airportis.app.dao.PlaneDAO;

@Service
public class PlaneServiceImpl implements PlaneService {

	@Autowired
	PlaneDAO planeDAO;
	
	@Override
	@Transactional
	public Map<String, String> getAllPlanes() {
		return planeDAO.getAllPlanes();
	}

	
	
}
