package com.skilldistillery.jet;

public abstract class Jet {

	// abstract class properties

	private String model;
	private double speed;
	private int range;
	private long price;

	// constructors

	public Jet() {

	}

	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	// super class methods
	// fly method shows planes flying and determines the amount of time in air based
	// on speed and range
	public void fly() {
		double flightTime = (int) range / speed;
		System.out.println("I am flying!!");
		System.out.print(model + " is capable of flying " + speed + " MPH for ");
		System.out.printf("%.2f" , flightTime);
		System.out.print(" hours.");
		System.out.println();
		System.out.println();
		
	}

	// get speed in mach converts MPH speed to Mach speed
	public double getSpeedInMach() {
		double machSpeed = speed / 767.269;
		return machSpeed;
	}

	// getters and setters

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	// hashcode

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + (int) (price ^ (price >>> 32));
		result = prime * result + range;
		long temp;
		temp = Double.doubleToLongBits(speed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	// equals

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (price != other.price)
			return false;
		if (range != other.range)
			return false;
		if (Double.doubleToLongBits(speed) != Double.doubleToLongBits(other.speed))
			return false;
		return true;
	}

	// toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jet Model: ");
		builder.append(model);
		builder.append(", Speed in MPH: ");
		builder.append(speed);
		builder.append(", Range in miles: ");
		builder.append(range);
		builder.append(", price: ");
		builder.append(price);
		builder.append(".");
		return builder.toString();
	}

}
