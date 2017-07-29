package Project;

public class User {
	//Fields
	private String firstName;
	private String lastName;
	private String address;
	private String dateOfBirth;
	private String phoneNumber;
	private String city;
	private String state;
	private String zip;
	private int numOfLoans;
	
	//No-Arg Constructor
	public User ()
	{
		
	}
	
	//Constructor
	public User(String firstName, String lastName, String address, String dateOfBirth, String phoneNumber,
			int numOfLoans) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.numOfLoans = numOfLoans;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getNumOfLoans() {
		return numOfLoans;
	}

	public void setNumOfLoans(int numOfLoans) {
		this.numOfLoans = numOfLoans;
	}
	

}
