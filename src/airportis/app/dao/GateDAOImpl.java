package airportis.app.dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import airportis.app.entity.Gate;
import airportis.app.entity.Plane;

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

	@Override
	public Map<Integer, String> getAllGates() {
		Session session = sessionFactory.getCurrentSession();
		Query<Gate> gateQuery = session.createQuery("from Gate", Gate.class);
		Map<Integer, String> gateMap = new HashMap<>();
		for(Gate tempGate : gateQuery.list()) {
			gateMap.put(tempGate.getGateNumber(), tempGate.getTerminal() +""+ tempGate.getGateNumber());
		}
		return gateMap;
	}

}
