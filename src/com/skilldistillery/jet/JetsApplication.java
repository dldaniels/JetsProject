package com.skilldistillery.jet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//user story 1, create jets application and main
public class JetsApplication {
	// private airField and Scanner
	private AirField airField = new AirField();
	private Scanner kb = new Scanner(System.in);

	// main
	public static void main(String[] args) {
		// instance of JetsApplication
		JetsApplication app = new JetsApplication();
		// call to program methods
		app.populateAirField();
		app.launch();

	}

	// launch method
	private void launch() {
		// populate airfield with pre written planes from .txt file

		// launch is looped to allow for multiple continuous choices without having to
		// restart everytime.
		boolean keepGoing = true;
		while (keepGoing) {
			displayUserMenu();
			System.out.println();
			int choice = kb.nextInt();

			switch (choice) {
			case 1:
				listFleet();
				System.out.println();
				break;
			case 2:
				flyAllJets();
				System.out.println();
				break;
			case 3:
				fastestJet();
				System.out.println();
				break;
			case 4:
				farthestRange();
				System.out.println();
				break;
			case 5:
				loadCargo();
				System.out.println();
				break;
			case 6:
				dogFight();
				System.out.println();
				break;
			case 7:
				ohDamn();
				System.out.println();
				break;
			case 8:
				prepareShipForLudicrousSpeed();
				break;
			case 9:
				addJet();
				System.out.println();
				break;
			case 10:
				removeJet();
				System.out.println();
				break;
			case 11:
				System.out.println("Later dude!!! See ya next time! ");
				System.out.println();
				keepGoing = !true;
				break;
			default:
				System.out.println("Try entering a valid number there hotshot");
				continue;
			}

		}

	}

	// User story 4, menu options
	// displayUserMenu method
	private void displayUserMenu() {
		System.out.println(" •••••••••••••••••••••••••••••••••••••••••••••••••••••• ");
		System.out.println(" •••••••••••••••••••••••••••••••••••••••••••••••••••••• ");
		System.out.println(" •••       Please enter a number to select          ••• ");
		System.out.println(" •••                 your choice                    ••• ");
		System.out.println(" •••                                                ••• ");
		System.out.println(" •••                                                ••• ");
		System.out.println(" •••             1. List Fleet                      ••• ");
		System.out.println(" •••             2. Fly all jets                    ••• ");
		System.out.println(" •••             3. View Fastest Jet                ••• ");
		System.out.println(" •••             4. View Jet with longest range     ••• ");
		System.out.println(" •••             5. Load all cargo jets             ••• ");
		System.out.println(" •••             6. Dogfight!                       ••• ");
		System.out.println(" •••             7. Uh-Oh!                          ••• ");
		System.out.println(" •••             8. Ludicrous Speed                 ••• ");
		System.out.println(" •••             9. Add a jet to fleet              ••• ");
		System.out.println(" •••             10. Remove a jet from fleet        ••• ");
		System.out.println(" •••             11. Quit                           ••• ");
		System.out.println(" •••                                                ••• ");
		System.out.println(" •••••••••••••••••••••••••••••••••••••••••••••••••••••• ");
		System.out.println(" •••••••••••••••••••••••••••••••••••••••••••••••••••••• ");
	}
	// User story 3, On program startup, populate the AirField with at least 5 Jets
	// of different type
	// These jets must be read from a text file, where each line in the file
	// contains data for a single Jet object

	// Includes try/catch for exception handling, and parsing of file info into
	// array list

