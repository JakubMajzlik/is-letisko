package airportis.app.model;

public class FilterModel {
	private String takeoffDate;
	private int destination;
	
	public FilterModel() {}
	
	public String getTakeoffDate() {
		return takeoffDate;
	}
	public void setTakeoffDate(String takeoffDate) {
		this.takeoffDate = takeoffDate;
	}
	public int getDestination() {
		return destination;
	}
	public void setDestination(int destination) {
		this.destination = destination;
	}
	
}
