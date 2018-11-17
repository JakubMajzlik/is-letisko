package airportis.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="flights")
public class Flight {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="takeoff_date")
	private String takeoffDate;
	
	@Column(name="destination")
	private int destination;
	
	@Column(name="gate")
	private int gate;
	
	@Column(name="plane")
	private String plane;
	
	@Column(name="price")
	private double price;
	
	public Flight() {}

	public Flight(String takeoff_date, int destination, int gate, String plane, double price) {
		this.takeoffDate = takeoff_date;
		this.destination = destination;
		this.gate = gate;
		this.plane = plane;
		this.price = price;
	}
	

	public Flight(int id, String takeoffDate, int destination, int gate, String plane, double price) {
		this.id = id;
		this.takeoffDate = takeoffDate;
		this.destination = destination;
		this.gate = gate;
		this.plane = plane;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTakeoffDate() {
		return takeoffDate;
	}

	public void setTakeoffDate(String takeoff_date) {
		this.takeoffDate = takeoff_date;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public int getGate() {
		return gate;
	}

	public void setGate(int gate) {
		this.gate = gate;
	}

	public String getPlane() {
		return plane;
	}

	public void setPlane(String plane) {
		this.plane = plane;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", takeoffDate=" + takeoffDate + ", destination=" + destination + ", gate=" + gate
				+ ", plane=" + plane + ", price=" + price + "]";
	}		
	
}
