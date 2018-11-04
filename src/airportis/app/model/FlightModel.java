package airportis.app.model;

//TODO VALIDACIE
public class FlightModel {
	private String takeoffDate;
	private Integer destination = 0;
	private int gate;
	private String plane;
	private int id;
	
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

	@Override
	public String toString() {
		return "FlightModel [takeoffDate=" + takeoffDate + ", destination=" + destination + ", gate=" + gate
				+ ", plane=" + plane + ", id=" + id + "]";
	}
	
	
}
