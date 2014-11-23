package com;

public class ClinicDetails {
	
	private String CenterName;
	private String location;
	private String dayOp;
	private String timeOp;
	private String pin;
	private String centreId;
	public String getCenterName() {
		return CenterName;
	}
	public String getLocation() {
		return location;
	}
	public String getDayOp() {
		return dayOp;
	}
	public String getTimeOp() {
		return timeOp;
	}
	public String getPin() {
		return pin;
	}
	public String getCentreId() {
		return centreId;
	}
	public void setCenterName(String centerName) {
		CenterName = centerName;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setDayOp(String dayOp) {
		this.dayOp = dayOp;
	}
	public void setTimeOp(String timeOp) {
		this.timeOp = timeOp;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public void setCentreId(String centreId) {
		this.centreId = centreId;
	}

}
