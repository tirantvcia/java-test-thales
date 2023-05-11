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
        assertEquals("QUEDA 1 PLAZA PARA COCHE O MOTO", spotLineInformation.showPlacesForVehiclesInfo());

    }

    @Test
    void generateInformationVehiclesForMotoPlaces() {
	      Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
	      numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        SpotLineInformation spotLineInformation = new SpotLineInformation();
        spotLineInformation.setNumberFreeSpotyByType(numberSpotsByType);
        assertEquals("QUEDA 1 PLAZA PARA MOTO", spotLineInformation.showPlacesForVehiclesInfo());

    }
    
    @Test
    void generateInformationVehiclesForCompactPlaces() {
	      Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
	      numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        SpotLineInformation spotLineInformation = new SpotLineInformation();
        spotLineInformation.setNumberFreeSpotyByType(numberSpotsByType);
        assertEquals("QUEDA 1 PLAZA PARA COCHE O MOTO", spotLineInformation.showPlacesForVehiclesInfo());

    }
    @Test
    void generateInformationVehiclesForTwoMotos() {
	      Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
	      numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 2);
        SpotLineInformation spotLineInformation = new SpotLineInformation();
        spotLineInformation.setNumberFreeSpotyByType(numberSpotsByType);
        assertEquals("QUEDAN 2 PLAZAS PARA MOTO", spotLineInformation.showPlacesForVehiclesInfo());

    }
    
    @Test
    void generateInformationVehiclesForTwoCompactPlaces() {
	      Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
	      numberSpotsByType.put(SpotType.COMPACT_TYPE, 2);
        SpotLineInformation spotLineInformation = new SpotLineInformation();
        spotLineInformation.setNumberFreeSpotyByType(numberSpotsByType);
        assertEquals("QUEDAN 2 PLAZAS PARA COCHE O MOTO", spotLineInformation.showPlacesForVehiclesInfo());

    }

    
    @Test
    void generateInformationVehiclesForFiveLargePlaces() {
	      Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
	      numberSpotsByType.put(SpotType.LARGE_TYPE, 5);
        SpotLineInformation spotLineInformation = new SpotLineInformation();
        spotLineInformation.setNumberFreeSpotyByType(numberSpotsByType);
        assertEquals("QUEDA 1 PLAZA PARA AUTOBUS O 5 PLAZAS PARA COCHE O MOTO", spotLineInformation.showPlacesForVehiclesInfo());

    }
    
    @Test
    void generateInformationVehiclesForFourLargePlaces() {
	      Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
	      numberSpotsByType.put(SpotType.LARGE_TYPE, 4);
        SpotLineInformation spotLineInformation = new SpotLineInformation();
        spotLineInformation.setNumberFreeSpotyByType(numberSpotsByType);
        assertEquals("QUEDAN 4 PLAZAS PARA COCHE O MOTO", spotLineInformation.showPlacesForVehiclesInfo());

    }
    
    @Test
    void generateInformationVehiclesForTenLargePlaces() {
	      Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
	      numberSpotsByType.put(SpotType.LARGE_TYPE, 10);
        SpotLineInformation spotLineInformation = new SpotLineInformation();
        spotLineInformation.setNumberFreeSpotyByType(numberSpotsByType);
        assertEquals("QUEDAN 2 PLAZAS PARA AUTOBUS O 10 PLAZAS PARA COCHE O MOTO", spotLineInformation.showPlacesForVehiclesInfo());

    }
    
    
//    @Test
//    void generateInformationVehiclesForTwoCompactPlaces() {
//	      Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
//	      numberSpotsByType.put(SpotType.COMPACT_TYPE, 2);
//        SpotLineInformation spotLineInformation = new SpotLineInformation();
//        spotLineInformation.setNumberFreeSpotyByType(numberSpotsByType);
//        assertEquals("QUEDA 2 PLAZAS PARA COCHE O MOTO", spotLineInformation.showPlacesForVehiclesInfo());
//
//    }
    
