package com.thales.dis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class SpotLineInformationTest {

    @Test
    void generateInformationVehiclesForLargePlaces() {
	      Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
	      numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        SpotLineInformation spotLineInformation = new SpotLineInformation();
        spotLineInformation.setNumberFreeSpotyByType(numberSpotsByType);
        assertEquals("THERE ARE:\n"
        		+ "1 SPOT FOR MOTOS\n"
        		+ "1 SPOT FOR CARS\n"
        		+ "0 SPOTS FOR BUSES", spotLineInformation.getVehiclesPossibility”ccupation().toString());

    }

    @Test
    void generateInformationVehiclesForMotoPlaces() {
	      Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
	      numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        SpotLineInformation spotLineInformation = new SpotLineInformation();
        spotLineInformation.setNumberFreeSpotyByType(numberSpotsByType);
        assertEquals("THERE ARE:\n"
        		+ "1 SPOT FOR MOTOS\n"
        		+ "0 SPOTS FOR CARS\n"
        		+ "0 SPOTS FOR BUSES", spotLineInformation.getVehiclesPossibility”ccupation().toString());

    }
    
    @Test
    void generateInformationVehiclesForCompactPlaces() {
	      Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
	      numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        SpotLineInformation spotLineInformation = new SpotLineInformation();
        spotLineInformation.setNumberFreeSpotyByType(numberSpotsByType);
        assertEquals("THERE ARE:\n"
        		+ "1 SPOT FOR MOTOS\n"
        		+ "1 SPOT FOR CARS\n"
        		+ "0 SPOTS FOR BUSES", spotLineInformation.getVehiclesPossibility”ccupation().toString());

    }
    @Test
    void generateInformationVehiclesForTwoMotos() {
	      Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
	      numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 2);
        SpotLineInformation spotLineInformation = new SpotLineInformation();
        spotLineInformation.setNumberFreeSpotyByType(numberSpotsByType);
        assertEquals("THERE ARE:\n"
        		+ "2 SPOTS FOR MOTOS\n"
        		+ "0 SPOTS FOR CARS\n"
        		+ "0 SPOTS FOR BUSES", spotLineInformation.getVehiclesPossibility”ccupation().toString());

    }
    
    @Test
    void generateInformationVehiclesForTwoCompactPlaces() {
	      Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
	      numberSpotsByType.put(SpotType.COMPACT_TYPE, 2);
        SpotLineInformation spotLineInformation = new SpotLineInformation();
        spotLineInformation.setNumberFreeSpotyByType(numberSpotsByType);
        assertEquals("THERE ARE:\n"
        		+ "2 SPOTS FOR MOTOS\n"
        		+ "2 SPOTS FOR CARS\n"
        		+ "0 SPOTS FOR BUSES", spotLineInformation.getVehiclesPossibility”ccupation().toString());


    }

    
    @Test
    void generateInformationVehiclesForFiveLargePlaces() {
	      Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
	      numberSpotsByType.put(SpotType.LARGE_TYPE, 5);
        SpotLineInformation spotLineInformation = new SpotLineInformation();
        spotLineInformation.setNumberFreeSpotyByType(numberSpotsByType);
        assertEquals("THERE ARE:\n"
        		+ "5 SPOTS FOR MOTOS\n"
        		+ "5 SPOTS FOR CARS\n"
        		+ "1 SPOT FOR BUSES", spotLineInformation.getVehiclesPossibility”ccupation().toString());


    }
    
    @Test
    void generateInformationVehiclesForFourLargePlaces() {
	      Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
	      numberSpotsByType.put(SpotType.LARGE_TYPE, 4);
        SpotLineInformation spotLineInformation = new SpotLineInformation();
        spotLineInformation.setNumberFreeSpotyByType(numberSpotsByType);
        assertEquals("THERE ARE:\n"
        		+ "4 SPOTS FOR MOTOS\n"
        		+ "4 SPOTS FOR CARS\n"
        		+ "0 SPOTS FOR BUSES", spotLineInformation.getVehiclesPossibility”ccupation().toString().toString());

    }
    
    @Test
    void generateInformationVehiclesForTenLargePlaces() {
	      Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
	      numberSpotsByType.put(SpotType.LARGE_TYPE, 10);
        SpotLineInformation spotLineInformation = new SpotLineInformation();
        spotLineInformation.setNumberFreeSpotyByType(numberSpotsByType);
        assertEquals("THERE ARE:\n"
        		+ "10 SPOTS FOR MOTOS\n"
        		+ "10 SPOTS FOR CARS\n"
        		+ "2 SPOTS FOR BUSES", spotLineInformation.getVehiclesPossibility”ccupation().toString());
    }
    
    @Test
    void generateInformationWithTwoTypesOfSpots() {
	      Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
	      numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
	      numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        SpotLineInformation spotLineInformation = new SpotLineInformation();
        spotLineInformation.setNumberFreeSpotyByType(numberSpotsByType);
        assertEquals("THERE ARE:\n"
        		+ "2 SPOTS FOR MOTOS\n"
        		+ "2 SPOTS FOR CARS\n"
        		+ "0 SPOTS FOR BUSES", spotLineInformation.getVehiclesPossibility”ccupation().toString());

    }
    
    
    @Test
    void generateInformationWithSeveralTypesOfSpots() {
	      Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
	      numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
	      numberSpotsByType.put(SpotType.LARGE_TYPE, 6);
	      numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        SpotLineInformation spotLineInformation = new SpotLineInformation();
        spotLineInformation.setNumberFreeSpotyByType(numberSpotsByType);
        assertEquals("THERE ARE:\n"
        		+ "8 SPOTS FOR MOTOS\n"
        		+ "7 SPOTS FOR CARS\n"
        		+ "1 SPOT FOR BUSES", spotLineInformation.getVehiclesPossibility”ccupation().toString());

    }
    
}
