package com.thales.dis;

import java.util.Map;

public class SpotLineInformation {
	
    public static final int NUMBER_OF_PLACES_FOR_BUSES = 5;
    public static final int NUMBER_OF_PLACES_FOR_MOTO_OR_CAR = 1;
    
	 private Map<SpotType, Integer> numberFreeSpotyByType;
	 
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
		
		if(getNumberOfPlacesForOnlyMotorcycleType() > 0) {
			int numberOfPlacesForOnlyMoto = getNumberOfPlacesForOnlyMotorcycleType();
			return makeForMotoCycleInformation(numberOfPlacesForOnlyMoto);
		}
		if(getNumberOfPlacesLargeType() > 0) {
			int numberOfPlacesLargeType = getNumberOfPlacesLargeType();
			return makeForAnyTypeOfVehicleInformation(numberOfPlacesLargeType);
		}
		return makeForMotoOrCarInformation();
		
	}



	private String makeForAnyTypeOfVehicleInformation(int numberOfPlacesLargeType) {
		
		if(numberOfPlacesLargeType%NUMBER_OF_PLACES_FOR_BUSES == 0) {
			return makeForAllTypeOfVehicleInformation(numberOfPlacesLargeType);
		}
		
		return makeForMotoOrCarInformation();
	}



	private String makeForAllTypeOfVehicleInformation(int numberOfPlacesLargeType) {
		
		int numberOfPlacesForBuses = (numberOfPlacesLargeType/NUMBER_OF_PLACES_FOR_BUSES);
		
		String moreThanOneVerbTermination = moreThanOneVerbTermination(numberOfPlacesForBuses);
		String moreThanOneSustantiveTermination = moreThanOneSustantiveTermination(numberOfPlacesForBuses);
		
		return String.format("QUEDA%s %s PLAZA%s PARA AUTOBUS O %s PLAZAS PARA COCHE O MOTO", moreThanOneVerbTermination, 
					numberOfPlacesForBuses, moreThanOneSustantiveTermination, numberOfPlacesLargeType);
	}



	private int getNumberOfPlacesLargeType() {
		boolean isThereAnyLargePlace = !numberFreeSpotyByType.isEmpty() &&  numberFreeSpotyByType.get(SpotType.LARGE_TYPE) != null;
		if (isThereAnyLargePlace) {
			return numberFreeSpotyByType.get(SpotType.LARGE_TYPE);
		}
		return 0;
	}



	private String makeForMotoOrCarInformation() {
		
		int numberOfPlacesForMotoOrCar = getNumberOfPlacesForMotoOrCar();
		String moreThanOneVerbTermination = moreThanOneVerbTermination(numberOfPlacesForMotoOrCar);
		String moreThanOneSustantiveTermination = moreThanOneSustantiveTermination(numberOfPlacesForMotoOrCar);
		return String.format("QUEDA%s %s PLAZA%s PARA COCHE O MOTO", moreThanOneVerbTermination, numberOfPlacesForMotoOrCar, moreThanOneSustantiveTermination);

	}



	private String moreThanOneSustantiveTermination(int numberOfPlacesForMotoOrCar) {
		return numberOfPlacesForMotoOrCar>1?"S":"";
	}



	private String moreThanOneVerbTermination(int numberOfPlacesForMotoOrCar) {
		return numberOfPlacesForMotoOrCar>1?"N":"";
	}



	private int getNumberOfPlacesForMotoOrCar() {
		boolean isThereAnyCarTypePlace = !numberFreeSpotyByType.isEmpty() && 
				(numberFreeSpotyByType.get(SpotType.COMPACT_TYPE) != null || numberFreeSpotyByType.get(SpotType.LARGE_TYPE) != null);
		if (isThereAnyCarTypePlace) {
			return (numberFreeSpotyByType.get(SpotType.COMPACT_TYPE) != null)? numberFreeSpotyByType.get(SpotType.COMPACT_TYPE):numberFreeSpotyByType.get(SpotType.LARGE_TYPE);
		}
		return 0;
	}



	private String makeForMotoCycleInformation(int numberOfPlacesForMoto) {
		String moreThanOneVerbTermination = moreThanOneVerbTermination(numberOfPlacesForMoto);
		String moreThanOneSustantiveTermination = moreThanOneSustantiveTermination(numberOfPlacesForMoto);
		return String.format("QUEDA%s %s PLAZA%s PARA MOTO", moreThanOneVerbTermination, numberOfPlacesForMoto, moreThanOneSustantiveTermination);
				
	}



	private int getNumberOfPlacesForOnlyMotorcycleType() {
		 boolean isThereAnyMotoTypePlace = (!numberFreeSpotyByType.isEmpty()) && (numberFreeSpotyByType.get(SpotType.MOTORCYCLE_TYPE) != null);
		 return (isThereAnyMotoTypePlace)? numberFreeSpotyByType.get(SpotType.MOTORCYCLE_TYPE) : 0;
	}
    
  
}
