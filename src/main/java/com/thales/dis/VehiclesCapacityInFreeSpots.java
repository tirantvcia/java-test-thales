package com.thales.dis;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class VehiclesCapacityInFreeSpots {
	public static final int NUMBER_OF_PLACES_FOR_BUSES = 5;
	public static final int NUMBER_OF_PLACES_FOR_MOTO_OR_CAR = 1;

	private Map<VehiclesType, Integer> vehicles;

	public VehiclesCapacityInFreeSpots() {
		this.vehicles = new HashMap<VehiclesType, Integer>();
		vehicles.put(VehiclesType.MOTORCYCLE, 0);
		vehicles.put(VehiclesType.CAR, 0);
		vehicles.put(VehiclesType.BUS, 0);
	}

	public VehiclesCapacityInFreeSpots(Map<SpotType, Integer> numberFreeSpotyByType) {
		this();
		numberFreeSpotyByType.forEach((type, number) -> {
			addVehiclesByFreeSpotType(type, number);
		});
	}

	public void addVehiclesByFreeSpotType(SpotType type, Integer number) {

 		switch (type) {
		case COMPACT_TYPE:
			addNumberToCarsAndMotos(number);
			break;
		case LARGE_TYPE:
			addNumberToAllVehicles(number);
			break;
		case MOTORCYCLE_TYPE:
			addMotos(number);
			break;
		}

	}

	private void addMotos(Integer number) {
		int motos = vehicles.get(VehiclesType.MOTORCYCLE) + number;
		vehicles.replace(VehiclesType.MOTORCYCLE, motos);

	}

	private void addNumberToAllVehicles(Integer number) {
		addNumberToCarsAndMotos(number);
		if (number >= NUMBER_OF_PLACES_FOR_BUSES) {
			addBuses(number);
		}
	}

	private void addBuses(Integer number) {
		int buses = vehicles.get(VehiclesType.BUS);
		buses += (number / NUMBER_OF_PLACES_FOR_BUSES);
		vehicles.replace(VehiclesType.BUS, buses);
	}

	private void addNumberToCarsAndMotos(Integer number) {
		addCars(number);
		addMotos(number);
	}

	private void addCars(Integer number) {
		int cars = vehicles.get(VehiclesType.CAR) + number;
		vehicles.replace(VehiclesType.CAR, cars);
	}

	@Override
	public String toString() {
		StringBuffer informationText = new StringBuffer("THERE ARE:\n");

		informationText.append(makeForMotoCycleInformation()).append(makeForCarInformation())
				.append(makeForBusInformation());

		return informationText.toString();

	}

	private String makeForBusInformation() {
		int buses = vehicles.get(VehiclesType.BUS);
		String moreThanOneSustantiveTermination = moreThanOneSustantiveTermination(buses);
		return String.format("%s SPOT%s FOR BUSES", buses, moreThanOneSustantiveTermination);
	}

	private String makeForCarInformation() {
		int cars = vehicles.get(VehiclesType.CAR);
		String moreThanOneSustantiveTermination = moreThanOneSustantiveTermination(cars);
		return String.format("%s SPOT%s FOR CARS\n", cars, moreThanOneSustantiveTermination);
	}

	private String makeForMotoCycleInformation() {
		int motos = vehicles.get(VehiclesType.MOTORCYCLE);
		String moreThanOneSustantiveTermination = moreThanOneSustantiveTermination(motos);
		return String.format("%s SPOT%s FOR MOTOS\n", motos, moreThanOneSustantiveTermination);

	}

	private String moreThanOneSustantiveTermination(int numberOfPlacesForMotoOrCar) {
		return numberOfPlacesForMotoOrCar > 1 || numberOfPlacesForMotoOrCar == 0 ? "S" : "";
	}

	public Map<VehiclesType, Integer> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Map<VehiclesType, Integer> vehicles) {
		this.vehicles = vehicles;
	}

	public  VehiclesCapacityInFreeSpots append(VehiclesCapacityInFreeSpots b) {
		Map<VehiclesType, Integer> vehicles2 = b.getVehicles();
		for (Entry<VehiclesType, Integer> entry : this.vehicles.entrySet()) {
	        vehicles.replace(entry.getKey() ,  entry.getValue() + vehicles2.get(entry.getKey())); 
	    }
		this.setVehicles(vehicles);
		return this;
	}

}