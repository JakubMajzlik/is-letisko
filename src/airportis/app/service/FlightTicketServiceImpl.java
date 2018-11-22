package airportis.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import airportis.app.dao.FlightTicketDAO;
import airportis.app.entity.FlightTicket;

@Service
public class FlightTicketServiceImpl implements FlightTicketService{

	@Autowired
	FlightTicketDAO flightTicketDAO;
	
	@Override
	@Transactional
	public void save(FlightTicket flightTicket) {
		flightTicketDAO.save(flightTicket);
		
	}

	@Override
	@Transactional
	public void remove(FlightTicket flightTicket) {
		flightTicketDAO.remove(flightTicket);
		
	}

	@Override
	@Transactional
	public int getEconomicTickets(int id) {
		return flightTicketDAO.getEconomicTickets(id);
	}

	@Override
	@Transactional
	public int getBusinessTickets(int id) {
		return flightTicketDAO.getBusinessTickets(id);
	}

	@Override
	@Transactional
	public int getFirstTickets(int id) {
		return flightTicketDAO.getFirstTickets(id);
	}

	@Override
	@Transactional
	public List<FlightTicket> getAllFlightTickets(String identificationNumber) {
		return flightTicketDAO.getAllTickets(identificationNumber);
	}

	@Override
	@Transactional
	public FlightTicket getFlightTicket(int id) {
		return flightTicketDAO.getFlightTicket(id);
	}

}
