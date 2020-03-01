package extraCredit_SocialNetworkStrategyPattern;

public class Facebook implements MediaBehavior{
	
	public void connect(String name) {
		System.out.printf("Connected to %s on Facebook\n", name);
	}

}