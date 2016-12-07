package com.parking.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Commands {
	CREATE_PARKING_LOT("create_parking_lot", 2), PARK("park", 3), LEAVE("leave", 2), STATUS("status", 1), REGISTRATION_NUMBERS_QUERY_BY_COLOUR(
			"registration_numbers_for_cars_with_colour", 2), SLOT_NUMBERS_QUERY_BY_COLOUR(
			"slot_numbers_for_cars_with_colour", 2), SLOT_NUMBERS_QUERY_BY_REGISTRATION_NUMBERS(
			"slot_number_for_registration_number", 2);

	Commands(String command, int arguments) {
		this.command = command;
		this.arguments = arguments;
	}

	private String command;
	private int arguments;

	public String getCommand() {
		return command;
	}

	public int getArguments() {
		return arguments;
	}

	private static Map<String, Commands> commands = new HashMap<String, Commands>();

	static {
		for (Commands c : EnumSet.allOf(Commands.class)) {
			commands.put(c.getCommand(), c);
		}
	}

	public static Commands getCommand(String commandString) {
		Commands command = null;
		if (commands.containsKey(commandString.toLowerCase().trim())) {
			return commands.get(commandString.toLowerCase().trim());
		}
		return command;
	}
}
