package airportis.app.entity;

import java.util.Date;

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
	private Date dateOfMade;
	
	@Column(name="last_revision_date")
	private Date lastRevisionDate;
	
	@Column(name="number_of_seats")
	private int numberOfSeats;
	
	@Column(name="max_payload_in_tons")
	private int maxPayloadInTons;

	public Plane() {}
	
	public Plane(String serial_number, String type, String manufacturer, Date date_of_made, Date last_revision_date,
			int number_of_seats, int max_payload_in_tons) {
		this.serialNumber = serial_number;
		this.type = type;
		this.manufacturer = manufacturer;
		this.dateOfMade = date_of_made;
		this.lastRevisionDate = last_revision_date;
		this.numberOfSeats = number_of_seats;
		this.maxPayloadInTons = max_payload_in_tons;
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

	public Date getDateOfMade() {
		return dateOfMade;
	}

	public void setDateOfMade(Date dateOfMade) {
		this.dateOfMade = dateOfMade;
	}

	public Date getLastRevisionDate() {
		return lastRevisionDate;
	}

	public void setLastRevisionDate(Date lastRevisionDate) {
		this.lastRevisionDate = lastRevisionDate;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public int getMaxPayloadInTons() {
		return maxPayloadInTons;
	}

	public void setMaxPayloadInTons(int maxPayloadInTons) {
		this.maxPayloadInTons = maxPayloadInTons;
	}

	@Override
	public String toString() {
		return "Plane [serial_number=" + serialNumber + ", type=" + type + ", manufacturer=" + manufacturer
				+ ", date_of_made=" + dateOfMade + ", last_revision_date=" + lastRevisionDate + ", number_of_seats="
				+ numberOfSeats + ", max_payload_in_tons=" + maxPayloadInTons + "]";
	}
	
}
