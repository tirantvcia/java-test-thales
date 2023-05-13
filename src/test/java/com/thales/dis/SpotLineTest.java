package com.thales.dis;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpotLineTest {

    @Test
    void motorCyleCanParkInAnyTypeOfSpot() {
        VehiclesType moto = VehiclesType.MOTORCYCLE;
        SpotLine manager = new SpotLine();
        int numberOfRows = 1;
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, numberOfRows);
        manager.generate(numberSpotsByType);
        assertEquals(true, manager.parkVehicle(0, moto));

        numberSpotsByType.clear();
        numberSpotsByType.put(SpotType.LARGE_TYPE, numberOfRows);
        manager.generate(numberSpotsByType);
        assertEquals(true, manager.parkVehicle(0, moto));

        numberSpotsByType.clear();
        numberSpotsByType.put(SpotType.COMPACT_TYPE, numberOfRows);
        manager.generate(numberSpotsByType);
        assertEquals(true, manager.parkVehicle(0, moto));
    }

    @Test
    void carOnlyCanParkInLargeAndCompactTypeOfSpot() {
    	Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        VehiclesType car = VehiclesType.CAR;
        int numberOfRows = 1;
        SpotLine manager = new SpotLine();

        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, numberOfRows);
        manager.generate(numberSpotsByType);
        assertEquals(false, manager.parkVehicle(0, car));

        numberSpotsByType.clear();
        numberSpotsByType.put(SpotType.LARGE_TYPE, numberOfRows);
        manager.generate(numberSpotsByType);
        assertEquals(true, manager.parkVehicle(0, car));
        
        numberSpotsByType.clear();
        numberSpotsByType.put(SpotType.COMPACT_TYPE, numberOfRows);
        manager.generate(numberSpotsByType);
        assertEquals(true, manager.parkVehicle(0, car));

    }

    @Test
    void generateLineOfFiveRowsToParkOnlyOneBus() {
    	Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        int numberRows = 5;
        SpotLine manager = new SpotLine();
        VehiclesType bus = VehiclesType.BUS;
        numberSpotsByType.clear();
        numberSpotsByType.put(SpotType.LARGE_TYPE, numberRows);
        manager.generate(numberSpotsByType);
        assertEquals(true, manager.parkVehicle(0, bus));

    }
    @Test
    void generateLineRowsWhereCantParkBus() {
    	Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        SpotLine manager = new SpotLine();
        VehiclesType bus = VehiclesType.BUS;
        int numberOfRows = 4;
        
        numberSpotsByType.clear();
        numberSpotsByType.put(SpotType.LARGE_TYPE, numberOfRows);
        manager.generate(numberSpotsByType);
        assertEquals(false, manager.parkVehicle(0, bus));

        
        numberSpotsByType.clear();
        numberSpotsByType.put(SpotType.COMPACT_TYPE, numberOfRows);
        manager.generate(numberSpotsByType);
        assertEquals(false, manager.parkVehicle(0, bus));
    }
    @Test
    void parkMotorCyleInSpot() {
    	Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        VehiclesType moto = VehiclesType.MOTORCYCLE;
        SpotLine manager = new SpotLine();
        int numberOfRows = 1;
        int position = 0;
        numberSpotsByType.clear();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, numberOfRows);
        manager.generate(numberSpotsByType);
        assertEquals(true, manager.parkVehicle(position, moto));
        assertEquals(false, manager.parkVehicle(position, moto));
    }
    @Test
    void parkCarInSpot() {
    	Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        VehiclesType car = VehiclesType.CAR;
        SpotLine manager = new SpotLine();
        int numberOfRows = 1;
        int position = 0;
        numberSpotsByType.clear();
        numberSpotsByType.put(SpotType.COMPACT_TYPE, numberOfRows);
        manager.generate(numberSpotsByType);
        assertEquals(true, manager.parkVehicle(position, car));
        assertEquals(false, manager.parkVehicle(position, car));
    }

    @Test
    void parkBusInSpot() {
    	Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        VehiclesType bus = VehiclesType.BUS;
        SpotLine manager = new SpotLine();
        int numberOfRows = 6;
        int position = 0;
        numberSpotsByType.clear();
        numberSpotsByType.put(SpotType.LARGE_TYPE, numberOfRows);
        manager.generate(numberSpotsByType);
        assertEquals(true, manager.parkVehicle(position, bus));
        assertEquals(false, manager.parkVehicle(position, bus));
    }

    @Test
    void generateListOfSpotWithDifferentTypes() {
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        SpotLine manager = new SpotLine();
        List<Spot> spotslistResult = manager.generate(numberSpotsByType);
        assertEquals(3, spotslistResult.size());
//        manager.getNumberFreeSpotyByType().values().stream().forEach(
//                numberOfSpots -> assertEquals(1, numberOfSpots)
//        );
    }

    @Test
    void parkingCarInSpotLine() {
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        SpotLine manager = new SpotLine();
        List<Spot> spotslistResult = manager.generate(numberSpotsByType);
        assertEquals(3, spotslistResult.size());
        assertEquals(true, manager.parkVehicleInSpotLine(VehiclesType.CAR).isRight());
//        assertEquals(true, manager.getNumberFreeSpotyByType().get(SpotType.COMPACT_TYPE) == 0
//        || manager.getNumberFreeSpotyByType().get(SpotType.LARGE_TYPE) == 0);

    }

    @Test
    void parkingTwoCarsInSpotLine() {
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        SpotLine manager = new SpotLine();
        List<Spot> spotslistResult = manager.generate(numberSpotsByType);
        assertEquals(3, spotslistResult.size());
        assertEquals(true, manager.parkVehicleInSpotLine(VehiclesType.CAR).isRight());
        assertEquals(true, manager.parkVehicleInSpotLine(VehiclesType.CAR).isRight());
//        assertEquals(true, manager.getNumberFreeSpotyByType().get(SpotType.COMPACT_TYPE) == 0
//                && manager.getNumberFreeSpotyByType().get(SpotType.LARGE_TYPE) == 0);

    }
    @Test
    void parkingMoreCarsThanPermittedInSpotLine() {
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        SpotLine manager = new SpotLine();
        List<Spot> spotslistResult = manager.generate(numberSpotsByType);
        assertEquals(3, spotslistResult.size());
        assertEquals(true, manager.parkVehicleInSpotLine(VehiclesType.CAR).isRight());
        assertEquals(true, manager.parkVehicleInSpotLine(VehiclesType.CAR).isRight());
        assertEquals(false, manager.parkVehicleInSpotLine(VehiclesType.CAR).isRight());

    }

    @Test
    void parkingBusInSpotLine() {
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.LARGE_TYPE, 5);
        SpotLine manager = new SpotLine();
        List<Spot> spotslistResult = manager.generate(numberSpotsByType);
        assertEquals(5, spotslistResult.size());
        assertEquals(true, manager.parkVehicleInSpotLine(VehiclesType.BUS).isRight());
//        assertEquals(true, manager.getNumberFreeSpotyByType().get(SpotType.LARGE_TYPE) == 0);


    }

}
