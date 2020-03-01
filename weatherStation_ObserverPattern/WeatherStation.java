package weatherStation_ObserverPattern;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		WeatherData2 weatherData2 = new WeatherData2();
		
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		
		weatherData.setMeasurements(80, 65, 30.4f);
		System.out.println();
		weatherData.setMeasurements(82, 7, 29.2f);
		System.out.println();
		weatherData.setMeasurements(78,  90,  29.2f);
		System.out.println();
		
		
		
		CurrentConditionsDisplay2 currentDisplay2 = new CurrentConditionsDisplay2(weatherData2);
		//StatisticsDisplay2 statisticsDisplay2 = new StatisticsDisplay2(weatherData2);
		//ForecastDisplay2 forecastDisplay2 = new ForecastDisplay2(weatherData2);
		
		weatherData2.SetMeasurements(80, 65, 30.4f);
		System.out.println();
		weatherData2.SetMeasurements(82, 7, 29.2f);
		System.out.println();
		weatherData2.SetMeasurements(78,  90,  29.2f);
		System.out.println();
	}
}
