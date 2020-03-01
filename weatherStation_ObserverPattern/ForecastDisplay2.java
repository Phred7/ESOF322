package weatherStation_ObserverPattern;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay2 implements Observer, DisplayElements {
	private float currentPressure = 29.92f;  
	private float lastPressure;
	private WeatherData2 weatherData;

	public ForecastDisplay2(WeatherData2 weatherData) {
		this.weatherData = weatherData;
		weatherData.addObserver(this);
	}

	public void update(float temp, float humidity, float pressure) {
        lastPressure = currentPressure;
		currentPressure = pressure;

		display();
	}

	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("More of the same");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
