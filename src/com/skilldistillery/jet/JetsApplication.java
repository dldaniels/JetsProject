package com.skilldistillery.jet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JetsApplication {
	//private airField and Scanner
	private AirField airField = new AirField();
	private Scanner kb = new Scanner(System.in);
	
	//main
	public static void main(String[] args) {
		//instance of JetsApplication
		JetsApplication app = new JetsApplication();
		//call to program methods
		app.launch();
		app.displayUserMenu();
	}
	//launch method
	private void launch() {
		populateAirField(airField, kb);
		
	}
	//displayUserMenu method
	private void displayUserMenu() {
		System.out.println("                                ");
		System.out.println("  Please enter a number to select                          ");
		System.out.println("           your choice                     ");
		System.out.println("                                ");
		System.out.println("                                ");
		System.out.println("       1. List Fleet                          ");
		System.out.println("       2. Fly all jets                          ");
		System.out.println("       3. View Fastest Jet                          ");
		System.out.println("       4. View Jet with longest range                          ");
		System.out.println("       5. Load all cargo jets                          ");
		System.out.println("       6. Dogfight!                         ");
		System.out.println("       7. Add a jet to fleet                          ");
		System.out.println("       8. Remove a jet from fleet                          ");
		System.out.println("       9. Quit                          ");
		System.out.println("                                ");
		System.out.println("                                ");
		System.out.println("                                ");
		System.out.println("    ");
		
	}
	private void populateAirField(AirField hangar, Scanner kb) {
		try (BufferedReader bufIn = new BufferedReader (new FileReader("jets.txt"))) {
			String line;
			
			while ((line = bufIn.readLine()) != null) {
				String[] fields = line.split(",");
				if(fields[0].equals("CargoPlane")) {
				String model = fields[1];	
				double speed = Double.parseDouble(fields[2].trim());
				int range = Integer.parseInt(fields[3].trim());
				long price = Long.parseLong(fields[4].trim());
				CargoPlane cp = new CargoPlane(model,speed,range,price);
				hangar.addJet(cp);
				}
				if(fields[0].equals("FighterJet")) {
					String model = fields[1];	
					double speed = Double.parseDouble(fields[2].trim());
					int range = Integer.parseInt(fields[3].trim());
					long price = Long.parseLong(fields[4].trim());
					FighterJet fj = new FighterJet(model,speed,range,price);
					hangar.addJet(fj);
				}
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private Jet addUserJet (Jet j , Scanner kb) {
		System.out.println("Enter model");
		j.setModel(kb.next());
		System.out.println("Enter speed in MPH");
		j.setSpeed(kb.nextDouble());
		System.out.println("Enter range in Miles");
		j.setRange(kb.nextInt());
		System.out.println("Enter purchase price");
		j.setPrice(kb.nextLong());
		return j;
	}

}
