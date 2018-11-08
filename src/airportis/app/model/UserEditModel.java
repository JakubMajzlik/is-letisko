package airportis.app.model;

public class UserEditModel {
private String firstName;
	
	private int id;

	private String lastName;
	
	private String email;
	
	private String password1;
	
	private String password2;
	
	private String city;
	
	private String street;
	
	private String houseNumber;
	
	private String zip;
	
	private String country;
	
	private String identificationNumber;
	
	private String phoneNumber;
	
	

	public UserEditModel() {}

	public UserEditModel(int id,String firstName, String lastName, String email, String password1, String password2,
			String city, String street, String houseNumber, String zip, String country, String identificationNumber,
			String phoneNumber) {
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
