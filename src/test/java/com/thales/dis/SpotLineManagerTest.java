package com.thales.dis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class SpotLineManagerTest {
    @Test
    void generateListOfSpotWithDifferentTypes() {
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        SpotLineManager manager = new SpotLineManager(numberSpotsByType);
        assertEquals("THERE ARE:\n"
        		+ "3 SPOTS FOR MOTOS\n"
        		+ "2 SPOTS FOR CARS\n"
        		+ "0 SPOTS FOR BUSES", manager.getVehiclesPossibility”ccupation().toString());

    }
    
    @Test
    void parkingCarInSpotLine() {
        Map<SpotType, Integer> numberSpotsByType = new HashMap<>();
        numberSpotsByType.put(SpotType.MOTORCYCLE_TYPE, 1);
        numberSpotsByType.put(SpotType.COMPACT_TYPE, 1);
        numberSpotsByType.put(SpotType.LARGE_TYPE, 1);
        SpotLineManager manager = new SpotLineManager(numberSpotsByType);
        assertEquals(true, manager.parkVehicleInSpotLine(VehiclesType.CAR));
        assertEquals("THERE ARE:\n"
        		+ "2 SPOTS FOR MOTOS\n"
        		+ "1 SPOT FOR CARS\n"
        		+ "0 SPOTS FOR BUSES", manager.getVehiclesPossibility”ccupation().toString());

    }

}
