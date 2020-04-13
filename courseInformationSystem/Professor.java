package courseInformationSystem;

import java.util.ArrayList;
import java.util.List;

public class Professor extends User{

	private String first;
	private String last;
	private String full;
	private ArrayList<Offering> coursesTeaching;
	private ArrayList<Student> advisees;
	
	public Professor() {
		coursesTeaching = new ArrayList<Offering>();
		advisees = new ArrayList<Student>();
		strategy = new ProfessorStrategy();
	}
	
	public Professor(String firstN, String lastN) {
		strategy = new ProfessorStrategy();
		coursesTeaching = new ArrayList<Offering>();
		advisees = new ArrayList<Student>();
		this.first = firstN.replaceAll("\\s", "");
		this.last = lastN.replaceAll("\\s", "");
		this.full = this.first + " " + this.last;
	}
	
	public Professor(Professor another) {
		this.strategy = another.strategy;
		this.advisees = another.advisees;
		this.coursesTeaching = another.coursesTeaching;
		this.first = another.first;
		this.last = another.last;
		this.full = another.first + " " + another.last;
	}
	
	public boolean addAdvisee(Student student) {
		this.advisees.add(student);
		return false;
	}
	
	public boolean addOffering(Offering courseOffering) {
		coursesTeaching.add(courseOffering);
		return true;
	}
	
	public boolean removeAdvisee(Student student) {
		return false;	
	}
	
	public ArrayList<Student> getAdvisees(){
		return this.advisees;
	}
	
	public String getName() {
		return this.full;
	}
	
	public void printAdvisees() {
		System.out.print("Advisees:\nName\tNetID\n");
		for(int i = 0; i < this.advisees.size(); i++) {
			System.out.print(this.advisees.get(i).toString() + "\n");
		}
	}
	
	public void setPersonalInfo(String name, String netID, String ssn, String address, String phone) {
		info = new PersonalInformation(name, netID, ssn, address, phone);
		this.full = name;
		this.first = name.split(" ")[0];
		this.last = name.split(" ")[1];
	}
	
	public String toString() {
		return (this.last + ", " + this.first);
	}
}
