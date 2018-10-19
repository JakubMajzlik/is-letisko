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
	private String serial_number;
	
	@Column(name="type")
	private String type;
	
	@Column(name="manufacturer")
	private String manufacturer;
	
	@Column(name="date_of_made")
	private Date date_of_made;
	
	@Column(name="last_revision_date")
	private Date last_revision_date;
	
	@Column(name="number_of_seats")
	private int number_of_seats;
	
	@Column(name="max_payload_in_tons")
	private int max_payload_in_tons;

	public Plane() {}
	
	public Plane(String serial_number, String type, String manufacturer, Date date_of_made, Date last_revision_date,
			int number_of_seats, int max_payload_in_tons) {
		super();
		this.serial_number = serial_number;
		this.type = type;
		this.manufacturer = manufacturer;
		this.date_of_made = date_of_made;
		this.last_revision_date = last_revision_date;
		this.number_of_seats = number_of_seats;
		this.max_payload_in_tons = max_payload_in_tons;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
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

	public Date getDate_of_made() {
		return date_of_made;
	}

	public void setDate_of_made(Date date_of_made) {
		this.date_of_made = date_of_made;
	}

	public Date getLast_revision_date() {
		return last_revision_date;
	}

	public void setLast_revision_date(Date last_revision_date) {
		this.last_revision_date = last_revision_date;
	}

	public int getNumber_of_seats() {
		return number_of_seats;
	}

	public void setNumber_of_seats(int number_of_seats) {
		this.number_of_seats = number_of_seats;
	}

	public int getMax_payload_in_tons() {
		return max_payload_in_tons;
	}

	public void setMax_payload_in_tons(int max_payload_in_tons) {
		this.max_payload_in_tons = max_payload_in_tons;
	}

	@Override
	public String toString() {
		return "Plane [serial_number=" + serial_number + ", type=" + type + ", manufacturer=" + manufacturer
				+ ", date_of_made=" + date_of_made + ", last_revision_date=" + last_revision_date + ", number_of_seats="
				+ number_of_seats + ", max_payload_in_tons=" + max_payload_in_tons + "]";
	}
	
}
