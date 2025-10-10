package com.api.uniconvert.model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ConversionResponse {
	private String from;
	private String to;
	private double value;
	private double result;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public ConversionResponse(String from, String to, double value, double result) {
		super();
		this.from = from;
		this.to = to;
		this.value = value;
		this.result = result;
	}
	
}
