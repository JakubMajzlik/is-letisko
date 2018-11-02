package airportis.app.dao;

import airportis.app.entity.FlightTicket;

public interface FlightTicketDAO {
	
	public void save(FlightTicket flightTicket);
	public void remove(FlightTicket flightTicket);
	public FlightTicket getFlightTicket(int id);
	
}
