package airportis.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planes")
public class Plane {

	@Id
	@Column(name="serial_number")
	private String serialNumber;
	
	@Column(name="type")
	private String type;
	
	@Column(name="manufacturer")
	private String manufacturer;
	
	@Column(name="date_of_made")
	private String dateOfMade;
	
	@Column(name="last_revision_date")
	private String lastRevisionDate;
	
	@Column(name="number_of_seats_economic")
	private int numberOfSeatsEconomic;
	
	@Column(name="number_of_seats_business")
	private int numberOfSeatsBusiness;
	
	@Column(name="number_of_seats_first")
	private int numberOfSeatsFirst;
	
	@Column(name="max_payload_in_tons")
	private int maxPayloadInTons;

	public Plane() {}
	
	

	public Plane(String serialNumber, String type, String manufacturer, String dateOfMade, String lastRevisionDate,
			int numberOfSeatsEconomic, int numberOfSeatsBusiness, int numberOfSeatsFirst, int maxPayloadInTons) {
		this.serialNumber = serialNumber;
		this.type = type;
		this.manufacturer = manufacturer;
		this.dateOfMade = dateOfMade;
		this.lastRevisionDate = lastRevisionDate;
		this.numberOfSeatsEconomic = numberOfSeatsEconomic;
		this.numberOfSeatsBusiness = numberOfSeatsBusiness;
		this.numberOfSeatsFirst = numberOfSeatsFirst;
		this.maxPayloadInTons = maxPayloadInTons;
	}



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



	public int getMaxPayloadInTons() {
		return maxPayloadInTons;
	}

	public void setMaxPayloadInTons(int maxPayloadInTons) {
		this.maxPayloadInTons = maxPayloadInTons;
	}



	@Override
	public String toString() {
		return "Plane [serialNumber=" + serialNumber + ", type=" + type + ", manufacturer=" + manufacturer
				+ ", dateOfMade=" + dateOfMade + ", lastRevisionDate=" + lastRevisionDate + ", numberOfSeatsEconomic="
				+ numberOfSeatsEconomic + ", numberOfSeatsBusiness=" + numberOfSeatsBusiness + ", numberOfSeatsFirst="
				+ numberOfSeatsFirst + ", maxPayloadInTons=" + maxPayloadInTons + "]";
	}


	
}
