package com.api.uniconvert.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.uniconvert.model.ConversionRequest;
import com.api.uniconvert.model.ConversionResponse;
import com.api.uniconvert.service.LengthService;

@RestController
@RequestMapping("api/v1/length")
public class LengthController {
	@Autowired
	LengthService lenService;

	@PostMapping("/convert")
	public ConversionResponse convertTemperature(@RequestBody ConversionRequest request) {
		return lenService.convertLength(request);
	}
	
	@GetMapping("/all")
	public List<ConversionResponse> getAllTemperatureConversion(){
		return lenService.getAllLengthConversion();
	}
}
