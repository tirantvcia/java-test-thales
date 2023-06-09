package com.thales.dis;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
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
        assertEquals(3, manager.getPossibleVehiclesCapacityByType().getVehicles().get(VehiclesType.MOTORCYCLE));
        assertEquals(2, manager.getPossibleVehiclesCapacityByType().getVehicles().get(VehiclesType.CAR));
        assertEquals(0, manager.getPossibleVehiclesCapacityByType().getVehicles().get(VehiclesType.BUS));
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
        assertEquals(6, manager.getPossibleVehiclesCapacityByType().getVehicles().get(VehiclesType.MOTORCYCLE));
        assertEquals(4, manager.getPossibleVehiclesCapacityByType().getVehicles().get(VehiclesType.CAR));
        assertEquals(0, manager.getPossibleVehiclesCapacityByType().getVehicles().get(VehiclesType.BUS));
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
        assertEquals(12, manager.getPossibleVehiclesCapacityByType().getVehicles().get(VehiclesType.MOTORCYCLE));
        assertEquals(8, manager.getPossibleVehiclesCapacityByType().getVehicles().get(VehiclesType.CAR));
        assertEquals(0, manager.getPossibleVehiclesCapacityByType().getVehicles().get(VehiclesType.BUS));
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
        assertEquals(11, manager.getPossibleVehiclesCapacityByType().getVehicles().get(VehiclesType.MOTORCYCLE));
    }
    @Test
    void ParkingTwoBusesAndTwoCarsIsPermittedInGeneratedLines() {
        ParkingManager manager = new ParkingManager();
        int numberOfSpotLinesPerFloor = 1;
        int numberOfFloorSteps = 2;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 5);
        manager.generate(numberOfFloorSteps, numberOfSpotLinesPerFloor, numberSpotsByType);
        assertEquals(true, manager.parkVehicle(VehiclesType.BUS));
        assertEquals(true, manager.parkVehicle(VehiclesType.BUS));
        assertEquals(false, manager.parkVehicle(VehiclesType.BUS));
        assertEquals(true, manager.parkVehicle(VehiclesType.CAR));
        assertEquals(true, manager.parkVehicle(VehiclesType.CAR));
    }
    @Test
    void ParkingFourBusesIsPermittedInGeneratedLines() {
        ParkingManager manager = new ParkingManager();
        int numberOfSpotLinesPerFloor = 2;
        int numberOfFloorSteps = 2;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 5);
        manager.generate(numberOfFloorSteps, numberOfSpotLinesPerFloor, numberSpotsByType);
        assertEquals(true, manager.parkVehicle(VehiclesType.BUS));
        assertEquals(true, manager.parkVehicle(VehiclesType.BUS));
        assertEquals(true, manager.parkVehicle(VehiclesType.BUS));
        assertEquals(true, manager.parkVehicle(VehiclesType.BUS));
        assertEquals(false, manager.parkVehicle(VehiclesType.BUS));
    }
    @Test
    void ParkingFull() {
        ParkingManager manager = new ParkingManager();
        int numberOfSpotLinesPerFloor = 2;
        int numberOfFloorSteps = 2;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 5);
        manager.generate(numberOfFloorSteps, numberOfSpotLinesPerFloor, numberSpotsByType);
        assertEquals(true, manager.parkVehicle(VehiclesType.BUS));
        assertEquals(true, manager.parkVehicle(VehiclesType.BUS));
        assertEquals(true, manager.parkVehicle(VehiclesType.BUS));
        assertEquals(true, manager.parkVehicle(VehiclesType.BUS));
        assertEquals(false, manager.parkVehicle(VehiclesType.BUS));
        assertEquals(true, manager.parkVehicle(VehiclesType.CAR));
        assertEquals(true, manager.parkVehicle(VehiclesType.CAR));
        assertEquals(true, manager.parkVehicle(VehiclesType.CAR));
        assertEquals(true, manager.parkVehicle(VehiclesType.CAR));
        assertEquals(false, manager.parkVehicle(VehiclesType.CAR));
        assertEquals(true, manager.parkVehicle(VehiclesType.MOTORCYCLE));
        assertEquals(true, manager.parkVehicle(VehiclesType.MOTORCYCLE));
        assertEquals(true, manager.parkVehicle(VehiclesType.MOTORCYCLE));
        assertEquals(true, manager.parkVehicle(VehiclesType.MOTORCYCLE));
        assertEquals(false, manager.parkVehicle(VehiclesType.MOTORCYCLE));
        assertEquals("THERE ARE:\n"
                + "0 SPOTS FOR MOTOS\n"
                + "0 SPOTS FOR CARS\n"
                + "0 SPOTS FOR BUSES", manager.getPossibleVehiclesCapacityByType().toString());

    }
}
