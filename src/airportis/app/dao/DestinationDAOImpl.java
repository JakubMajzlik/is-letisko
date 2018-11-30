package airportis.app.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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
			map.put(d.getId(), d.getCity()+", "+ d.getCountry() +", "+ d.getAirport());
		}
		Map<Integer, String>sortedMap = new TreeMap<>(map);
		return map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
	}

	@Override
	public List<Destination> getListOfDestinations() {
		Session session= sessionFactory.getCurrentSession();
		List<Destination> listOfDestinations= new ArrayList<Destination>();
		Query<Destination> destination= session.createQuery("from Destination", Destination.class);
		listOfDestinations= destination.getResultList();
		return listOfDestinations;
	}

}
