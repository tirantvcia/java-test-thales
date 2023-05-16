package com.thales.dis;

import java.util.HashMap;
import java.util.Map;

public class SpotLineInformation implements Cloneable {

	public static final int NUMBER_OF_PLACES_FOR_BUSES = 5;
	public static final int NUMBER_OF_PLACES_FOR_MOTO_OR_CAR = 1;

	private Map<SpotType, Integer> numberFreeSpotyByType;

	public SpotLineInformation() {
		reset();
	}

	public SpotLineInformation(Map<SpotType, Integer> numberSpotsByType) {
		this.numberFreeSpotyByType = numberSpotsByType;
	}

	public void reset() {
		this.numberFreeSpotyByType = new HashMap<SpotType, Integer>();
	}

	public Map<SpotType, Integer> getNumberFreeSpotyByType() {
		return numberFreeSpotyByType;
	}

	public void setNumberFreeSpotyByType(Map<SpotType, Integer> numberFreeSpotyByType) {
		this.numberFreeSpotyByType = numberFreeSpotyByType;
	}

	public void updateNumberOfFreePositions(Spot spot, VehiclesType vehicle) {
		int numberOfPositionsToBeEngaged = (vehicle.equals(VehiclesType.BUS)) ? NUMBER_OF_PLACES_FOR_BUSES
				: NUMBER_OF_PLACES_FOR_MOTO_OR_CAR;
		Integer elements = numberFreeSpotyByType.get(spot.getType());
		numberFreeSpotyByType.replace(spot.getType(), elements - numberOfPositionsToBeEngaged);

	}

	public VehiclesCapacityInFreeSpots getVehiclesPossibility”ccupation() {
		return new VehiclesCapacityInFreeSpots(numberFreeSpotyByType);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		try {
			SpotLineInformation cloned = (SpotLineInformation) super.clone();
			cloned.numberFreeSpotyByType = new HashMap<>(this.numberFreeSpotyByType);
			return cloned;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

}