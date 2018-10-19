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
	private int gate_number;
	
	@Column(name="terminal")
	private char terminal;

	public Gate() {}
	
	public Gate(int gate_number, char terminal) {
		super();
		this.gate_number = gate_number;
		this.terminal = terminal;
	}

	public int getGate_number() {
		return gate_number;
	}

	public void setGate_number(int gate_number) {
		this.gate_number = gate_number;
	}

	public char getTerminal() {
		return terminal;
	}

	public void setTerminal(char terminal) {
		this.terminal = terminal;
	}

	@Override
	public String toString() {
		return "Gate [gate_number=" + gate_number + ", terminal=" + terminal + "]";
	}
	
	
	
}
