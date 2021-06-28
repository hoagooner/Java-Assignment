package fa.training.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.utils.AirportValidator;

public class Airport implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public String ID;
	public String name;
	public Double runwaySize;
	public Double maxFixedwingParkingPlace;
	public Double maxRotatedwingParkingPlace;
	public List<Helicopter> helicopters;
	public List<Fixedwing> fixedwings;
	
	public Airport() {
	}

	public Airport(String ID, String name, Double runwaySize, Double maxFixedwingParkingPlace,
			Double maxRotatedwingParkingPlace, List<Helicopter> helicopters, List<Fixedwing> fixedwings) {
		super();
		this.ID = ID;
		this.name = name;
		this.runwaySize = runwaySize;
		this.maxFixedwingParkingPlace = maxFixedwingParkingPlace;
		this.maxRotatedwingParkingPlace = maxRotatedwingParkingPlace;
		this.helicopters = helicopters;
		this.fixedwings = fixedwings;
	}
	
	@Override
	public String toString() {
		return "Airport [ID=" + ID + ", name=" + name + ", runwaySize=" + runwaySize + ", maxFixedwingParkingPlace="
				+ maxFixedwingParkingPlace + ", maxRotatedwingParkingPlace=" + maxRotatedwingParkingPlace
				+ ", helicopters=" + helicopters + ", fixedwings=" + fixedwings + "]";
	}
	
	@SuppressWarnings("resource")
	public void input(List<Airport> airports) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				if (ID == null) {
					System.out.print("Enter ID (Ex: AP00000): ");
					String ID = sc.nextLine();
					this.ID = AirportValidator.isID(ID,airports) ? ID : null;
				}
				if (name == null) {
					System.out.print("Enter name: ");
					this.name = sc.nextLine();
				}
				if (runwaySize == null) {
					System.out.print("Enter runway size: ");
					this.runwaySize = Double.valueOf(sc.nextLine());
				}
				if (maxFixedwingParkingPlace == null) {
					System.out.print("Enter max fixed wing parking place: ");
					this.maxFixedwingParkingPlace = Double.valueOf(sc.nextLine());
				}
				if (maxRotatedwingParkingPlace == null) {
					System.out.print("Enter max rotated wing parking place: ");
					this.maxRotatedwingParkingPlace = Double.valueOf(sc.nextLine());
				}
				if (fixedwings == null) {
					fixedwings = new ArrayList<>();
				}
				if (helicopters == null) {
					helicopters = new ArrayList<>();
				}
				
				break;
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getRunwaySize() {
		return runwaySize;
	}

	public void setRunwaySize(Double runwaySize) {
		this.runwaySize = runwaySize;
	}

	public Double getFixedwingParkingPlace() {
		return maxFixedwingParkingPlace;
	}

	public void setFixedwingParkingPlace(Double maxFixedwingParkingPlace) {
		this.maxFixedwingParkingPlace = maxFixedwingParkingPlace;
	}

	public Double getRotatedwingParkingPlace() {
		return maxRotatedwingParkingPlace;
	}

	public void setRotatedwingParkingPlace(Double maxRotatedwingParkingPlace) {
		this.maxRotatedwingParkingPlace = maxRotatedwingParkingPlace;
	}

	public List<Helicopter> getHelicopters() {
		return helicopters;
	}

	public void setHelicopters(List<Helicopter> helicopters) {
		this.helicopters = helicopters;
	}

	public List<Fixedwing> getFixedwings() {
		return fixedwings;
	}

	public void setFixedwings(List<Fixedwing> fixedwings) {
		this.fixedwings = fixedwings;
	}
	
}
