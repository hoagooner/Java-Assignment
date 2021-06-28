package fa.training.entities;

import java.io.Serializable;

public abstract class Airplane implements Serializable{
	public String ID;
	public String model;
	public Double speed;
	public Double emptyWeight;
	public Double maxTakeoffWeight;
	
	public Airplane() {
	}
	
	public Airplane(String iD, String model, Double speed, Double emptyWeight, Double maxTakeoffWeight) {
		super();
		ID = iD;
		this.model = model;
		this.speed = speed;
		this.emptyWeight = emptyWeight;
		this.maxTakeoffWeight = maxTakeoffWeight;
	}
	
	@Override
	public String toString() {
		return "Airplane [ID=" + ID + ", model=" + model + ", speed=" + speed + ", emptyWeight=" + emptyWeight
				+ ", maxTakeoffWeight=" + maxTakeoffWeight + "]";
	}
	
	public abstract void fly();

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Double getWeight() {
		return emptyWeight;
	}

	public void setWeight(Double weight) {
		this.emptyWeight = weight;
	}

	public Double getTakeoffWeight() {
		return maxTakeoffWeight;
	}

	public void setTakeoffWeight(Double maxTakeoffWeight) {
		this.maxTakeoffWeight = maxTakeoffWeight;
	}

}
