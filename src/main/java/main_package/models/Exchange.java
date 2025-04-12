package main_package.models;

import main_package.InfoAPI;

import java.io.IOException;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Exchange {
	private String name;
	private double value;
	private String otherExchangeName;
	private double otherExchangeValue;
	
	public Exchange(String name, String otherExchangeName, double value) {
		this.value = value;
		this.otherExchangeName = otherExchangeName;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getOtherExchangeName() {
		return otherExchangeName;
	}
	
	public void setOtherExchangeName(String otherExchangeName) {
		this.otherExchangeName = otherExchangeName;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public double getOtherExchangeValue() {
		return otherExchangeValue;
	}
	
	public void setOtherExchangeValue(double otherExchangeValue) {
		this.otherExchangeValue = otherExchangeValue;
	}
	
	
	public double compare() {
		
		OkHttpClient client = new OkHttpClient();
		
		String key = InfoAPI.key; // change here to your API key
		
		String URL = "https://v6.exchangerate-api.com/v6/" + key + "/latest/" + name;
		Request request = new Request.Builder().url(URL).build();
		double result = 0;
		
		try(Response response = client.newCall(request).execute();) {
			
			String resp = response.body().string();
			
			
			
			JSONObject json = new JSONObject(resp);
			JSONObject rates = json.getJSONObject("conversion_rates");
			
			double otherExchange = rates.getDouble(otherExchangeName);
			result = value * otherExchange;
			
			
			
			
		} catch(IOException error) {
			System.out.println(error);
		}
		
		return result;
		
		
	
	}
	
	@Override
	public String toString() {
		return "O valor " + value + " de " + name + " para " + otherExchangeName + " eh de " + String.format("%.2f", compare());
	}
	
	
	
}
