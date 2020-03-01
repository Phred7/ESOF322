package extraCredit_SocialNetworkStrategyPattern;

public class Twitter implements MediaBehavior {

	public void connect(String name) {
		System.out.printf("Connected to %s on Twitter\n", name);
	}

}