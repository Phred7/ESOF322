package courseInformationSystem;

import java.util.Scanner;

public class UI {
	static Scanner scanner = new Scanner(System.in);
	
	public static int getIntIn(int upperBound, int lowerBound) {
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
	
	public static String getStringIn(String[] options) {
		return "";
	}
	
	public static String getStringIn() {
		return "";
	}
	
	public static void println(String out) {
		System.out.println(out);
	}
	
	public static void print(String out) {
		System.out.print(out);
	}
}
