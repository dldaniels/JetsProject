package com.skilldistillery.jet;

public class CargoPlane extends Jet implements CargoCarrier, LudicrousSpeed {

	// subclass constructors

	public CargoPlane() {
		super();

	}

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);

	}

	// implements interface

	public void loadCargo() {
		System.out.println("I am " + getModel() + " I am loading cargo");
	}

	public void prepareShipForLudicrousSpeed() {
		System.out.println();
		System.out.println(
				"Lord Helmet: Light speed is too slow, we're going to have to go right to....Ludicrous Speed!");
		System.out.println();
		System.out.println("Col Sanderz: Sir we've never gone that fast before, I don't know if the ship can take it.");
		System.out.println();
		System.out.println("Lord Helmet: What's the matter Col Sanderz? Chicken??");
		System.out.println();
		System.out.println("Col Sanderz: Prepare ship.....Prepare ship for Ludicrous speed!");
		System.out.println();
		System.out.println("Barf: What the hell was that??");
		System.out.println();
		System.out.println("Lonestar: Space Ball One!!");
		System.out.println();
		System.out.println("Barf: They've gone to plaid");
	}
}
