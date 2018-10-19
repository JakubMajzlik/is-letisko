package airportis.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seats")
public class Seat {
	
	@Id
	@Column(name="number")
	private String number;
	
	@Column(name="plane")
	private String plane;
	
	@Column(name="class")
	private String seat_class;

	public Seat() {}
	
	public Seat(String number, String plane, String seat_class) {
		super();
		this.number = number;
		this.plane = plane;
		this.seat_class = seat_class;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPlane() {
		return plane;
	}

	public void setPlane(String plane) {
		this.plane = plane;
	}

	public String getSeat_class() {
		return seat_class;
	}

	public void setSeat_class(String seat_class) {
		this.seat_class = seat_class;
	}

	@Override
	public String toString() {
		return "Seat [number=" + number + ", plane=" + plane + ", seat_class=" + seat_class + "]";
	}
	
}
