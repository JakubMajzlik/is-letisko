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
		if(destination==0 && (stringDate==null || stringDate=="")) {
			Query<Flight> flight= session.createQuery("from Flight", Flight.class);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd kk:mm");
			LocalDate date= LocalDate.now();
			for (Flight f : flight.getResultList()) {
				LocalDate takeoffDate= LocalDate.parse(f.getTakeoffDate(), formatter);
				if(takeoffDate.compareTo(date)==0) {
					list.add(f);
				}
			}
		}else if(destination==0 && (stringDate!=null && stringDate!="")) {
			Query<Flight> flight= session.createQuery("from Flight", Flight.class);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd kk:mm");
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate date= LocalDate.parse(stringDate, formatter1);
			for (Flight f : flight.getResultList()) {
				LocalDate takeoffDate= LocalDate.parse(f.getTakeoffDate(), formatter);
				if(takeoffDate.compareTo(date)==0) {
					list.add(f);
				}
			}
		}else if(stringDate ==null || stringDate==""){
			Query<Flight> flight= session.createQuery("from Flight where destination= :destination", Flight.class);
			flight.setParameter("destination",destination);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd kk:mm");
			LocalDate date= LocalDate.now();
			for (Flight f : flight.getResultList()) {
				LocalDate takeoffDate= LocalDate.parse(f.getTakeoffDate(), formatter);
				if(takeoffDate.compareTo(date)>=0) {
					list.add(f);
				}
			}
		}else {
			Query<Flight> flight= session.createQuery("from Flight where destination= :destination", Flight.class);
			flight.setParameter("destination",destination);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd kk:mm");
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate date= LocalDate.parse(stringDate, formatter1);
			for (Flight f : flight.getResultList()) {
				LocalDate takeoffDate= LocalDate.parse(f.getTakeoffDate(), formatter);
				if(takeoffDate.compareTo(date)==0) {
					list.add(f);
				}
			}
		}
		
		return list;
	}

	
	@Override
	public LocalDate getMaxDate(String stringDate, int destination) {
		Session session= sessionFactory.getCurrentSession();
		if(destination==0 && (stringDate==null || stringDate=="")) {
			Query<Flight> flight= session.createQuery("from Flight", Flight.class);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd kk:mm");
			LocalDate date= LocalDate.now();
			for (Flight f : flight.getResultList()) {
				LocalDate takeoffDate= LocalDate.parse(f.getTakeoffDate(), formatter);
				if(takeoffDate.compareTo(date)>0) {
					date=takeoffDate;
				}
			}
			return date;
		}else if(destination==0 && (stringDate!=null && stringDate!="")) {
			Query<Flight> flight= session.createQuery("from Flight", Flight.class);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd kk:mm");
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate date= LocalDate.parse(stringDate, formatter1);
			for (Flight f : flight.getResultList()) {
				LocalDate takeoffDate= LocalDate.parse(f.getTakeoffDate(), formatter);
				if(takeoffDate.compareTo(date)>0) {
					date=takeoffDate;
				}
			}
			return date;
		}else if(stringDate ==null || stringDate==""){
			Query<Flight> flight= session.createQuery("from Flight where destination= :destination", Flight.class);
			flight.setParameter("destination",destination);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd kk:mm");
			LocalDate date= LocalDate.now();
			for (Flight f : flight.getResultList()) {
				LocalDate takeoffDate= LocalDate.parse(f.getTakeoffDate(), formatter);
				if(takeoffDate.compareTo(date)>0) {
					date=takeoffDate;
				}
			}
			return date;
		}else {
			Query<Flight> flight= session.createQuery("from Flight where destination= :destination", Flight.class);
			flight.setParameter("destination",destination);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd kk:mm");
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate date= LocalDate.parse(stringDate, formatter1);
			for (Flight f : flight.getResultList()) {
				LocalDate takeoffDate= LocalDate.parse(f.getTakeoffDate(), formatter);
				if(takeoffDate.compareTo(date)>0) {
					date=takeoffDate;
				}
			}
			return date;
		}
	}
	
	@Override
	public String getDisableDates(String stringDate, int destination, LocalDate maxDate) {
		Session session= sessionFactory.getCurrentSession();
		List<LocalDate> list= new ArrayList<>();
		String result=null;
		if(destination==0) {
			Query<Flight> flight= session.createQuery("from Flight", Flight.class);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd kk:mm");
			LocalDate date= LocalDate.now();
			for (Flight f : flight.getResultList()) {
				LocalDate takeoffDate= LocalDate.parse(f.getTakeoffDate(), formatter);
				if(takeoffDate.compareTo(date)>0) {
					list.add(takeoffDate);
				}
			}
			do {
				boolean equal=false;
				for(LocalDate l : list) {
					System.out.println(date +" : "+l);
					if(date.compareTo(l)==0) {
						equal=true;
						break;
					}
				}
				if(!equal) {
					if(result==null) {
						result="[\'" + date.getYear() +"/"+ date.getMonthValue() +"/"+ date.getDayOfMonth() +"\'";
					}else {
						result= result+", \'"+ date.getYear() +"/"+ date.getMonthValue() +"/"+ date.getDayOfMonth() +"\'";
					}
				}
				date = date.plusDays(1);
			}while(date.compareTo(maxDate)!=0);
			result=result + "]";
			return result;
		}else{
			Query<Flight> flight= session.createQuery("from Flight where destination= :destination", Flight.class);
			flight.setParameter("destination",destination);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd kk:mm");
			LocalDate date= LocalDate.now();
			for (Flight f : flight.getResultList()) {
				LocalDate takeoffDate= LocalDate.parse(f.getTakeoffDate(), formatter);
				if(takeoffDate.compareTo(date)>0) {
					list.add(takeoffDate);
				}
			}
			do {
				boolean equal=false;
				for(LocalDate l : list) {
					System.out.println(date +" : "+l);
					if(date.compareTo(l)==0) {
						equal=true;
						break;
					}
				}
				if(!equal) {
					if(result==null) {
						result="[\'" + date.getYear() +"/"+ date.getMonthValue() +"/"+ date.getDayOfMonth() +"\'";
					}else {
						result= result+", \'"+ date.getYear() +"/"+ date.getMonthValue() +"/"+ date.getDayOfMonth() +"\'";
					}
				}
				date = date.plusDays(1);
			}while(date.compareTo(maxDate)!=0);
			result=result + "]";
			return result;
		}
	}
}
