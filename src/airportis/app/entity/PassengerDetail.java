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
	private String identificationNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="city")
	private String city;
	
	@Column(name="street")
	private String street;
	
	@Column(name="house_number")
	private String houseNumber;
	
	@Column(name="zip")
	private String zip;
	
	@Column(name="country")
	private String country;

	public PassengerDetail() {}
	
	public PassengerDetail(String identification_number, String email, String phone_number, String first_name,
			String last_name, String city, String street, String house_number, String zip, String country) {
		this.identificationNumber = identification_number;
		this.email = email;
		this.phoneNumber = phone_number;
		this.firstName = first_name;
		this.lastName = last_name;
		this.city = city;
		this.street = street;
		this.houseNumber = house_number;
		this.zip = zip;
		this.country = country;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
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
		return "PassengerDetail [identification_number=" + identificationNumber + ", email=" + email
				+ ", phone_number=" + phoneNumber + ", first_name=" + firstName + ", last_name=" + lastName
				+ ", city=" + city + ", street=" + street + ", house_number=" + houseNumber + ", zip=" + zip
				+ ", country=" + country + "]";
	}
	
}
