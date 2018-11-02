package airportis.app.dao;

import airportis.app.entity.Plane;

public interface PlaneDAO {
	
	public void save(Plane plane);
	public void remove(Plane plane);
	public Plane getPlane(String serialNumber);
	
}
