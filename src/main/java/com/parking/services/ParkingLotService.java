package com.parking.services;

import java.util.List;

import javax.activity.InvalidActivityException;

import com.parking.app.ParkingLot;
import com.parking.app.Vehicle;
import com.parking.enums.Commands;
import com.parking.enums.ErrorCode;

public class ParkingLotService {

	private static ParkingLot parkingLot = null;

	public ParkingLot createParkingLot(Integer space) {
		parkingLot = ParkingLot.getInstance(space);
		System.out.println("Created a parking lot with " + space +" slots");
		return parkingLot;
	}
	
	public Integer addVehicleToParking(Vehicle vehicle){
		if(parkingLot == null){
			throw new IllegalArgumentException("Invalid command");
		}
		return parkingLot.addVehicleToParking(vehicle);
	}

	public boolean removeVehicleFromParking(Integer id) {
		return parkingLot.removeVehicleFromParking(id);
	}

	public List<Vehicle> getVehicleByColor(String color) {
		return parkingLot.getVehicleByColor(color);
	}

	public List<Vehicle> getVehicleByVehicleNo(String color) {
		return parkingLot.getVehicleByVehicleNo(color);
	}

	public List<Vehicle> getAllVehicles() {
		return parkingLot.getAllVehicles();
	}
}
