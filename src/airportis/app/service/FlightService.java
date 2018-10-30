package airportis.app.service;

import airportis.app.entity.Flight;
import airportis.app.model.FlightModel;

public interface FlightService {

	void save(FlightModel flightModel);
	void remove(int id);
	Flight getFlight(int id);
}
