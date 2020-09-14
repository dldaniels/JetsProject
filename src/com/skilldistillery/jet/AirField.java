package com.skilldistillery.jet;

import java.util.ArrayList;
import java.util.List;


//user story 2, create an airfield class and an empty list of jets
public class AirField {
	
	//private ArrayList to hold jets
	private List <Jet> hangarList = new ArrayList<>();
	
	//AirField constructors
	public AirField() {
		
	}
	//method to add jet to airfield
	public void addJet (Jet newJet) {
		this.hangarList.add(newJet);
	}
	//method to remove jet from airfield
	public void removeJet(int i) {
	//	this.hangarList.remove(--i);
		Jet removed = hangarList.remove(--i);
		System.out.println("Wave goodbye to " + removed + " becasue that sucka is outta here!!");
	}
		
	//retrieve array list from AirField
	public List<Jet>getHangarList(){
		return hangarList;
	}
	
	
}
