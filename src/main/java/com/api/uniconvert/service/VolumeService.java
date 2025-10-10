package com.api.uniconvert.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.uniconvert.model.ConversionRequest;
import com.api.uniconvert.model.ConversionResponse;
import com.api.uniconvert.model.ConversionUnit.VolumeUnit;

@Service
public class VolumeService {
	public List<ConversionResponse> getAllVolumeConversion(){
		List<ConversionResponse> response = new ArrayList<>();
		VolumeUnit units[] = VolumeUnit.values();
		
		for(VolumeUnit from:units) {
			for(VolumeUnit to:units) {
				if(!from.equals(to)) {
					response.add(convertVolume(new ConversionRequest(from.name(),to.name(),1)));
				}
			}
		}
		
		return response;
	}
	
	public ConversionResponse convertVolume(ConversionRequest request) {
		VolumeUnit from = VolumeUnit.valueOf(request.getFrom().toUpperCase());
		VolumeUnit to = VolumeUnit.valueOf(request.getTo().toUpperCase());
		double value = request.getValue();
		double inLiters = value * toLiter(from);
		double result = inLiters / toLiter(to);
//		BigDecimal bd = new BigDecimal(result);
//		bd = bd.setScale(2, RoundingMode.HALF_UP);
		ConversionResponse response = new ConversionResponse(from.name(),to.name(),value,result);
		return response;
	}

	private double toLiter(VolumeUnit unit) {
		switch (unit) {
		case LITER:
			return 1.0;
		case MILLILITER:
			return 0.001;
		case CUBIC_METER:
			return 1000.0;
		case GALLON:
			return 3.78541;
		case CUBIC_CENTIMETER:
			return 0.001;
		case PINT:
			return 0.473176;
		default:
			throw new IllegalArgumentException("Unknown volume unit: " + unit);
		}
	}
}
