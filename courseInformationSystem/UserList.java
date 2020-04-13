package courseInformationSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class UserList {
	private static ArrayList<User> userList = new ArrayList<User>();
	
	public boolean addUser(User user) {
		userList.add(user);
		return true;
	}
	
	public boolean checkCredentials(String netID, String password) {
		return true;
	}
	
	public int getUser(String netID, String password) {
		return 0;
	}
	
	public User getUser(int index) {
		return userList.get(index);
	}
}
