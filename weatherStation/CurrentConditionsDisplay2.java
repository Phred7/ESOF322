package weatherStation;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay2 implements Observer, DisplayElements{
	Observable obersvable;
	private float temperature;
	private float humidity;
	
	public CurrentConditionsDisplay2(Observable observable) {
		this.obersvable = observable;
		observable.addObserver(this);
	}
	
	public void update(Observable obs, Object arg) {
		if(obs instanceof WeatherData2) {
			WeatherData2 weatherData = (WeatherData2)obs;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}
	
	public void display() {
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
	}
}
