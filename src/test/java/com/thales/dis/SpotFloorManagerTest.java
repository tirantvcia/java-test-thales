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
    
    
}
