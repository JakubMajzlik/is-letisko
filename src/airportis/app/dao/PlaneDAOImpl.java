package airportis.app.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	public Map<String, String> getPlanesMap() {
		Session session = sessionFactory.getCurrentSession();
		Query<Plane> planeQuery = session.createQuery("from Plane", Plane.class);
		Map<String, String> planeMap = new HashMap<>();
		for(Plane tempPlane : planeQuery.list()) {
			planeMap.put(tempPlane.getSerialNumber(), tempPlane.getSerialNumber());
		}
		return planeMap;
	}

	@Override
	public List<Plane> getPlanesList() {
		Session session= sessionFactory.getCurrentSession();
		List<Plane> list= new ArrayList<>();
		Query<Plane> plane= session.createQuery("from Plane", Plane.class);
		for (Plane p : plane.getResultList()) {
			System.out.println(p);
			list.add(p);
		}
		
		return list;
	}

}
