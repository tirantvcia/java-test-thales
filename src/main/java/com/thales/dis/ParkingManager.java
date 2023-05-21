package com.thales.dis;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public class ParkingManager {

    ArrayList<SpotFloorManager> spotFloors = null;

    public void generate(int numberOfFloorSteps, int numberOfSpotLinesPerFloor, Map<SpotType, Integer> numberSpotsByType) {
        reset();
        for(int i = 0; i < numberOfFloorSteps; i++) {
            addSpotFloor(numberOfSpotLinesPerFloor, numberSpotsByType);
        }
    }

    private void reset() {
        spotFloors = new ArrayList<>();
    }

    private void addSpotFloor(int numberOfSpotLinesPerFloor, Map<SpotType, Integer> numberSpotsByType) {
        SpotFloorManager spotFloorManager = new SpotFloorManager();
        spotFloorManager.generate(numberOfSpotLinesPerFloor, numberSpotsByType);
        spotFloors.add(spotFloorManager);
    }

    public VehiclesCapacityInFreeSpots getPossibleVehiclesCapacityByType() {
        Optional<VehiclesCapacityInFreeSpots> optionalVehiclesCapacityInFreeSpots = spotFloors.stream().map(sp -> sp.getPossibleVehiclesCapacityByType()).reduce((a, b) -> a.append(b));
        if(optionalVehiclesCapacityInFreeSpots.isPresent()) {
            VehiclesCapacityInFreeSpots vehicles =  optionalVehiclesCapacityInFreeSpots.get();
            return vehicles;
        }
        return null;
    }

    public boolean parkVehicle(VehiclesType vehiclesType) {
        Optional<SpotFloorManager> vehicleIsCorrectlyParked = getTheFirstOneSpotLinesWhereVehicleIsParked(vehiclesType);
        return vehicleIsCorrectlyParked.isPresent();
    }

    private Optional<SpotFloorManager> getTheFirstOneSpotLinesWhereVehicleIsParked(VehiclesType vehiclesType) {
        SpotFloorManager managerWhereVehicleIsParked = null;
        for(SpotFloorManager manager:spotFloors) {
            if(manager.parkVehicleInFloorSpot(vehiclesType)) {
                managerWhereVehicleIsParked = manager;
                break;
            }
        }
        return Optional.ofNullable(managerWhereVehicleIsParked);
    }
}
