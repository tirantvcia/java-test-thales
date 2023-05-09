package com.thales.dis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class SpotFloorManagerTest {
    @Test
    void generationOfParkingFloorWithOnlyOneSpotLine() {
        SpotFloorManager manager = new SpotFloorManager();
        int numberOfSpotLines = 1;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        List<SpotLineManager> spotslinesResult = manager.generate(numberOfSpotLines, numberSpotsByType);
        assertEquals(1, spotslinesResult.size());
    }
    @Test
    void generationOfParkingFloorWithOnlyOneSpotLineWithDistributionIndicatedInMap() {
        SpotFloorManager manager = new SpotFloorManager();
        int numberOfSpotLines = 1;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        List<SpotLineManager> spotslinesResult = manager.generate(numberOfSpotLines, numberSpotsByType);
        assertEquals(1, spotslinesResult.size());
        assertEquals(3, spotslinesResult.get(0).getNumberFreeSpotyByType().size());
        spotslinesResult.get(0).getNumberFreeSpotyByType().forEach((type, numElments) ->  assertEquals(1, numElments));
    }
    @Test
    void generationOfParkingFloorWithSeveralSpotLineWithSameDistributionIndicatedInMap() {
        SpotFloorManager manager = new SpotFloorManager();
        int numberOfSpotLines = 3;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        List<SpotLineManager> spotslinesResult = manager.generate(numberOfSpotLines, numberSpotsByType);
        assertEquals(3, spotslinesResult.size());
        spotslinesResult.stream().forEach(spotLineManager -> {
        	assertEquals(3, spotLineManager.getNumberFreeSpotyByType().size());
        });
        
        spotslinesResult.stream().forEach(spotLineManager -> spotLineManager.getNumberFreeSpotyByType().forEach((type, numElments) ->  assertEquals(1, numElments)));
    }
    
    @Test
    void ParkingOneMotosIsPermittedInGeneratedLines() {
        SpotFloorManager manager = new SpotFloorManager();
        int numberOfSpotLines = 2;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        List<SpotLineManager> spotslinesResult = manager.generate(numberOfSpotLines, numberSpotsByType);
        assertEquals(2, spotslinesResult.size());
        assertEquals(true, manager.parkVehicleInFloorSpot(VehiclesType.MOTORCYCLE));
         
    }
    
    @Test
    void ParkingOneBusIsNotPermittedInGeneratedLines() {
        SpotFloorManager manager = new SpotFloorManager();
        int numberOfSpotLines = 2;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        List<SpotLineManager> spotslinesResult = manager.generate(numberOfSpotLines, numberSpotsByType);
        assertEquals(2, spotslinesResult.size());
        assertEquals(false, manager.parkVehicleInFloorSpot(VehiclesType.BUS));
         
    }
    
    @Test
    void ParkingOnlyTwoBusesIsPermittedInGeneratedLines() {
        SpotFloorManager manager = new SpotFloorManager();
        int numberOfSpotLines = 2;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 5);
        List<SpotLineManager> spotslinesResult = manager.generate(numberOfSpotLines, numberSpotsByType);
        assertEquals(2, spotslinesResult.size());
        assertEquals(true, manager.parkVehicleInFloorSpot(VehiclesType.BUS));
        assertEquals(true, manager.parkVehicleInFloorSpot(VehiclesType.BUS));
        assertEquals(false, manager.parkVehicleInFloorSpot(VehiclesType.BUS)); 
    }
    @Test
    void ParkingTwoBusesAndTwoCarsIsPermittedInGeneratedLines() {
        SpotFloorManager manager = new SpotFloorManager();
        int numberOfSpotLines = 2;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 5);
        List<SpotLineManager> spotslinesResult = manager.generate(numberOfSpotLines, numberSpotsByType);
        assertEquals(2, spotslinesResult.size());
        assertEquals(true, manager.parkVehicleInFloorSpot(VehiclesType.BUS));
        assertEquals(true, manager.parkVehicleInFloorSpot(VehiclesType.BUS));
        assertEquals(false, manager.parkVehicleInFloorSpot(VehiclesType.BUS));
        assertEquals(true, manager.parkVehicleInFloorSpot(VehiclesType.CAR));
        assertEquals(true, manager.parkVehicleInFloorSpot(VehiclesType.CAR));
    }
    @Test
    void ParkingFloorInformationWithTotalFreeSpotsByType() {
        SpotFloorManager manager = new SpotFloorManager();
        int numberOfSpotLines = 2;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        List<SpotLineManager> spotslinesResult = manager.generate(numberOfSpotLines, numberSpotsByType);
        assertEquals(2, spotslinesResult.size());
        assertEquals(2, manager.getTotalFreeSpotsByType().get(SpotType.MOTORCYCLE_TYPE));
        assertEquals(2, manager.getTotalFreeSpotsByType().get(SpotType.COMPACT_TYPE));
        assertEquals(2, manager.getTotalFreeSpotsByType().get(SpotType.LARGE_TYPE));
    }
    
    @Test
    void UpdateParkingFloorInformationWhenParkOneCar() {
        SpotFloorManager manager = new SpotFloorManager();
        int numberOfSpotLines = 2;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        List<SpotLineManager> spotslinesResult = manager.generate(numberOfSpotLines, numberSpotsByType);
        assertEquals(2, spotslinesResult.size());
        assertEquals(2, manager.getTotalFreeSpotsByType().get(SpotType.MOTORCYCLE_TYPE));
        manager.parkVehicleInFloorSpot(VehiclesType.CAR);
        assertEquals(true, (manager.getTotalFreeSpotsByType().get(SpotType.COMPACT_TYPE) < 2) || (manager.getTotalFreeSpotsByType().get(SpotType.LARGE_TYPE) < 2));
    }
}
