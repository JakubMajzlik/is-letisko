package airportis.app.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class PlaneModel {
	
	@NotNull(message="This field is required")
	private String serialNumber;
	
	@NotNull(message="This field is required")
	private String type;
	
	@NotNull(message="This field is required")
	private String manufacturer;
	
	@NotNull(message="This field is required")
	private String dateOfMade;
	
	@NotNull(message="This field is required")
	private String lastRevisionDate;
	
	@Digits(fraction=0, integer = 10,
			message="This field has to contain only digits")
	private int numberOfSeatsEconomic;
	
	@Digits(fraction=0, integer = 10,
			message="This field has to contain only digits")
	private int numberOfSeatsBusiness;
	
	@Digits(fraction=0, integer = 10,
			message="This field has to contain only digits")
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
