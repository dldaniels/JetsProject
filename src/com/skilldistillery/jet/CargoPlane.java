package com.skilldistillery.jet;

public class CargoPlane extends Jet implements CargoCarrier{
	
	//subclass constructors

	public CargoPlane() {
		super();
	
	}

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	
	}
	
	//implements interface
	
	public void loadCargo() {
		System.out.println("I am loading cargo");
	}
}
