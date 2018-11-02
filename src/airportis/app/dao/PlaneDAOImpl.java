package airportis.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import airportis.app.entity.Plane;

@Repository
public class PlaneDAOImpl implements PlaneDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void save(Plane plane) {
		Session session= sessionFactory.getCurrentSession();
		session.saveOrUpdate(plane);
		
	}

	@Override
	public void remove(Plane plane) {
		Session session= sessionFactory.getCurrentSession();
		session.remove(plane);
		
	}

	@Override
	public Plane getPlane(String serialNumber) {
		Session session= sessionFactory.getCurrentSession();
		return session.get(Plane.class, serialNumber);
	}

}
