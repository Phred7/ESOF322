package starbuzz_DecoratorPattern;

public class DarkRoast extends Beverage{
	
	public DarkRoast() {
		description = "Dark Roast Coffee";
	}
	
	public double cost() {
		return 0.99;
	}
}
