package com.parking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.parking.enums.ErrorCode;
import com.parking.services.CommandService;


public class ParkingLotApp {

	private static CommandService commandService = new CommandService();

	public static void main(String[] args) throws IOException {
		if (args.length > 0 && args[0] != null && args[0].length() > 0) {
			String fileName = args[0];
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();
				while (line != null) {
					sb.append(line);
					sb.append(System.lineSeparator());
					ErrorCode error = commandService.execute(line);
					if (!error.equals(ErrorCode.SUCCESS)) {
						System.out.println(error.getmessage());
					}
					line = br.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				br.close();
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while (line == null || !line.equalsIgnoreCase("exit")) {
			try {
				line = br.readLine();
				ErrorCode error = commandService.execute(line);
				if (!error.equals(ErrorCode.SUCCESS)) {
					System.out.println(error.getmessage());
				}
			} catch (Exception e) {
				System.out.println("Invalid command!!!");
				e.printStackTrace();
			}

		}
	}
}
