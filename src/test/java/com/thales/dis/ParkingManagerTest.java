package com.thales.dis;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingManagerTest {
    @Test
    void generationOfMostSimpleParkingIndicatedInMap() {
        ParkingManager manager = new ParkingManager();
        int numberOfSpotLinesPerFloor = 1;
        int numberOfFloorSteps = 1;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        manager.generate(numberOfFloorSteps, numberOfSpotLinesPerFloor, numberSpotsByType);
        assertEquals(3, manager.getPossibleVehiclesCapacityByType().get(VehiclesType.MOTORCYCLE));
        assertEquals(2, manager.getPossibleVehiclesCapacityByType().get(VehiclesType.CAR));
        assertEquals(0, manager.getPossibleVehiclesCapacityByType().get(VehiclesType.BUS));
    }
    @Test
    void generationOfParkingWithTwoFloorIndicatedInMap() {
        ParkingManager manager = new ParkingManager();
        int numberOfSpotLinesPerFloor = 1;
        int numberOfFloorSteps = 2;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        manager.generate(numberOfFloorSteps, numberOfSpotLinesPerFloor, numberSpotsByType);
        assertEquals(6, manager.getPossibleVehiclesCapacityByType().get(VehiclesType.MOTORCYCLE));
        assertEquals(4, manager.getPossibleVehiclesCapacityByType().get(VehiclesType.CAR));
        assertEquals(0, manager.getPossibleVehiclesCapacityByType().get(VehiclesType.BUS));
    }
    @Test
    void generationOfParkingWithTwoFloorTwoLinesIndicatedInMap() {
        ParkingManager manager = new ParkingManager();
        int numberOfSpotLinesPerFloor = 2;
        int numberOfFloorSteps = 2;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        manager.generate(numberOfFloorSteps, numberOfSpotLinesPerFloor, numberSpotsByType);
        assertEquals(12, manager.getPossibleVehiclesCapacityByType().get(VehiclesType.MOTORCYCLE));
        assertEquals(8, manager.getPossibleVehiclesCapacityByType().get(VehiclesType.CAR));
        assertEquals(0, manager.getPossibleVehiclesCapacityByType().get(VehiclesType.BUS));
    }

    @Test
    void ParkingOneMotoInParkingManager() {
        ParkingManager manager = new ParkingManager();
        int numberOfSpotLinesPerFloor = 2;
        int numberOfFloorSteps = 2;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        manager.generate(numberOfFloorSteps, numberOfSpotLinesPerFloor, numberSpotsByType);
        assertEquals(true, manager.parkVehicle(VehiclesType.MOTORCYCLE));
        assertEquals(11, manager.getPossibleVehiclesCapacityByType().get(VehiclesType.MOTORCYCLE));
    }
}
