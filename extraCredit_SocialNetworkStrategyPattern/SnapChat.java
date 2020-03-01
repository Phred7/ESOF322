package extraCredit_SocialNetworkStrategyPattern;

public class SnapChat implements MediaBehavior {

	public void connect(String name) {
		System.out.printf("Connected to %s on SnapChat\n", name);
	}

}