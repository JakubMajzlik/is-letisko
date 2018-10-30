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
	private String seatClass;

	public Seat() {}
	
	public Seat(String number, String plane, String seat_class) {
		super();
		this.number = number;
		this.plane = plane;
		this.seatClass = seat_class;
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

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seat_class) {
		this.seatClass = seat_class;
	}

	@Override
	public String toString() {
		return "Seat [number=" + number + ", plane=" + plane + ", seat_class=" + seatClass + "]";
	}
	
}
