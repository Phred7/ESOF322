package courseInformationSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentStrategy implements UserStrategy {

	public void checkProgram() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Credentials:");
		System.out.println("netID:");
		String netID = scanner.nextLine();
		System.out.println("password: ");
		String pw = scanner.nextLine();
		UserList ul = Main.getUserList();
		if(!ul.checkCredentials(netID, pw)) {
			System.out.println("\nINVALID CREDENTIALS\n");
			return;
		}
		Student st = (Student) ul.getUser(ul.getUser(netID, pw));
		System.out.println(st.getProgramStudy());
	}

	public void checkProgress() {

	}

	public void printInfo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Course Catalog:\nCourseID - Title - NumSections");
		ArrayList<Course> cc = Main.getCatalog();
		for(int i = 0; i < cc.size(); i++) {
			System.out.print(cc.get(i).getInfo());
		}
		System.out.println("CourseID - Title - NumSections\n");
		System.out.println("Please select a course from the course catalog above using its CourseID eg. CSCI305:");
		
		boolean done = false;
		
		do {
			String input = getStringIn(scanner);
			input = input.replaceAll("\\s", "");
			input = input.toUpperCase();
			if(input.equals("DONE")) {
				done = true;
			}else {
				for(int i = 0; i < cc.size(); i++) {
					if(input.equals(cc.get(i).getCourseID().replaceAll("\\s", ""))) {
						cc.get(i).viewCourseInformation();
						break;
					}else if(i == cc.size() - 1) {
						System.out.println("No Courses Found Matching the Course ID: " + input + "\n");
					}
				}
				System.out.println("Enter next course or done:");
			}
			//System.out.println("here");
		} while(!done);
		//scanner.close();
		return;
	}
	
	private static String getStringIn(Scanner scan) {
	    String input = "";
	    if (scan.hasNext()) {
	        if (scan.hasNextLine()) {
	            input = scan.nextLine();
	        } else {
	            scan.next();
	        }
	    }
	    return input;
	}
	
	public void printOptions() {
		System.out.println("Student Options:\n1.View Course Information\n2.Check Program of Study Cert.\n3.Check Degree Progress\n4.Done+LogOut");
	}
	
	public void options(Scanner scanIn2) {
		
		printOptions();
		
		int c = UI.getIntIn(4, 1);
		if(c == 1) {
			printInfo();
		} else if(c == 2) {
			checkProgram();
		} else if(c == 3) {
			checkProgress();
		}else if(c == 4) {
			return;			
		}
		
		if(c > 0 && c < 4) {
			options(scanIn2);	
		}

	}

	public void options() {
		Scanner scnr = new Scanner(System.in);
		options(scnr);
	}
}
