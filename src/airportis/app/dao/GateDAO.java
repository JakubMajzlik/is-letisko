package airportis.app.dao;

import airportis.app.entity.Gate;

public interface GateDAO {
	
	public void save(Gate gate);
	public void remove(Gate gate);
	public Gate getGate(int gate);
	
}
