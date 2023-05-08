package com.thales.dis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SpotFloorManager {
	
	
	ArrayList<SpotLineManager> spotLines = null;
	Map<SpotType, Integer> totalFreeSpotsByType = new HashMap<>();
	
	public SpotFloorManager() {
		spotLines = new ArrayList<SpotLineManager>();
	}

	public List<SpotLineManager> generate(int numberOfSpotLines, Map<SpotType, Integer> numberSpotsByType) {
		for(int i = 0; i < numberOfSpotLines; i++) {
			SpotLineManager spotLineManager = new SpotLineManager();
			spotLineManager.generate(numberSpotsByType);
			spotLines.add(spotLineManager);
		}
		 return spotLines;
	}

	public boolean parkVehicleInFloorSpot(VehiclesType motorcycle) {
		
		Optional<SpotLineManager> motoIsCorrectlyParked = spotLines.stream().filter(lineManager -> lineManager.parkVehicleInSpotLine(motorcycle)).findFirst();
		return motoIsCorrectlyParked.isPresent();
		
	}

	public Map<SpotType, Integer> getTotalFreeSpotsByType() {
		return totalFreeSpotsByType;
	}

	public void setTotalFreeSpotsByType(Map<SpotType, Integer> totalFreeSpotsByType) {
		this.totalFreeSpotsByType = totalFreeSpotsByType;
	}

}