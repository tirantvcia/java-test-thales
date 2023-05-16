package com.thales.dis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class SpotFloorManagerTest {
    @Test
    void generationOfParkingFloorWithSeveralSpotLineWithSameDistributionIndicatedInMap() {
        SpotFloorManager manager = new SpotFloorManager();
        int numberOfSpotLines = 3;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        manager.generate(numberOfSpotLines, numberSpotsByType);
    }
    
    @Test
    void ParkingOneMotosIsPermittedInGeneratedLines() {
        SpotFloorManager manager = new SpotFloorManager();
        int numberOfSpotLines = 2;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 0);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 0);
        manager.generate(numberOfSpotLines, numberSpotsByType);
        assertEquals(true, manager.parkVehicleInFloorSpot(VehiclesType.MOTORCYCLE));
        assertEquals(false, manager.parkVehicleInFloorSpot(VehiclesType.CAR));
         
    }
    
    @Test
    void ParkingOnlyTwoBusesIsPermittedInGeneratedLines() {
        SpotFloorManager manager = new SpotFloorManager();
        int numberOfSpotLines = 2;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 5);
        manager.generate(numberOfSpotLines, numberSpotsByType);
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
        manager.generate(numberOfSpotLines, numberSpotsByType);
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
        manager.generate(numberOfSpotLines, numberSpotsByType);
        assertEquals(6, manager.getPossibleVehiclesCapacityByType().get(VehiclesType.MOTORCYCLE));
        assertEquals(4, manager.getPossibleVehiclesCapacityByType().get(VehiclesType.CAR));
        assertEquals(0, manager.getPossibleVehiclesCapacityByType().get(VehiclesType.BUS));
    }
    
    @Test
    void UpdateParkingFloorInformationWhenParkOneCar() {
        SpotFloorManager manager = new SpotFloorManager();
        int numberOfSpotLines = 2;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        manager.generate(numberOfSpotLines, numberSpotsByType);
        assertEquals(6, manager.getPossibleVehiclesCapacityByType().get(VehiclesType.MOTORCYCLE));
        assertEquals(4, manager.getPossibleVehiclesCapacityByType().get(VehiclesType.CAR));
        boolean parkVehicleInFloorSpot = manager.parkVehicleInFloorSpot(VehiclesType.CAR);
        assertEquals(true, parkVehicleInFloorSpot);
        assertEquals(3, manager.getPossibleVehiclesCapacityByType().get(VehiclesType.CAR));
    }
}
