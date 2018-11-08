package airportis.app.dao;

import java.util.List;
import java.util.Map;

import airportis.app.entity.Plane;

public interface PlaneDAO {
	
	public void save(Plane plane);
	public void remove(Plane plane);
	public Plane getPlane(String serialNumber);
	public Map<String, String> getPlanesMap();
	public List<Plane> getPlanesList();
}
