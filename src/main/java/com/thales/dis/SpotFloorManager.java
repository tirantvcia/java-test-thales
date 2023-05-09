package com.thales.dis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SpotFloorManager {
	
	
	ArrayList<SpotLineManager> spotLines = null;
	Map<SpotType, Integer> totalFreeSpotsByType = null;
	
	public SpotFloorManager() {
		
	}

	public List<SpotLineManager> generate(int numberOfSpotLines, Map<SpotType, Integer> numberSpotsByType) {
		reset();
		
		for(int i = 0; i < numberOfSpotLines; i++) {
			addSpotLine(numberSpotsByType);
			updateTotalFreeSpots(numberSpotsByType);
		}
		 return spotLines;
	}

	private void updateTotalFreeSpots(Map<SpotType, Integer> numberSpotsByType) {
		if(totalFreeSpotsByType.isEmpty()) {
			numberSpotsByType.forEach((key, value)-> totalFreeSpotsByType.put(key, value));
		} else {
			numberSpotsByType.forEach((key, value)-> totalFreeSpotsByType.replace(key, totalFreeSpotsByType.get(key) + value));
		}
	}



	private void addSpotLine(Map<SpotType, Integer> numberSpotsByType) {
		SpotLineManager spotLineManager = new SpotLineManager();
		spotLineManager.generate(numberSpotsByType);
		spotLines.add(spotLineManager);
	}

	private void reset() {
		totalFreeSpotsByType = new HashMap<>();
		spotLines = new ArrayList<SpotLineManager>();
	}

	public boolean parkVehicleInFloorSpot(VehiclesType vehicle) {
		
		Optional<SpotLineManager> motoIsCorrectlyParked = checkSpotLinesToGetTheFirstOneWhereVehicleIsParked(vehicle);
		return motoIsCorrectlyParked.isPresent();
		
	}

	private Optional<SpotLineManager> checkSpotLinesToGetTheFirstOneWhereVehicleIsParked(VehiclesType vehicle) {
		return spotLines.stream()
				.filter(lineManager -> lineManager.parkVehicleInSpotLine(vehicle)).findFirst();
	}

	public Map<SpotType, Integer> getTotalFreeSpotsByType() {
		return totalFreeSpotsByType;
	}

	public void setTotalFreeSpotsByType(Map<SpotType, Integer> totalFreeSpotsByType) {
		this.totalFreeSpotsByType = totalFreeSpotsByType;
	}

}
