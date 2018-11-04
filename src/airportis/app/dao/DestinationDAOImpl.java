package airportis.app.dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import airportis.app.entity.Destination;

@Repository
public class DestinationDAOImpl implements DestinationDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void save(Destination destination) {
		Session session= sessionFactory.getCurrentSession();
		session.saveOrUpdate(destination);
		
	}

	@Override
	public void remove(Destination destination) {
		Session session= sessionFactory.getCurrentSession();
		session.remove(destination);
		
	}

	@Override
	public Destination getDestination(String country, String city) {
		Session session= sessionFactory.getCurrentSession();
		Query<Destination> destination= session.createQuery("from Destination where country=:countryName and city=:cityName", Destination.class);
		destination.setParameter("countryName", country);
		destination.setParameter("cityName", city);
		return destination.getSingleResult();
	}

	@Override
	public Destination getDestination(int id) {
		Session session= sessionFactory.getCurrentSession();
		Destination destination= session.get(Destination.class, id);
		return destination;
	}

	@Override
	public Map<Integer, String> getAllDestinations() {
		Session session= sessionFactory.getCurrentSession();
		Map<Integer, String> map= new HashMap<>();
		Query<Destination> destination= session.createQuery("from Destination", Destination.class);
		for (Destination d : destination.getResultList()) {
			map.put(d.getId(), d.getCity()+", "+ d.getCountry());
		}
		return map;
	}

}
