package courseInformationSystem;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Student extends User{
	
	private String major;
	private ArrayList<Course> registeredCourses;
	private int currentSemester;
	private Professor advisor;
	//private <List<Course>, List<Course>> degreeProgress;
	private String programOfStudy = "\n\nProgram of Study Displayed Here\n\n";
	//private Image programOfStudy;
		
	public Student() {
		strategy = new StudentStrategy();
	}
	
	public Student(String netID) {
		strategy = new StudentStrategy();
		this.info = new PersonalInformation();
		this.info.setNetID(netID);
	}
	
	public boolean selectAdvisor() {
		return false;	
	}
	
	public boolean modifyProgress(ArrayList<Course> courses) {
		return false;
	}
	
	public ArrayList<ArrayList<Course>> degreeProgress(){
		return null;
	}
	
	public String getProgramStudy() {
		return programOfStudy;
	}
	
	public String getNetID() {
		return this.info.getNetID();
	}
	
	public void setPersonalInfo(String name, String netID, String ssn, String address, String phone) {
		info = new PersonalInformation(name, netID, ssn, address, phone);
	}
	
	public String toString() {
		return this.info.getName() + "\t" + this.info.getNetID();
	}
}
