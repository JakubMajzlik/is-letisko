package airportis.app.service;

import java.util.List;

import airportis.app.entity.FlightTicket;

public interface FlightTicketService {
	
	void save(FlightTicket flightTicket);
	void remove(FlightTicket flightTicket);
	int getEconomicTickets(int id);
	int getBusinessTickets(int id);
	int getFirstTickets(int id);
	List<FlightTicket> getAllFlightTickets(String identificationNumber);
	FlightTicket getFlightTicket(int id);
}
