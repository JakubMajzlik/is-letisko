package airportis.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

}
