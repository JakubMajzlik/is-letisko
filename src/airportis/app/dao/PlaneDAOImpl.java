package airportis.app.dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

	@Override
	public Map<String, String> getAllPlanes() {
		Session session = sessionFactory.getCurrentSession();
		Query<Plane> planeQuery = session.createQuery("from Plane", Plane.class);
		Map<String, String> planeMap = new HashMap<>();
		for(Plane tempPlane : planeQuery.list()) {
			planeMap.put(tempPlane.getSerialNumber(), tempPlane.getSerialNumber());
		}
		return planeMap;
	}

}
