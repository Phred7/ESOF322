package courseInformationSystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	private static User user;
	private static ArrayList<Course> courseCatalog;
	private static ArrayList<Professor> profsOnPayroll;
	private static UserList users;
	private static String fileAddress = "2020-Spring_ScheduleData_20191226.csv";

	public static void main(String[] args) throws IOException {
		int count = 0;
		boolean valid = false;

		courseCatalog = new ArrayList<Course>();
		profsOnPayroll = new ArrayList<Professor>();
		users = new UserList();

		Scanner scanner = new Scanner(new FileInputStream(fileAddress));
		Scanner scanIN = new Scanner(System.in);
		Scanner scanIn2 = new Scanner(System.in);
		scanner.useDelimiter("\n");
		//scanIN.useDelimiter("");
		
		/*
		 * Create a new user based on current system user
		 */
		
		String choice;
		String name;
		String netID;
		String ssn;
		String address;
		String phone;
		
		do {
			System.out.print("Are you a Student(S), Professor(P) or Advisor(A):");
			choice = scanIN.nextLine();
			choice = choice.toUpperCase();
			if(choice.equals("S") || choice.equals("P") || choice.equals("A")){
				valid = true;
			}else {
				System.out.print("Invalid Input. ");
			}
		} while(!valid);
	
		if(choice.equals("S")) {
			user = new Student();
		}
		
		System.out.print("Enter your name:");
		name = scanIN.nextLine();
		System.out.print("Enter your NetID:");
		netID = scanIN.nextLine();
		System.out.print("Enter your SSN:");
		ssn = scanIN.nextLine();
		System.out.print("Enter your Address:");
		address = scanIN.nextLine();
		System.out.print("Enter your Phone Number:");
		phone = scanIN.nextLine();
		
		
		
		if(!choice.equals("S")) {
			Professor userP;
			int ck = checkProfExists(name.split(" ")[0], name.split(" ")[1], profsOnPayroll);
			
			if (ck == -1) {
				userP = new Professor(name.split(" ")[0], name.split(" ")[1]);
				profsOnPayroll.add(userP);
			} else {
				userP = profsOnPayroll.get(ck);
				userP.setPersonalInfo(name, netID, ssn, address, phone);
			}
			
			if(choice.equals("A")) {
				userP.addAdvisee(new Student("x42----"));	
			}
			
			user = new Professor(userP);
			
		}else {
			user.setPersonalInfo(name, netID, ssn, address, phone);
		}
		users.addUser(user);
		
		/*
		 * Read-in and Load Data from file
		 */
		
		System.out.println("\nContents Loading");
		System.out.print("\n[");

		while (scanner.hasNext()) {
			String x = scanner.next();

			if (count % 305 == 0) {
				System.out.print("*");
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
				}
			}

			if (count == 0) {
				count = 1;
				continue;
			} else {

				String[] y = x.split("\"");

				String termCode;
				String classCode;
				String title;
				String crn;
				String instructorLast;
				String instructorFirst;
				String seatCap;
				String enrolled;
				String days;
				String times;
				String location;
				String type;

				if (y.length >= 5) {
					String[] data = y[0].split(",");
					String[] data2 = y[3].split(",");
					String[] data3 = y[4].split(",");

					termCode = data[0];
					classCode = data[1];
					title = y[1];
					crn = y[2].replaceAll(",", "");
					instructorLast = data2[0];
					instructorFirst = data2[1];

					seatCap = data3[1];
					enrolled = data3[2];
					days = data3[3];
					times = data3[4];
					location = data3[5];
					type = data3[6];

				} else {
					String[] data = y[0].split(",");
					String[] data2 = y[1].split(",");
					String[] data3 = y[2].split(",");

					termCode = data[0];
					classCode = data[1];
					title = data[2];
					crn = data[3];

					instructorLast = data2[0];
					instructorFirst = data2[1];

					seatCap = data3[1];
					enrolled = data3[2];
					days = data3[3];
					times = data3[4];
					location = data3[5];
					type = data3[6];

				}

				String[] z = classCode.split("-")[1].split("");
				int section;

				if (z.length == 3) {
					section = Integer.parseInt(z[1]) * 10 + Integer.parseInt(z[2]);
				} else if (z.length == 2) {
					section = Integer.parseInt(z[0]) * 10 + Integer.parseInt(z[1]);
				} else {
					section = -1;
				}

				int check = checkProfExists(instructorFirst, instructorLast, profsOnPayroll);
				int checkCourse = checkCourseExits(classCode.split("-")[0], courseCatalog);
				Professor prof;
				Course course;

				if (check == -1) {
					prof = new Professor(instructorFirst, instructorLast);
					profsOnPayroll.add(prof);
				} else {
					prof = profsOnPayroll.get(check);
				}

				if (checkCourse == -1) {
					course = new Course(Integer.parseInt(crn), Integer.parseInt(seatCap), Integer.parseInt(enrolled), section, title, classCode, location, days, times, prof);
					courseCatalog.add(course);
				} else {
					course = courseCatalog.get(checkCourse);
					course.addOffering(Integer.parseInt(seatCap), Integer.parseInt(enrolled), section, location, days, times, prof);
				}

				prof.addOffering(course.getSection(section));

			}
			count++;
		}

		//scanner.close();

		System.out.println("]\n");

		System.out.print("Contents Loaded\n");

		//System.out.println(courseCatalog.get(573).toString());
		
		System.out.println();
		
		/*
		 * User Options
		 */
		
		user.options();
		
		System.out.println("Logging Out...");
				
		//scanIN.close();
		//scanIn2.close();		
	}

	private static int checkProfExists(String first, String last, ArrayList<Professor> profs) {
		String tempFullName = first.replaceAll("\\s", "") + " " + last.replaceAll("\\s", "");
		
		if(profs.size() == 0) {
			return -1;
		}
		
		for (int i = 0; i < profs.size(); i++) {
			if (tempFullName.equals(profs.get(i).getName())) {
				return i;
			}
		}
		return -1;
	}

	private static int checkCourseExits(String courseID, ArrayList<Course> courses) {
		
		if(courses.size() == 0) {
			return -1;
		}
		
		for (int i = 0; i < courses.size(); i++) {
			if (courseID.equals(courses.get(i).getCourseID())) {
				return i;
			}
		}
		return -1;
	}
	
	public static ArrayList<Course> getCatalog(){
		return courseCatalog;
	}
	
	public static int getIntIn(Scanner scanner, int upperBound, int lowerBound) {
	    int input = 0;
	    boolean error = true;
	    if (scanner.hasNext()) {
	        if (scanner.hasNextInt()) {
	            input = scanner.nextInt();
	            
	            error = input < lowerBound || input > upperBound;
	        } else {
	            scanner.nextLine();
	            error = true;
	        }
	    }
	    while (error) {
	        UI.print("Invalid input. Please reenter: ");
	        if (scanner.hasNextInt()) {
	            input = scanner.nextInt();
	            error = input < lowerBound || input > upperBound;
	        } else {
	            if (scanner.hasNext())
	                scanner.nextLine();
	            error = true;
	        }
	    }
	    return input;
	}
	
	public static UserList getUserList() {
		return users;
	}
	
	

}
