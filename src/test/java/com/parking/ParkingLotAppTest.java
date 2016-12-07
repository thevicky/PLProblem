package com.parking;

import com.parking.enums.ErrorCode;
import com.parking.services.CommandService;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ParkingLotAppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public ParkingLotAppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(ParkingLotAppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		CommandService service = new CommandService();
		System.out.println("Creating parking with capacity 1 ");
		assertTrue(ErrorCode.SUCCESS.equals(service.execute("create_parking_lot 1")));
		System.out.println("Parking vehicle with white color" );
		assertTrue(ErrorCode.SUCCESS.equals(service.execute("park KA­01­HH­1234 White")));
		System.out.println("Parking vehicle with black color,Testing for more then capacity" );
		assertTrue(ErrorCode.PARKING_FULL.equals(service.execute("park KA­01­BB­0001 Black")));
		System.out.println("leave from location 4, testing for invalid slot" );
		assertTrue(ErrorCode.DATA_NOT_FOUND.equals(service.execute("leave 4")));
		System.out.println("leave from location 1" );
		assertTrue(ErrorCode.SUCCESS.equals(service.execute("leave 1")));
		System.out.println("Parking vehicle with Black color" );
		assertTrue(ErrorCode.SUCCESS.equals(service.execute("park KA­01­BB­0001 Black")));
		System.out.println("Query Registration No for White color vehicle, Result should be nil" );
		assertTrue(ErrorCode.DATA_NOT_FOUND.equals(service.execute("registration_numbers_for_cars_with_colour White")));
		System.out.println("Query Registration No for Black color vehicle" );
		assertTrue(ErrorCode.SUCCESS.equals(service.execute("registration_numbers_for_cars_with_colour Black")));
		System.out.println("Query Slot for Black color vehicle" );
		assertTrue(ErrorCode.SUCCESS.equals(service.execute("slot_numbers_for_cars_with_colour Black")));
		System.out.println("Query Slot for White color vehicle, Result should be nil" );
		assertTrue(ErrorCode.DATA_NOT_FOUND.equals(service.execute("registration_numbers_for_cars_with_colour White")));
		System.out.println("Query Slot for vehicle no KA­01­BB­0001" );
		assertTrue(ErrorCode.SUCCESS.equals(service.execute("slot_number_for_registration_number KA­01­BB­0001")));
		System.out.println("Query Slot for vehicle no KA­01­BB­0002, Result should be nil" );
		assertTrue(ErrorCode.DATA_NOT_FOUND.equals(service.execute("slot_number_for_registration_number KA­01­BB­0002")));
	}
}
