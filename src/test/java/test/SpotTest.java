package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpotTest {
    @Test
    void createSingleMotorCycleSpot() {
        Spot motorcycleSpot = Spot.create("M");
        SpotType typeSpot = motorcycleSpot.getType();
        assertEquals("M", typeSpot.getType());
    }

    @Test
    void nullSingleSpotWithLetterNotPermites() {
        Spot motorcycleSpot = Spot.create("d");
        assertEquals(null, motorcycleSpot);
    }
    @Test
    void createSeveralSpotsOfDiferentsTypes() {
        String motorcycleSpotType = "M";
        assertEquals("M", Spot.create(motorcycleSpotType).getType().getType());
        String compactSpotType = "C";
        assertEquals("C", Spot.create(compactSpotType).getType().getType());
        String largeSpotType = "L";
        assertEquals("L", Spot.create(largeSpotType).getType().getType());
    }


}
