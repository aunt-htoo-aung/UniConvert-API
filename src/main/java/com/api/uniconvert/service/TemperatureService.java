package com.api.uniconvert.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.uniconvert.model.ConversionRequest;
import com.api.uniconvert.model.ConversionResponse;
import com.api.uniconvert.model.ConversionUnit;
import com.api.uniconvert.model.ConversionUnit.TemperatureUnit;

@Service
public class TemperatureService {

	public List<ConversionResponse> getAllTemperatureConversion(){
		List<ConversionResponse> response = new ArrayList<>();
		TemperatureUnit[] units = ConversionUnit.TemperatureUnit.values();
		
		for(TemperatureUnit from:units) {
			for(TemperatureUnit to:units) {
				if(!from.equals(to)) {
					response.add(convert(from,to,1));
				}
			}
		}
		return response;
	}
	
	public ConversionResponse convertTemperature(ConversionRequest request) {
		TemperatureUnit from = ConversionUnit.TemperatureUnit.valueOf(request.getFrom().toUpperCase());
		TemperatureUnit to = ConversionUnit.TemperatureUnit.valueOf(request.getTo().toUpperCase());
		double value = request.getValue();
		return convert(from,to,value);
	}
	
	private ConversionResponse convert(TemperatureUnit from, TemperatureUnit to, double value) {
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
		BigDecimal bd = new BigDecimal(result);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		ConversionResponse response = new ConversionResponse(from.name(),to.name(),value,bd.doubleValue());

		return response;
	}
	
	
}
