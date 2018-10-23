package airportis.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="passenger_details")
public class PassengerDetail {
	
	@Id
	@Column(name="identification_number")
	private String identification_number;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone_number")
	private String phone_number;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="city")
	private String city;
	
	@Column(name="street")
	private String street;
	
	@Column(name="house_number")
	private String house_number;
	
	@Column(name="zip")
	private String zip;
	
	@Column(name="country")
	private String country;

	public PassengerDetail() {}
	
	public PassengerDetail(String identification_number, String email, String phone_number, String first_name,
			String last_name, String city, String street, String house_number, String zip, String country) {
		this.identification_number = identification_number;
		this.email = email;
		this.phone_number = phone_number;
		this.first_name = first_name;
		this.last_name = last_name;
		this.city = city;
		this.street = street;
		this.house_number = house_number;
		this.zip = zip;
		this.country = country;
	}

	public String getIdentification_number() {
		return identification_number;
	}

	public void setIdentification_number(String identification_number) {
		this.identification_number = identification_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse_number() {
		return house_number;
	}

	public void setHouse_number(String house_number) {
		this.house_number = house_number;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "PassengerDetail [identification_number=" + identification_number + ", email=" + email
				+ ", phone_number=" + phone_number + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", city=" + city + ", street=" + street + ", house_number=" + house_number + ", zip=" + zip
				+ ", country=" + country + "]";
	}
	
}
