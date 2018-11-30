package airportis.app.service;

import java.time.LocalDate;
import java.util.List;

import airportis.app.entity.Flight;
import airportis.app.model.FlightModel;

public interface FlightService {

	void save(FlightModel flightModel);
	void remove(int id);
	Flight getFlight(int id);
	FlightModel getFlightModel(int id);
	List<Flight> getAllFlights();
	List<Flight> getAllFlights(String date, int destination);
	LocalDate getMaxDate(String date, int destination);
	String getDisableDates(String date, int destination, LocalDate maxDate);
}
