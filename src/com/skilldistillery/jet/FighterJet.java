package com.skilldistillery.jet;

public class FighterJet extends Jet{
	
	

	public FighterJet() {
		super();
		
	}

	public FighterJet(String model, double speed, int range, long price, int hitPoints, int numOfMissles) {
		super(model, speed, range, price);
	
	}
	
	public void fight() {
		System.out.println("I am fighting");
	}

	
	

}
