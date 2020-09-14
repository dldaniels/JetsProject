package com.skilldistillery.jet;

public class FighterJet extends Jet implements CombatReady{
	
	//subclass constructors

	public FighterJet() {
		super();
		
	}

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	
	}
	
	//implements interface method

	@Override
	public void fight() {
		// TODO Auto-generated method stub
	 System.out.println("I am fighting");
		
	}
	


	
	

}
