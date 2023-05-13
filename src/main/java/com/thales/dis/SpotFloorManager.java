package com.thales.dis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SpotFloorManager {
	
	
	ArrayList<SpotLineManager> spotLines = null;
	
	public SpotFloorManager() {
		
	}

	public List<Spot> generate(int numberOfSpotLines, Map<SpotType, Integer> numberSpotsByType) {
		reset();
		List<Spot> lineSpot = new ArrayList<Spot>();
		for(int i = 0; i < numberOfSpotLines; i++) {
			addSpotLine(numberSpotsByType);
		}
		 return lineSpot;
	}

	private void addSpotLine(Map<SpotType, Integer> numberSpotsByType) {
		SpotLineManager spotLineManager = new SpotLineManager(numberSpotsByType);
		spotLines.add(spotLineManager);
	}

	private void reset() {
		spotLines = new ArrayList<SpotLineManager>();
	}

	
	public boolean parkVehicleInFloorSpot(VehiclesType vehicle) {
		
		Optional<SpotLineManager> motoIsCorrectlyParked = getTheFirstOneSpotLinesWhereVehicleIsParked(vehicle);
		return motoIsCorrectlyParked.isPresent();
		
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

	public Map<VehiclesType, Integer> getPossibleVehiclesCapacityByType() {
		Optional<VehiclesCapacityInFreeSpots> reduce = spotLines.stream().map(sp -> sp.getVehiclesCapacityInfo().getVehiclesPossibilityÓccupation()).reduce((a, b) -> a.append(b));
		if(reduce.isPresent()) {
			return reduce.get().getVehicles();
		}
		return null;
	}

}
