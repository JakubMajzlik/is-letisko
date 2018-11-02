package airportis.app.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import airportis.app.dao.DestinationDAO;
import airportis.app.dao.FlightDAO;
import airportis.app.dao.GateDAO;
import airportis.app.dao.PlaneDAO;
import airportis.app.entity.Flight;
import airportis.app.model.FlightModel;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightDAO flightDAO;
	
	@Autowired
	private DestinationDAO destinationDAO;
	
	@Autowired
	private PlaneDAO planeDAO;
	
	@Autowired
	private GateDAO gateDAO;
	
	@Override
	@Transactional
	public void save(FlightModel flightModel) {
		if(gateDAO.getGate(flightModel.getGate())==null) System.out.println("GATE NULA");
		Flight flight= new Flight(flightModel.getTakeoffDate(), 
				flightModel.getDestination(),
				gateDAO.getGate(flightModel.getGate()).getGateNumber(),
				flightModel.getPlane());
		
		flightDAO.save(flight);
		
	}

	@Override
	@Transactional
	public void remove(int id) {
		
		Flight flight= flightDAO.getFlight(id);
		if(flight!= null) {
			flightDAO.remove(flight);	
		}
		
	}

	@Override
	@Transactional
	public FlightModel getFlight(int id) {

		Flight flight= flightDAO.getFlight(id);
		if(flight == null) {
			return null;
		}
		FlightModel flightModel= new FlightModel();
		flightModel.setDestination(flight.getDestination());
		flightModel.setGate(gateDAO.getGate(flight.getGate()).getGateNumber());
		flightModel.setId(flight.getId());
		flightModel.setPlane(planeDAO.getPlane(flight.getPlane()).getSerialNumber());
		//flightModel.setTakeoffDate(flight.getTakeoffDate());
		
		return flightModel;
	}

}
