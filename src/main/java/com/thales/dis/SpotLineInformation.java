package com.thales.dis;

import java.util.Map;

public class SpotLineInformation {
	
    public static final int NUMBER_OF_PLACES_FOR_BUSES = 5;
    public static final int NUMBER_OF_PLACES_FOR_MOTO_OR_CAR = 1;
    
	 private Map<SpotType, Integer> numberFreeSpotyByType;
	 
	 int possibleBusesIntoLineSpots;
	 int possibleCarsIntoLineSpots;
	 int possibleMotosIntoLineSpots;
	
    public SpotLineInformation() {
		super();
	}



	public void reset () {
        this.numberFreeSpotyByType = null;
    }
    
    

	public Map<SpotType, Integer> getNumberFreeSpotyByType() {
		return numberFreeSpotyByType;
	}

	public void setNumberFreeSpotyByType(Map<SpotType, Integer> numberFreeSpotyByType) {
		this.numberFreeSpotyByType = numberFreeSpotyByType;
	} 
	
    public void updateNumberOfFreePositions(Spot spot, VehiclesType vehicle) {
        int numberOfPositionsToBeEngaged = (vehicle.equals(VehiclesType.BUS))?NUMBER_OF_PLACES_FOR_BUSES: NUMBER_OF_PLACES_FOR_MOTO_OR_CAR;
        Integer elements = numberFreeSpotyByType.get(spot.getType());
        numberFreeSpotyByType.replace(spot.getType(), elements - numberOfPositionsToBeEngaged);
    }



	public String showPlacesForVehiclesInfo() {
		return "QUEDA 1 PLAZA PARA AUTOBUSES";
	}
    
  
}