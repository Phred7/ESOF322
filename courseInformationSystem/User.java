package courseInformationSystem;

public abstract class User {
	
	PersonalInformation info;
	UserStrategy strategy;
	
	public User() {
		
	}
	
	public String viewCourseInformation(String str) {
		return "";
	}
	
	public void printInformation() {
		strategy.printInfo();
	}
	
	public void checkProgramOfStudy() {
		strategy.checkProgram();
	}
	
	public void checkDegreeProgress(){
		strategy.checkProgress();
	}
	
	public void setStrategy(UserStrategy strat) {
		
	}
	
	public void options() {
		strategy.options();
	}
	
	public abstract void setPersonalInfo(String name, String netID, String ssn, String address, String phone);
}
