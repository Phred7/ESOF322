package extraCredit_SocialNetworkStrategyPattern;

import java.util.Scanner;

public class Friend {
	
	private String[] networks = {"facebook", "twitter", "snapchat", "instagram"};
	private MediaBehavior socialNetwork;
	private String name;
	private String network;
	
	public Friend() {
		this.socialNetwork = new SnapChat();
	}
	
	public void display() {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Enter friends name and app to connect with: ");
		String x = scanner.nextLine();
		String[] data = x.split(" ");
		if(data.length != 2) {
			throw new IllegalArgumentException("Invalid number of args in input: <name> <network>");
		}
		
		this.name = data[0];
		this.network = data[1].toLowerCase();
		
		if(this.network.equals(networks[0])) { //1 logically eq to true
			setMediaNetwork(new Facebook());
		}else if(this.network.equals(networks[1])) {
			setMediaNetwork(new Twitter());
		}else if(this.network.equals(networks[2])) {
			setMediaNetwork(new SnapChat());
		}else if(this.network.equals(networks[3])) {
			setMediaNetwork(new Instagram());
		}else {
			throw new IllegalArgumentException("Invalid Social Network: <" + this.network.toUpperCase() + ">");
		}
		
		connect();
	}
	
	public void connect() {
		if(this.name == null) {
			display();
		}else {
			socialNetwork.connect(this.name);
		}
	}
	
	public void setMediaNetwork(MediaBehavior network) {
		this.socialNetwork = network;
	}
	
}
