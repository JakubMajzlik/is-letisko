package airportis.app.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import airportis.app.validator.FieldMatch;

@FieldMatch.List({@FieldMatch(first="password1", second="password2", message="The password fields must match")})
public class UserRegisterModel {

	@NotNull(message="This field is required")
	private String firstName;
	
	@NotNull(message="This field is required")
	private String lastName;
	
	@NotNull(message="This field is required")
	@Email(message="Invalid email format")
	private String email;
	
	@NotNull(message="This field is required")
	@Size(min=8, message="Password have to be at least 8 characters long")
	private String password1;
	
	@NotNull(message="This field is required")
	private String password2;
	
	@NotNull(message="This field is required")
	private String city;
	
	@NotNull(message="This field is required")
	private String street;
	
	@NotNull(message="This field is required")
	@Digits(fraction=0, integer = 5,
			message="This field must contains only digits")
	private String houseNumber;
	
	@Digits(fraction=0, integer = 5,
			message="This field must contains only digits")
	@NotNull(message="This field is required")
	private String zip;
	
	@NotNull(message="This field is required")
	private String country;
	
	@NotNull(message="This field is required")
	private String identificationNumber;
	
	@Digits(fraction=0, integer = 20,
			message="This field must contains only digits")
	@NotNull(message="This field is required")
	private String phoneNumber;
	
	

	public UserRegisterModel() {}

	public UserRegisterModel(String firstName, String lastName, String email, String password1, String password2,
			String city, String street, String houseNumber, String zip, String country, String identificationNumber,
			String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password1 = password1;
		this.password2 = password2;
		this.city = city;
		this.street = street;
		this.houseNumber = houseNumber;
		this.zip = zip;
		this.country = country;
		this.identificationNumber = identificationNumber;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
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

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identification_number) {
		this.identificationNumber = identification_number;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
