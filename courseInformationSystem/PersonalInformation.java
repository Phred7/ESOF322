package courseInformationSystem;

public class PersonalInformation {
	private String name;
	private String netID;
	private String ssn;
	private String address;
	private String phone;
	
	public PersonalInformation() {
		
	}
	
	public PersonalInformation(PersonalInformation another) {
		this.name = another.name;
		this.netID = another.netID;
		this.ssn = another.ssn;
		this.address = another.address;
		this.phone = another.phone;
	}
	
	public PersonalInformation(String name, String netID, String ssn, String address, String phone) {
		this.name = name;
		this.netID = netID;
		this.ssn = ssn;
		this.address = address;
		this.phone = phone;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getNetID() {
		return this.netID;
	}
	
	public void setNetID(String netID) {
		this.netID = netID;
	}
}
