package airportis.app.service;

import airportis.app.model.FlightModel;

public interface FlightService {

	void save(FlightModel flightModel);
	void remove(int id);
	FlightModel getFlight(int id);
}
