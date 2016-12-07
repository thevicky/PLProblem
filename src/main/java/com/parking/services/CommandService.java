package com.parking.services;

import java.util.List;

import com.parking.app.Vehicle;
import com.parking.enums.Commands;
import com.parking.enums.ErrorCode;


public class CommandService {
	
	private static ParkingLotService parkingLotService = new ParkingLotService();
	
	public ErrorCode execute(String commandString){
		List<Vehicle> vehicles = null;
		if(commandString == null || commandString.length() <= 0){
			return ErrorCode.INVALID_INPUT;
		}
		String[] commandArray = commandString.split( " ");
		Commands command = Commands.getCommand(commandArray[0]);
		if(command == null || command.getArguments() != commandArray.length){
			return ErrorCode.INVALID_INPUT;
		}
		switch (command) {
		case CREATE_PARKING_LOT:
			Integer space = Integer.parseInt(commandArray[1]);
			parkingLotService.createParkingLot(space);
			break;

		case PARK:
			Vehicle vehicle = new Vehicle(commandArray[1],commandArray[2]);
			try {
				Integer p = parkingLotService.addVehicleToParking(vehicle);
				if(p != -1){
					System.out.println("Allocated slot number: " + p );
				}else{
					return ErrorCode.PARKING_FULL;
				}
			} catch (Exception e) {
				return ErrorCode.INVALID_INPUT;
			}
			break;
		case LEAVE:
			Integer id = Integer.parseInt(commandArray[1]);
			if(parkingLotService.removeVehicleFromParking(id)){
				System.out.println("Slot number " + id + " is free ");
			}else{
				return ErrorCode.DATA_NOT_FOUND;
			}
			break;
			
		case REGISTRATION_NUMBERS_QUERY_BY_COLOUR:
			vehicles = parkingLotService.getVehicleByColor(commandArray[1]);
			if(vehicles == null || vehicles.size() == 0){
				return ErrorCode.DATA_NOT_FOUND;
			}
			showRegistrationNumbers(vehicles);
			break;
			
		case SLOT_NUMBERS_QUERY_BY_COLOUR:
			vehicles = parkingLotService.getVehicleByColor(commandArray[1]);
			if(vehicles == null || vehicles.size() == 0){
				return ErrorCode.DATA_NOT_FOUND;
			}
			showSlotNumbers(vehicles);
			break;

		case SLOT_NUMBERS_QUERY_BY_REGISTRATION_NUMBERS:
			vehicles = parkingLotService.getVehicleByVehicleNo(commandArray[1]);
			if(vehicles == null || vehicles.size() == 0){
				return ErrorCode.DATA_NOT_FOUND;
			}
			showSlotNumbers(vehicles);
			break;
			
		case STATUS:
			vehicles = parkingLotService.getAllVehicles();
			if(vehicles == null || vehicles.size() == 0){
				return ErrorCode.DATA_NOT_FOUND;
			}
			showResult(vehicles);
			break;
		default:
			break;
		}
		return ErrorCode.SUCCESS;
	}
	
	private void showResult(List<Vehicle> vehicles){
		System.out.println("---------------------------------------------------------------------------------------");
		for (Vehicle vehicle : vehicles) {			
			System.out.println(vehicle);		
		}
		System.out.println("---------------------------------------------------------------------------------------");
	}
	
	private void showSlotNumbers(List<Vehicle> vehicles){
		boolean flag = false;
		for (Vehicle vehicle : vehicles) {
			if(flag){
				System.out.print(", ");
			}
			System.out.print(vehicle.getParkingSpaceId());
			flag = true;
		}
		System.out.println();
	}
	
	private void showRegistrationNumbers(List<Vehicle> vehicles){
		boolean flag = false;
		for (Vehicle vehicle : vehicles) {
			if(flag){
				System.out.print(", ");
			}
			System.out.print(vehicle.getVehicleNo());
			flag = true;
		}
		System.out.println();
	}
}
