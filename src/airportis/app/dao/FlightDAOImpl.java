package airportis.app.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	
	@Override
	public List<Flight> getAllFlights(String stringDate, int destination) {
		Session session= sessionFactory.getCurrentSession();
		List<Flight> list= new ArrayList<>();
		System.out.println("DESTINATION: "+destination);
		System.out.println("DATE: "+stringDate);
		if(destination==0) {
			Query<Flight> flight= session.createQuery("from Flight", Flight.class);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm");
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			for (Flight f : flight.getResultList()) {
				LocalDate date= LocalDate.parse(stringDate, formatter1);
				LocalDate takeoffDate= LocalDate.parse(f.getTakeoffDate(), formatter);
				if(takeoffDate.compareTo(date)>=0) {
					list.add(f);
				}
			}
		}else if(stringDate ==""){
			Query<Flight> flight= session.createQuery("from Flight where destination= :destination", Flight.class);
			flight.setParameter("destination",destination);
			for (Flight f : flight.getResultList()) {
				list.add(f);
			}
		}else {
			Query<Flight> flight= session.createQuery("from Flight where destination= :destination", Flight.class);
			flight.setParameter("destination",destination);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm");
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			for (Flight f : flight.getResultList()) {
				LocalDate date= LocalDate.parse(stringDate, formatter1);
				LocalDate takeoffDate= LocalDate.parse(f.getTakeoffDate(), formatter);
				if(takeoffDate.compareTo(date)>=0) {
					list.add(f);
				}
			}
		}
		
		return list;
	}

}
