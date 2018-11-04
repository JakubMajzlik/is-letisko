package airportis.app.service;

import java.util.List;

import airportis.app.entity.Flight;
import airportis.app.model.FlightModel;

public interface FlightService {

	void save(FlightModel flightModel);
	void update(FlightModel flightModel);
	void remove(int id);
	FlightModel getFlight(int id);
	List<Flight> getAllFlights();
}
