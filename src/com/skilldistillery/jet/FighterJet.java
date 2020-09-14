package com.skilldistillery.jet;

public class FighterJet extends Jet implements CombatReady,Transforms{

	// subclass constructors

	public FighterJet() {
		super();

	}

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);

	}

	// implements interface method

	@Override
	public void fight() {
		// TODO Auto-generated method stub
		System.out.println("I am " + getModel() + " I am fighting.");

	}
	
	public void ohDamn() {
		System.out.println(" Oh no!! That " + getModel() + " is not a regular jet!! That is a robot in disquise. It is Starscream who appears to "
				+ "have come from Cybertron to destroy us all!!! Somebody go find Optimus Prime, Shia Lebeauf, Mark Wahlberg, John Cena!!");
		System.out.println();
		System.out.println("TREMBLE BEFORE AIR COMMANDER STARSCREAM!!! I WILL RULE YOU ALL!!");
	}

}