//    @Test
//    void parkCarInSpot() {
//        VehiclesType car = VehiclesType.CAR;
//        SpotLine manager = new SpotLine();
//        int numberOfRows = 1;
//        int position = 0;
//        manager.generateRowsOfSameType(SpotType.COMPACT_TYPE, numberOfRows);
//        assertEquals(true, manager.parkVehicle(position, car));
//        assertEquals(false, manager.parkVehicle(position, car));
//    }
//
//    @Test
//    void parkBusInSpot() {
//        VehiclesType bus = VehiclesType.BUS;
//        SpotLine manager = new SpotLine();
//        int numberOfRows = 6;
//        int position = 0;
//        manager.generateRowsOfSameType(SpotType.LARGE_TYPE, numberOfRows);
//        assertEquals(true, manager.parkVehicle(position, bus));
//        assertEquals(false, manager.parkVehicle(position, bus));
//    }
//
//    @Test
//    void generateListOfSpotWithDifferentTypes() {
//        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
//        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
//        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
//        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
//        SpotLine manager = new SpotLine();
//        List<Spot> spotslistResult = manager.generate(numberSpotsByType);
//        assertEquals(3, spotslistResult.size());
////        manager.getNumberFreeSpotyByType().values().stream().forEach(
////                numberOfSpots -> assertEquals(1, numberOfSpots)
////        );
//    }
//
//    @Test
//    void parkingCarInSpotLine() {
//        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
//        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
//        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
//        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
//        SpotLine manager = new SpotLine();
//        List<Spot> spotslistResult = manager.generate(numberSpotsByType);
//        assertEquals(3, spotslistResult.size());
//        assertEquals(true, manager.parkVehicleInSpotLine(VehiclesType.CAR));
////        assertEquals(true, manager.getNumberFreeSpotyByType().get(SpotType.COMPACT_TYPE) == 0
////        || manager.getNumberFreeSpotyByType().get(SpotType.LARGE_TYPE) == 0);
//
//    }
//
//    @Test
//    void parkingTwoCarsInSpotLine() {
//        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
//        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
//        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
//        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
//        SpotLine manager = new SpotLine();
//        List<Spot> spotslistResult = manager.generate(numberSpotsByType);
//        assertEquals(3, spotslistResult.size());
//        assertEquals(true, manager.parkVehicleInSpotLine(VehiclesType.CAR));
//        assertEquals(true, manager.parkVehicleInSpotLine(VehiclesType.CAR));
////        assertEquals(true, manager.getNumberFreeSpotyByType().get(SpotType.COMPACT_TYPE) == 0
////                && manager.getNumberFreeSpotyByType().get(SpotType.LARGE_TYPE) == 0);
//
//    }
//    @Test
//    void parkingMoreCarsThanPermittedInSpotLine() {
//        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
//        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
//        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
//        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
//        SpotLine manager = new SpotLine();
//        List<Spot> spotslistResult = manager.generate(numberSpotsByType);
//        assertEquals(3, spotslistResult.size());
//        assertEquals(true, manager.parkVehicleInSpotLine(VehiclesType.CAR));
//        assertEquals(true, manager.parkVehicleInSpotLine(VehiclesType.CAR));
//        assertEquals(false, manager.parkVehicleInSpotLine(VehiclesType.CAR));
//
//    }
//
//    @Test
//    void parkingBusInSpotLine() {
//        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
//        numberSpotsByType.put(SpotType.LARGE_TYPE, 5);
//        SpotLine manager = new SpotLine();
//        List<Spot> spotslistResult = manager.generate(numberSpotsByType);
//        assertEquals(5, spotslistResult.size());
//        assertEquals(true, manager.parkVehicleInSpotLine(VehiclesType.BUS));
////        assertEquals(true, manager.getNumberFreeSpotyByType().get(SpotType.LARGE_TYPE) == 0);
//
//
//    }

}
