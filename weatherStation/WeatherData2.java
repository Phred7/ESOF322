package weatherStation;

import java.util.Observable;

public class WeatherData2 extends Observable {
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData2() { }
	
	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}
	
	public void SetMeasurements(float temp, float humiditiy, float pressure) {
		this.temperature = temp;
		this.humidity = humiditiy;
		this.pressure = pressure;
		measurementsChanged();
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}
	
	
}
