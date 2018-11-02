package airportis.app.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import airportis.app.dao.GateDAO;

@Service
public class GateServiceImpl implements GateService {

	@Autowired
	GateDAO gateDAO;
	
	@Override
	@Transactional
	public Map<Integer, String> getAllGates() {
		return gateDAO.getAllGates();
	}

	
	
}
