package airportis.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gates")
public class Gate {
	
	@Id
	@Column(name="gate_number")
	private int gateNumber;
	
	@Column(name="terminal")
	private char terminal;

	public Gate() {}
	
	public Gate(int gate_number, char terminal) {
		super();
		this.gateNumber = gate_number;
		this.terminal = terminal;
	}

	public int getGateNumber() {
		return gateNumber;
	}

	public void setGateNumber(int gate_number) {
		this.gateNumber = gate_number;
	}

	public char getTerminal() {
		return terminal;
	}

	public void setTerminal(char terminal) {
		this.terminal = terminal;
	}

	@Override
	public String toString() {
		return "Gate [gate_number=" + gateNumber + ", terminal=" + terminal + "]";
	}
	
	
	
}
