package airportis.app.service;



import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	private PlaneDAO planeDAO;
	
	@Autowired
	private GateDAO gateDAO;
	
	@Override
	@Transactional
	public void save(FlightModel flightModel) {
		Flight flight= new Flight(
				flightModel.getTakeoffDate(), 
				flightModel.getDestination(),
				gateDAO.getGate(flightModel.getGate()).getGateNumber(),
				flightModel.getPlane(),
				flightModel.getPrice());
		flight.setId(flightModel.getId());
		
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
	public FlightModel getFlightModel(int id) {

		Flight flight= flightDAO.getFlight(id);
		if(flight == null) {
			return null;
		}
		FlightModel flightModel= new FlightModel();
		flightModel.setDestination(flight.getDestination());
		flightModel.setGate(gateDAO.getGate(flight.getGate()).getGateNumber());
		flightModel.setId(flight.getId());
		flightModel.setPlane(planeDAO.getPlane(flight.getPlane()).getSerialNumber());
		flightModel.setTakeoffDate(flight.getTakeoffDate());
		flightModel.setPrice(flight.getPrice());
		
		return flightModel;
	}

	@Override
	@Transactional
	public List<Flight> getAllFlights() {
		return flightDAO.getAllFlights();
	}
	
	@Override
	@Transactional
	public List<Flight> getAllFlights(String date, int destination) {
		return flightDAO.getAllFlights(date, destination);
	}

	@Override
	@Transactional
	public Flight getFlight(int id) {
		return flightDAO.getFlight(id);
	}

	@Override
	@Transactional
	public LocalDate getMaxDate(String date, int destination) {
		return flightDAO.getMaxDate(date, destination);
	}

	@Override
	@Transactional
	public String getDisableDates(String date, int destination, LocalDate maxDate) {
		return flightDAO.getDisableDates(date, destination, maxDate);
	}

}
