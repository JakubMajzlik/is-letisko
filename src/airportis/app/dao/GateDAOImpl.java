package airportis.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import airportis.app.entity.Gate;

@Repository
public class GateDAOImpl implements GateDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Gate getGate(int gate) {
		Session session= sessionFactory.getCurrentSession();
		return session.get(Gate.class, gate);
	}

	@Override
	public void save(Gate gate) {
		Session session= sessionFactory.getCurrentSession();
		session.saveOrUpdate(gate);	
	}

	@Override
	public void remove(Gate gate) {
		Session session= sessionFactory.getCurrentSession();
		session.remove(gate);
	}

}
