package com.thales.dis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager {
    public void generate(int numberOfFloorSteps, int numberOfSpotLinesPerFloor, Map<SpotType, Integer> numberSpotsByType) {
    }

    public Map<VehiclesType, Integer> getPossibleVehiclesCapacityByType() {
        Map<VehiclesType, Integer> mapVehicles = new HashMap<>();
        mapVehicles.put(VehiclesType.CAR, 2);
        mapVehicles.put(VehiclesType.MOTORCYCLE, 3);
        mapVehicles.put(VehiclesType.BUS, 0);
        return mapVehicles;
    }
}
