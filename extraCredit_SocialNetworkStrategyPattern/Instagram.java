package extraCredit_SocialNetworkStrategyPattern;

public class Instagram implements MediaBehavior{
	
	public void connect(String name) {
		System.out.printf("Connected to %s on Instagram\n", name);
	}

}