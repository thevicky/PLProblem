package com.parking.app;

public class Vehicle {
	private String vehicleNo;
	private String vehicleColor;
	private Integer parkingSpaceId;
	
	public Vehicle(String vehicleNo, String vehicleColor) {
		this.vehicleColor = vehicleColor;
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public Integer getParkingSpaceId() {
		return parkingSpaceId;
	}

	public void setParkingSpaceId(Integer parkingSpaceId) {
		this.parkingSpaceId = parkingSpaceId;
	}
	
	public String toString(){
		return getParkingSpaceId()  + "," + getVehicleNo() + "," + getVehicleColor();
	}
	
}
