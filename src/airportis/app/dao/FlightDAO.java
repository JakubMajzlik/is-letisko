package airportis.app.dao;

import java.time.LocalDate;
import java.util.List;

import airportis.app.entity.Flight;

public interface FlightDAO {
	
	void save(Flight flight);
	void remove(Flight flight);
	Flight getFlight(int id);
	List<Flight> getAllFlights();
	List<Flight> getAllFlights(String date, int destination);
	LocalDate getMaxDate(String date, int destination);
	String getDisableDates(String date, int destination, LocalDate maxDate);
}
