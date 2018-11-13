package airportis.app.service;

import airportis.app.entity.FlightTicket;

public interface FlightTicketService {
	
	void save(FlightTicket flightTicket);
	void remove(FlightTicket flightTicket);
	int getEconomicTickets(int id);
	int getBusinessTickets(int id);
	int getFirstTickets(int id);
}
