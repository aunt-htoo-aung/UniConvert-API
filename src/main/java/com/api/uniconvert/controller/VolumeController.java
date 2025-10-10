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
import com.api.uniconvert.service.VolumeService;

@RestController
@RequestMapping("api/v1/volume")
public class VolumeController {
	@Autowired
	VolumeService volService;
	
	@PostMapping("/convert")
	public ConversionResponse convertVolume(@RequestBody ConversionRequest request) {
		return volService.convertVolume(request);
	}
	
	@GetMapping("/all")
	public List<ConversionResponse> getAllVolumeConversion(){
		return volService.getAllVolumeConversion();
	}
}
