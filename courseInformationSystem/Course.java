package courseInformationSystem;

import java.util.ArrayList;
import java.util.List;

public class Course {
	
	private int crn;
	private int numCredits;
	private String name; //title
	private String number; //course number ex: '305' in csci 305
	private String department; //course dept. ex: 'csci' in csci 305
	private String courseID; //course id ex: 'csci 305'
	private String description;
	private ArrayList<String> schedule;
	private ArrayList<Course> prerequisites;
	private ArrayList<Offering> offerings;
	
	public Course(int crn, int seatCap, int enrolled, int section, String title, String courseId, String location, String days, String time, Professor prof) {
		this.schedule = new ArrayList<String>();
		this.prerequisites = new ArrayList<Course>();
		this.offerings = new ArrayList<Offering>();
		
		this.crn = crn;
		this.numCredits = 3;
		this.name = title;
		this.courseID = courseId.split("-")[0];
		
		String[] x = courseId.split(" ");
		this.department = x[0];
		this.number = x[1].split("-")[0];
		
		Offering off1 = new Offering(section, seatCap, enrolled, location, days, time, prof);
		offerings.add(off1);
		
		schedule.add((days + "," + time));
	}
	
	public boolean addStudent(Student student) {
		return false;
		
	}
	
	public boolean addOffering(int seatCap, int enrolled, int section, String location, String days, String time, Professor prof) {
		Offering off1 = new Offering(section, seatCap, enrolled, location, days, time, prof);
		offerings.add(off1);
		return true;
	}
	
	public boolean dropStudent(Student student) {
		return false;
		
	}
	
	public Professor getProfessor(int section) {
		return null;
		
	}
	
	public void viewCourseInformation() {
		System.out.println(this.toString());
	}
	
	public Offering getSection(int sectionNum) {
		//System.out.println(sectionNum);
		sectionNum = 0;
		return this.offerings.get(sectionNum);
	}
	
	public String getCourseID() {
		return this.courseID;
	}
	
	public String toString() {
		String x = "\n" + this.courseID + " - " + this.name + ":";
		for(int i = 0; i < this.offerings.size(); i++) {
			x += "\n\t" + this.offerings.get(i).toString();
		}
		x += "\n";
		return x;
	}
	
	public String getInfo() {
		return this.courseID + " - " + this.name + " - " + String.valueOf(this.offerings.size() + "\n");
	}	
}
