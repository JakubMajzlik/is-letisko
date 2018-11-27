package airportis.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import airportis.app.dao.PlaneDAO;
import airportis.app.entity.Plane;
import airportis.app.model.PlaneModel;

@Service
public class PlaneServiceImpl implements PlaneService {

	@Autowired
	PlaneDAO planeDAO;
	
	@Override
	@Transactional
	public Map<String, String> getPlanesMap() {
		return planeDAO.getPlanesMap();
	}

	@Override
	@Transactional
	public void save(PlaneModel planeModel) {
		Plane plane= new Plane(
				planeModel.getSerialNumber(), 
				planeModel.getType(),
				planeModel.getManufacturer(),
				planeModel.getDateOfMade(),
				planeModel.getLastRevisionDate(),
				planeModel.getNumberOfSeatsEconomic(),
				planeModel.getNumberOfSeatsBusiness(),
				planeModel.getNumberOfSeatsFirst());
		planeDAO.save(plane);
	}

	@Override
	@Transactional
	public PlaneModel getPlane(String serialNumber) {
		Plane plane = planeDAO.getPlane(serialNumber);
		if(plane!=null) {
			PlaneModel planeModel= new PlaneModel();
			planeModel.setSerialNumber(plane.getSerialNumber());
			planeModel.setType(plane.getType());
			planeModel.setManufacturer(plane.getManufacturer());
			planeModel.setDateOfMade(plane.getDateOfMade());
			planeModel.setLastRevisionDate(plane.getLastRevisionDate());
			planeModel.setNumberOfSeatsEconomic(plane.getNumberOfSeatsEconomic());
			planeModel.setNumberOfSeatsBusiness(plane.getNumberOfSeatsBusiness());
			planeModel.setNumberOfSeatsFirst(plane.getNumberOfSeatsFirst());
			return planeModel;
		}else {
			return null;
		}
		
	}

	@Override
	@Transactional
	public List<Plane> getPlanesList() {
		return planeDAO.getPlanesList();
	}		
}
