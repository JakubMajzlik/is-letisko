package airportis.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import airportis.app.entity.Flight;
import airportis.app.entity.FlightTicket;

	@Repository
	public class FlightTicketDAOImpl implements FlightTicketDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void save(FlightTicket flightTicket) {
		Session session= sessionFactory.getCurrentSession();
		session.saveOrUpdate(flightTicket);
	}

	@Override
	public void remove(FlightTicket flightTicket) {
		Session session= sessionFactory.getCurrentSession();
		session.remove(flightTicket);
		
	}

	@Override
	public FlightTicket getFlightTicket(int id) {
		Session session= sessionFactory.getCurrentSession();
		FlightTicket flightTicket= session.get(FlightTicket.class, id);
		return flightTicket;
	}

	@Override
	public int getEconomicTickets(int id) {
		Session session= sessionFactory.getCurrentSession();
		return session.createQuery("from FlightTicket where seatClass = 'Economic' and flight= :id", FlightTicket.class).setParameter("id", id).getResultList().size();
	}

	@Override
	public int getBusinessTickets(int id) {
		Session session= sessionFactory.getCurrentSession();
		return session.createQuery("from FlightTicket where seatClass = 'Business' and flight= :id", FlightTicket.class).setParameter("id", id).getResultList().size();
	}

	@Override
	public int getFirstTickets(int id) {
		Session session= sessionFactory.getCurrentSession();
		return session.createQuery("from FlightTicket where seatClass = 'First' and flight= :id", FlightTicket.class).setParameter("id", id).getResultList().size();
	}

}
