package com.api.uniconvert.model;


public class ConversionRequest {
    private ConversionUnit from;
    private ConversionUnit to;
    private double value;
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
    
    
}
