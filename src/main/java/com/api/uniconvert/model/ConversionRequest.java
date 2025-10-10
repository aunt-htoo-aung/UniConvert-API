package com.api.uniconvert.model;


public class ConversionRequest {
    private String from;
    private String to;
    private double value;
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
	public ConversionRequest(String from, String to, double value) {
		super();
		this.from = from;
		this.to = to;
		this.value = value;
	}

}
