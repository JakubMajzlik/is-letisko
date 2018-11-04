package airportis.app.dao;

import java.util.List;

import airportis.app.entity.Flight;

public interface FlightDAO {
	
	void save(Flight flight);
	void remove(Flight flight);
	Flight getFlight(int id);
	List<Flight> getAllFlights();
	
}
