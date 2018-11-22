package airportis.app.dao;

import java.util.List;

import airportis.app.entity.FlightTicket;

public interface FlightTicketDAO {
	
	public void save(FlightTicket flightTicket);
	public void remove(FlightTicket flightTicket);
	public FlightTicket getFlightTicket(int id);
	public int getEconomicTickets(int id);
	public int getBusinessTickets(int id);
	public int getFirstTickets(int id);
	public List<FlightTicket> getAllTickets(String identificationNumber); 
	
}
