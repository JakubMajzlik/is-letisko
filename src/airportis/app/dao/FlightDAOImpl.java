package airportis.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import airportis.app.entity.Flight;

@Repository
public class FlightDAOImpl implements FlightDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Flight flight) {
		Session session= sessionFactory.getCurrentSession();
		session.saveOrUpdate(flight);
	}

	@Override
	public void remove(Flight flight) {
		Session session= sessionFactory.getCurrentSession();
		session.remove(flight);
	}

	@Override
	public Flight getFlight(int id) {
		Session session= sessionFactory.getCurrentSession();
		Flight flight= session.get(Flight.class, id);
		return flight;
	}

	@Override
	public List<Flight> getAllFlights() {
		Session session= sessionFactory.getCurrentSession();
		List<Flight> list= new ArrayList<>();
		Query<Flight> flight= session.createQuery("from Flight", Flight.class);
		for (Flight f : flight.getResultList()) {
			list.add(f);
		}
		return list;
	}

}
