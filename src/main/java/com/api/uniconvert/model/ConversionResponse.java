package com.api.uniconvert.model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ConversionResponse {
	private ConversionUnit from;
	private ConversionUnit to;
	private double value;
	private double result;
	public ConversionUnit getFrom() {
		return from;
	}
	public void setFrom(ConversionUnit from) {
		this.from = from;
	}
	public ConversionUnit getTo() {
		return to;
	}
	public void setTo(ConversionUnit to) {
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
	public ConversionResponse(ConversionUnit from, ConversionUnit to, double value, double result) {
		super();
		this.from = from;
		this.to = to;
		this.value = value;
		this.result = result;
	}
	
	
}
