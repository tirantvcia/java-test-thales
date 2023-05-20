package com.thales.dis;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import io.vavr.control.Either;

public class SpotFloorManager {
	
	
	ArrayList<SpotLineManager> spotLines = null;
	
	public SpotFloorManager() {
		
	}

	public void generate(int numberOfSpotLines, Map<SpotType, Integer> numberSpotsByType) {
		reset();
		for(int i = 0; i < numberOfSpotLines; i++) {
			addSpotLine(numberSpotsByType);
		}
	}

	private void addSpotLine(Map<SpotType, Integer> numberSpotsByType) {
		SpotLineInformation vehiclesCapacityInfo = new SpotLineInformation(numberSpotsByType);
		SpotLine spotLine = new SpotLine(numberSpotsByType);
		Either<Object, SpotLineManager> spotLineManagerInstance = SpotLineManager.create(spotLine, vehiclesCapacityInfo);
		if(spotLineManagerInstance.isRight()) {
			spotLines.add(spotLineManagerInstance.get());	
		}
	}

	private void reset() {
		spotLines = new ArrayList<SpotLineManager>();
	}

	
	public boolean parkVehicleInFloorSpot(VehiclesType vehicle) {
		
		Optional<SpotLineManager> vehicleIsCorrectlyParked = getTheFirstOneSpotLinesWhereVehicleIsParked(vehicle);
		return vehicleIsCorrectlyParked.isPresent();
		
	}

	private Optional<SpotLineManager> getTheFirstOneSpotLinesWhereVehicleIsParked(VehiclesType vehicle) {
		SpotLineManager managerWhereVehicleIsParked = null;
		for(SpotLineManager manager:spotLines) {
			if(manager.parkVehicleInSpotLine(vehicle)) {
				managerWhereVehicleIsParked = manager;
				break;
			}
		}
		return Optional.ofNullable(managerWhereVehicleIsParked);
	}

	public VehiclesCapacityInFreeSpots getPossibleVehiclesCapacityByType() {
		Optional<VehiclesCapacityInFreeSpots> reduce = spotLines.stream().map(sp -> sp.getVehiclesCapacityInfo().getVehiclesPossibilityOccupation()).reduce((a, b) -> a.append(b));
		if(reduce.isPresent()) {
			VehiclesCapacityInFreeSpots vehiclesCapacityInFreeSpots = reduce.get();
			return vehiclesCapacityInFreeSpots;
		}
		return null;
	}

}
