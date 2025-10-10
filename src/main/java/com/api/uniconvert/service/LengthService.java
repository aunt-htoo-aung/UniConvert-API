package com.api.uniconvert.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.uniconvert.model.ConversionRequest;
import com.api.uniconvert.model.ConversionResponse;
import com.api.uniconvert.model.ConversionUnit.LengthUnit;

@Service
public class LengthService {
	public List<ConversionResponse> getAllLengthConversion() {
		List<ConversionResponse> response = new ArrayList<>();
		LengthUnit units[] = LengthUnit.values();

		for (LengthUnit from : units) {
			for (LengthUnit to : units) {
				if (!from.equals(to)) {
					response.add(convertLength(new ConversionRequest(from.name(), to.name(), 1)));
				}
			}
		}

		return response;
	}

	public ConversionResponse convertLength(ConversionRequest request) {
		LengthUnit from = LengthUnit.valueOf(request.getFrom().toUpperCase());
		LengthUnit to = LengthUnit.valueOf(request.getTo().toUpperCase());
		double value = request.getValue();
		double inMeters = value * toMeter(from);
		double result = inMeters / toMeter(to);
//		BigDecimal bd = new BigDecimal(result);
//		bd = bd.setScale(2, RoundingMode.HALF_UP);
		ConversionResponse response = new ConversionResponse(from.name(), to.name(), value, result);
		return response;
	}

	private double toMeter(LengthUnit unit) {
		switch (unit) {
		case METER:
			return 1.0;
		case KILOMETER:
			return 1000.0;
		case CENTIMETER:
			return 0.01;
		case MILLIMETER:
			return 0.001;
		case MILE:
			return 1609.34;
		case YARD:
			return 0.9144;
		case FOOT:
			return 0.3048;
		case INCH:
			return 0.0254;
		default:
			throw new IllegalArgumentException("Unknown volume unit: " + unit);
		}
	}
}
