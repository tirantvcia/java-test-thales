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


}
