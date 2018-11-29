package airportis.app.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class FlightModel {
	@Size(min=2,message="This field is required")
	private String takeoffDate;
	
	@Min(value=1, message="This field is required")
	private Integer destination = 0;
	
	@Min(value=1, message="This field is required")
	private int gate;
	
	@Size(min=2,message="This field is required")
	private String plane;
	
	private int id;
	
	@Digits(fraction=2, integer = 10,
			message="This field has to contain only digits")
	private double price;
	
	public FlightModel() {}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTakeoffDate() {
		return takeoffDate;
	}
	public void setTakeoffDate(String takeoffDate) {
		this.takeoffDate= takeoffDate;
	}
	
	public int getDestination() {
		return destination.intValue();
	}

	public void setDestination(Integer destination) {
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
		return "FlightModel [takeoffDate=" + takeoffDate + ", destination=" + destination + ", gate=" + gate
				+ ", plane=" + plane + ", id=" + id + ", price=" + price + "]";
	}
	
}