	private void populateAirField() {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;

			while ((line = bufIn.readLine()) != null) {
				String[] fields = line.split(",");
				if (fields[0].equals("CargoPlane")) {
					String model = fields[1];
					double speed = Double.parseDouble(fields[2].trim());
					int range = Integer.parseInt(fields[3].trim());
					long price = Long.parseLong(fields[4].trim());
					CargoPlane cp = new CargoPlane(model, speed, range, price);
					airField.addJet(cp);
				}
				if (fields[0].equals("FighterJet")) {
					String model = fields[1];
					double speed = Double.parseDouble(fields[2].trim());
					int range = Integer.parseInt(fields[3].trim());
					long price = Long.parseLong(fields[4].trim());
					FighterJet fj = new FighterJet(model, speed, range, price);
					airField.addJet(fj);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// User story 5, listFleet prints out the model, speed, range, and price of each
	// jet in list
	private void listFleet() {
		int counter = 1;
		for (Jet jet : airField.getHangarList()) {
			System.out.print(counter + ": ");
			System.out.println(jet.toString());
			System.out.println();
			counter++;
		}
	}

	// User story 6, flyAllJets calls the fly() method on the entire fleet of jets.
	// fly() prints out the jet details
	// and the amount of time the jet can fly until it runs out of fuel (based on
	// speed and range).

	private void flyAllJets() {
		for (Jet jet : airField.getHangarList()) {
			System.out.println(jet.toString());
			jet.fly();
		}
	}

	// User story 7, The view fastest jet and longest range options both print out
	// all of the information about a jet.

	// method to determine fastest Jet.
	private void fastestJet() {

		Jet speedy = new FighterJet();
		speedy.setSpeed(1);
		for (Jet jet : airField.getHangarList()) {
			if (jet.getSpeed() > speedy.getSpeed()) {
				speedy = jet;
			}
		}
		System.out.println(speedy.toString());
		System.out.println("This jet is the fastest of the group and can travel at a top speed of " + speedy.getSpeed()
				+ " MPH " + " that is Mach " + speedy.getSpeedInMach());
	}

	// method to determine jet with farthest range capability
	private void farthestRange() {

		Jet longRange = new FighterJet();
		longRange.setRange(1);
		for (Jet jet : airField.getHangarList()) {
			if (jet.getRange() > longRange.getRange()) {
				longRange = jet;
			}
		}
		System.out.println(longRange.toString());
		System.out.println("This jet can fly the furthest distance without having to stop and refuel. "
				+ longRange.getModel() + " can travel a distance of " + longRange.getRange() + " Miles. ");
	}

	// User story 8, The user is presented with an option specific to the interfaces
	// you created.
	// For example, Load all Cargo Jets, above, finds all implementors of the
	// CargoCarrier interface and calls loadCargo() on each.
	// (Note that the menu text is italicized because your options may be different,
	// depending on your interfaces.)

	// method to call interface for cargo jets to load cargo
	private void loadCargo() {
		for (Jet jet : airField.getHangarList()) {
			if (jet instanceof CargoCarrier) {
				((CargoCarrier) jet).loadCargo();
			}

		}
	}

	// method to call interface for fighter jets to dogfight
	private void dogFight() {
		for (Jet jet : airField.getHangarList()) {
			if (jet instanceof CombatReady) {
				((CombatReady) jet).fight();
			}

		}
	}
	
	//method to call interface for Starscream
	private void ohDamn() {
		for (Jet jet : airField.getHangarList()) {
			if (jet.getModel().equals("F-15E Strike Eagle")) {
				((Transforms) jet).ohDamn();
			}
		}
	}
	
	//method to call interface for Ludicrous Speed
	private void prepareShipForLudicrousSpeed() {
		System.out.println("Are you sure that you wish to engage Ludicrous speed?");
		System.out.println("Enter Y or N");
		String choice = kb.next();
		switch (choice) {
		 case "Y":
		 case "y":
			 System.out.println("Okay...buckle up! Ludicrous speed! GO!");
			 break;
		 case "N":
		 case "n":
			 System.out.println("What's the matter Colonel Sanderz? Chicken??");
			 System.out.println("Buckle up anyway, becasue here we go!! Ludicrous speed! GO!");
			break;
		}
		for (Jet jet : airField.getHangarList() ) {
			if (jet.getModel().equals("Spaceball One")) {
				((LudicrousSpeed) jet).prepareShipForLudicrousSpeed();
			}
		}
	}

	// User story 9, A user can add custom jets to the fleet. User will input model,
	// speed, range, and price.
	// the newly created jet is then added to the AirField.
	private void addJet() {
		JetImpl userJet = new JetImpl();
		System.out.println("enter model");
		userJet.setModel(kb.next());
		System.out.println("enter speed");
		userJet.setSpeed(kb.nextDouble());
		System.out.println("enter range");
		userJet.setRange(kb.nextInt());
		System.out.println("enter price");
		userJet.setPrice(kb.nextLong());
		airField.addJet(userJet);
		System.out.println(userJet.toString());
	}

	// User story 10, A user can remove a jet from the fleet.
	// The user is presented with a sub-menu to select a jet to delete by number.
	private void removeJet() {
		listFleet();
		System.out.println("Please select the corresponding number for the jet you wish to remove from the fleet");
		System.out.println();
		int choice = kb.nextInt();
		airField.removeJet(choice);

	}

}
