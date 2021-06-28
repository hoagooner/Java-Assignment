package fa.training.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import fa.training.utils.AirplaneValidator;
import fa.training.utils.HelicopterValidator;

public class Helicopter extends Airplane implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public Double range;
	   	
	public Helicopter() {
		super();
	}

	public Helicopter(String iD, String model, Double speed, Double weight, Double takeoffWeight, Double range) {
		super(iD, model, speed, weight, takeoffWeight);
		this.range = range;
	}

	@Override
	public String toString() {
		return "Helicopter [ID=" + ID + ", model=" + model + ", speed=" + speed + ", emptyWeight=" + emptyWeight
				+ ", maxTakeoffWeight=" + maxTakeoffWeight + ", range=" + range + "]";
	}
	
	@SuppressWarnings("resource")
	public void input(List<Helicopter> helicopters) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				if (ID == null) {
					System.out.print("Enter ID (Ex: RW00000): ");
					String ID = sc.nextLine();
					this.ID = HelicopterValidator.isID(ID, helicopters) ? ID : null;
				}
				if (model == null) {
					System.out.print("Enter model: ");
					String model = sc.nextLine();
					this.model = AirplaneValidator.isModel(model) ? model : null;
				}
				if (speed == null) {
					System.out.print("Enter speed: ");
					this.speed = Double.valueOf(sc.nextLine());
				}
				if (emptyWeight == null) {
					System.out.print("Enter empty weight: ");
					this.emptyWeight = Double.valueOf(sc.nextLine());
				}
				if (maxTakeoffWeight == null) {
					System.out.print("Enter max takeoff weight: ");
					Double maxTakeoffWeight = Double.valueOf(sc.nextLine());
					this.maxTakeoffWeight = HelicopterValidator.isMaxTakeoffWeight(maxTakeoffWeight, emptyWeight) ? maxTakeoffWeight : null; 
				}
				if (range == null) {
					System.out.print("Enter range: ");
					this.range = Double.valueOf(sc.nextLine());
				}
				
				break;
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	@Override
	public void fly() {
		System.out.println("Rotated wing");
	}

	public Double getRange() {
		return range;
	}
	
	public void setRange(Double range) {
		this.range = range;
	}

	
}
