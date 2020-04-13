package courseInformationSystem;

public class Offering {
	
	private String location;
	private int section;
	private int enrolled;
	private int cap;
	private Professor prof;
	private String time;
	private String days;
	
	public Offering(int sectionNm, String loc, String days, String time, Professor prof) {
		this.section = sectionNm;
		this.location = loc;
		this.days = days;
		this.time = time;
		this.prof = prof;
	}
	
	public Offering(int sectionNm, int seatCap, int enrolled, String loc, String days, String time, Professor prof) {
		this.section = sectionNm;
		this.cap = seatCap;
		this.enrolled = enrolled;
		this.location = loc;
		this.days = days;
		this.time = time;
		this.prof = prof;
	}
	
    public String getLocation() {
    	return this.location;
    }
    
    public int getSectionNumber() {
    	return this.section;
    }
    
    public Professor getProf() {
    	return this.prof;
    }
    
    public int getSeatCap() {
    	return this.cap;
    }
    
    public int getEnrolled() {
    	return this.enrolled;
    }
    
    public String getDays() {
    	return this.days;
    }
    
    public String getTime() {
    	return this.time;
    }
    
    public String toString() {
    	return (String.valueOf(this.section) + "\t" + prof.toString() + "\t\t" + this.location);
    }

}
