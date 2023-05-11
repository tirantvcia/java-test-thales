package com.thales.dis;

import java.util.Map;

public class SpotLineInformation {
	
    public static final int NUMBER_OF_PLACES_FOR_BUSES = 5;
    public static final int NUMBER_OF_PLACES_FOR_MOTO_OR_CAR = 1;
    
	 private Map<SpotType, Integer> numberFreeSpotyByType;
	 
	 private int cars;
	 private int motos;
	 private int buses;
	 
	 
    public SpotLineInformation() {
    	reset();
	}



	public void reset () {
        this.numberFreeSpotyByType = null;
    	cars = 0;
    	motos = 0;
    	buses = 0;
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
		
		numberFreeSpotyByType.forEach((type, number) -> {
			mapToNumberOfVehicles(type, number);
		});
		
		StringBuffer informationText = new StringBuffer("THERE ARE:\n") ;
		
		
		informationText.append(makeForMotoCycleInformation())
			.append(makeForCarInformation())
			.append(makeForBusInformation());
		 
		return informationText.toString();
		
	}



	private String makeForBusInformation() {
		String moreThanOneSustantiveTermination = moreThanOneSustantiveTermination(buses);
		return String.format("%s SPOT%s FOR BUSES", buses, moreThanOneSustantiveTermination);
	}



	private String makeForCarInformation() {
		String moreThanOneSustantiveTermination = moreThanOneSustantiveTermination(cars);
		return String.format("%s SPOT%s FOR CARS\n", cars, moreThanOneSustantiveTermination);
	}

	private String makeForMotoCycleInformation() {
		String moreThanOneSustantiveTermination = moreThanOneSustantiveTermination(motos);
		return String.format("%s SPOT%s FOR MOTOS\n", motos, moreThanOneSustantiveTermination);
				
	}



	private void mapToNumberOfVehicles(SpotType type, Integer number) {
        switch(type) {
        case COMPACT_TYPE:
            addNumberToCarsAndMotos(number);
            break;
        case LARGE_TYPE:
            addNumberToAllVehicles(number);
            break;
        case MOTORCYCLE_TYPE:
        	addNumberToMotos(number);
        	break;
    }
		
}



	private void addNumberToMotos(Integer number) {
		motos += number;
	}



	private void addNumberToAllVehicles(Integer number) {
		addNumberToCarsAndMotos(number);
		if(number >= NUMBER_OF_PLACES_FOR_BUSES) {
			buses += (number / NUMBER_OF_PLACES_FOR_BUSES);
		}
	}



	private void addNumberToCarsAndMotos(Integer number) {
		cars += number;
		addNumberToMotos(number);
	}



	private String moreThanOneSustantiveTermination(int numberOfPlacesForMotoOrCar) {
		return numberOfPlacesForMotoOrCar>1 || numberOfPlacesForMotoOrCar==0?"S":"";
	}


	public int getCars() {
		return cars;
	}



	public void setCars(int cars) {
		this.cars = cars;
	}



	public int getMotos() {
		return motos;
	}



	public void setMotos(int motos) {
		this.motos = motos;
	}



	public int getBuses() {
		return buses;
	}



	public void setBuses(int buses) {
		this.buses = buses;
	}
    
  
}
