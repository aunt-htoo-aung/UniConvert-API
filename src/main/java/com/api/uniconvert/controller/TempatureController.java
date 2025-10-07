package com.api.uniconvert.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.uniconvert.model.ConversionRequest;
import com.api.uniconvert.model.ConversionResponse;

@RestController
@RequestMapping("api/v1/temperature")
public class TempatureController {

	@PostMapping("/convert")
	public ConversionResponse convertTemperature(@RequestBody ConversionRequest request) {
		return null;
	}
}
