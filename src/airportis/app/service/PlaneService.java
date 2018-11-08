package airportis.app.service;

import java.util.List;
import java.util.Map;

import airportis.app.entity.Plane;
import airportis.app.model.PlaneModel;

public interface PlaneService {
	Map<String, String> getPlanesMap();
	void save(PlaneModel planeModel);
	PlaneModel getPlane(String serialNumber);
	List<Plane> getPlanesList();
}
