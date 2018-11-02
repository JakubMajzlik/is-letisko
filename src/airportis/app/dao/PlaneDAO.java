package airportis.app.dao;

import java.util.Map;

import airportis.app.entity.Plane;

public interface PlaneDAO {
	
	public void save(Plane plane);
	public void remove(Plane plane);
	public Plane getPlane(String serialNumber);
	public Map<String, String> getAllPlanes();
}
