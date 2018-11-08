package airportis.app.model;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class PlaneModel {
	private String serialNumber;
	private String type;
	private String manufacturer;
	private String dateOfMade;
	private String lastRevisionDate;
	private int numberOfSeatsEconomic;
	private int numberOfSeatsBusiness;
	private int numberOfSeatsFirst;
	
	public PlaneModel() {}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDateOfMade() {
		return dateOfMade;
	}

	public void setDateOfMade(String dateOfMade) {
		this.dateOfMade = dateOfMade;
	}

	public String getLastRevisionDate() {
		return lastRevisionDate;
	}

	public void setLastRevisionDate(String lastRevisionDate) {
		this.lastRevisionDate = lastRevisionDate;
	}

	public int getNumberOfSeatsEconomic() {
		return numberOfSeatsEconomic;
	}

	public void setNumberOfSeatsEconomic(int numberOfSeatsEconomic) {
		this.numberOfSeatsEconomic = numberOfSeatsEconomic;
	}

	public int getNumberOfSeatsBusiness() {
		return numberOfSeatsBusiness;
	}

	public void setNumberOfSeatsBusiness(int numberOfSeatsBusiness) {
		this.numberOfSeatsBusiness = numberOfSeatsBusiness;
	}

	public int getNumberOfSeatsFirst() {
		return numberOfSeatsFirst;
	}

	public void setNumberOfSeatsFirst(int numberOfSeatsFirst) {
		this.numberOfSeatsFirst = numberOfSeatsFirst;
	}

	@Override
	public String toString() {
		return "PlaneModel [serialNumber=" + serialNumber + ", type=" + type + ", manufacturer=" + manufacturer
				+ ", dateOfMade=" + dateOfMade + ", lastRevisionDate=" + lastRevisionDate + ", numberOfSeatsEconomic="
				+ numberOfSeatsEconomic + ", numberOfSeatsBusiness=" + numberOfSeatsBusiness + ", numberOfSeatsFirst="
				+ numberOfSeatsFirst + "]";
	}
	////////////////////////////////////////////////////////////////////////////////
	
	
}
