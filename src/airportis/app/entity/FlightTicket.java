package airportis.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight_tickets")
public class FlightTicket {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="boarding_time")
	private Date boardingTime;
	
	@Column(name="flight")
	private int flight;
	
	@Column(name="seat")
	private String seat;
	
	@Column(name="plane")
	private String plane;
	
	@Column(name="user_identification_number")
	private String userIdentificationNumber;

	public FlightTicket() {}

	public FlightTicket(Date boarding_time, int flight, String seat, String plane, String user_identification_number) {
		super();
		this.boardingTime = boarding_time;
		this.flight = flight;
		this.seat = seat;
		this.plane = plane;
		this.userIdentificationNumber = user_identification_number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(Date boarding_time) {
		this.boardingTime = boarding_time;
	}

	public int getFlight() {
		return flight;
	}

	public void setFlight(int flight) {
		this.flight = flight;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getPlane() {
		return plane;
	}

	public void setPlane(String plane) {
		this.plane = plane;
	}

	public String getUserIdentificationNumber() {
		return userIdentificationNumber;
	}

	public void setUserIdentificationNumber(String user_identification_number) {
		this.userIdentificationNumber = user_identification_number;
	}

	@Override
	public String toString() {
		return "FlightTicket [id=" + id + ", boarding_time=" + boardingTime + ", flight=" + flight + ", seat=" + seat
				+ ", plane=" + plane + ", user_identification_number=" + userIdentificationNumber + "]";
	}
	
	
	
}
