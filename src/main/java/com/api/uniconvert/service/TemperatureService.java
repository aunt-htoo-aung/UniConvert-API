package com.api.uniconvert.service;

import org.springframework.stereotype.Service;

import com.api.uniconvert.model.ConversionRequest;
import com.api.uniconvert.model.ConversionResponse;
import com.api.uniconvert.model.ConversionUnit;

@Service
public class TemperatureService {

	public ConversionResponse convertTemperature(ConversionRequest request) {
		ConversionUnit from = request.getFrom();
		ConversionUnit to = request.getTo();
		double value = request.getValue();
		
		double celsius = 0.0;
		double result = 0.0;
		
		if (from.equals(to)) {
			result = value;
		} else {
			switch (from) {
			case FAHRENHEIT:
				celsius = (value - 32) * 5 / 9;
				break;
			case KELVIN:
				celsius = value - 273.15;
	            break;
	        default:
	            celsius = value;
			}
			
			switch (to) {
			case FAHRENHEIT:
				result = (celsius * 9 / 5) + 32;
				break;
			case KELVIN:
				result = celsius + 273.15;
	            break;
	        default:
	            result = celsius;
			}
		}
		
		ConversionResponse response = new ConversionResponse(from,to,value,result);

		return response;
	}
}
