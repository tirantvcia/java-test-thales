package com.thales.dis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SpotLineManager {
    public static final int NUMBER_OF_PLACES_FOR_BUSES = 5;
    public static final int NUMBER_OF_PLACES_FOR_MOTO_OR_CAR = 1;
    private List<Spot> rows;
    private Map<SpotType, Integer> numberFreeSpotyByType;

    public SpotLineManager(List<Spot> rows) {
        this.rows = rows;
    }

    public SpotLineManager() {
        this.rows = new ArrayList<>();
        this.numberFreeSpotyByType = null;
    }

    public void reset () {
        rows = new ArrayList<>();
        this.numberFreeSpotyByType = null;
    }

    public List<Spot> generate (Map<SpotType, Integer> spotDitributionByType) {
    	reset();
        spotDitributionByType.forEach((type, numElments) ->  generateRowsOfSameType(type, numElments));
        this.numberFreeSpotyByType = spotDitributionByType;
        return rows;
    }

    public List<Spot> generateRowsOfSameType(SpotType spotType, int numberOfRows) {

        for(int i = 0; i < numberOfRows; i++) {
            Spot spot = Spot.create(spotType.getType());
            this.rows.add(spot);
        }
        return rows;
    }

    public boolean couldParkBusFromThisPosition(int startPosition) {

        try {
            List<Spot> subListToParkBuses = rows.subList(startPosition, startPosition + NUMBER_OF_PLACES_FOR_BUSES);
            Optional<Spot> isThereAnySpotNotPermittedToBus = subListToParkBuses.stream().filter(spot -> {
                boolean isSpotNotPermittedToParkBus = !spot.getType().equals(SpotType.LARGE_TYPE);
                return isSpotNotPermittedToParkBus || !spot.isFree();
            }).findAny();
            return !isThereAnySpotNotPermittedToBus.isPresent();
        } catch (IndexOutOfBoundsException noMoreSpotsInLine) {
            return false;
        }


    }

    private boolean vehicleCanPark(int position, VehiclesType vehicle) {
        if(!rows.get(position).isFree()) {
            return false;
        }
        switch(vehicle) {
            case CAR:
                return couldParkCarInThisPosition(position);
            case MOTORCYCLE:
                return couldParkMotoInThisPosition(position);
            case BUS:
                return couldParkBusFromThisPosition(position);
            default:
                return false;
        }
    }

    private boolean couldParkMotoInThisPosition(int position) {
        return rows.get(position).getType().equals(SpotType.LARGE_TYPE) || rows.get(position).getType().equals(SpotType.MOTORCYCLE_TYPE) || rows.get(position).getType().equals(SpotType.COMPACT_TYPE);
    }

    private boolean couldParkCarInThisPosition(int position) {
        return rows.get(position).getType().equals(SpotType.LARGE_TYPE) || rows.get(position).getType().equals(SpotType.COMPACT_TYPE);
    }

    public boolean parkVehicle(int position, VehiclesType vehicle) {
        if(!vehicleCanPark( position, vehicle)) {
            return false;
        }
        if(vehicle.equals(VehiclesType.BUS)) {
            rows.subList(position, position + NUMBER_OF_PLACES_FOR_BUSES).forEach(spot -> spot.setFree(false));
        } else {
            rows.get(position).setFree(false);
        }
        return true;

    }

    public boolean parkVehicleInSpotLine(VehiclesType car) {
        int position = 0;
        boolean vehicleIsParked = false;
        do {
            vehicleIsParked = parkVehicle(position, car);
            if(!vehicleIsParked) {
                position ++;
            }
        } while(!vehicleIsParked && position < rows.size());

        if(vehicleIsParked) {
            updateNumberOfFreePositions(position, car);
            return true;
        }
        return false;
    }

    private void updateNumberOfFreePositions(int position, VehiclesType vehicle) {
        int numberOfPositionsToBeEngaged = (vehicle.equals(VehiclesType.BUS))?NUMBER_OF_PLACES_FOR_BUSES: NUMBER_OF_PLACES_FOR_MOTO_OR_CAR;
        Spot spot = rows.get(position);
        Integer elements = numberFreeSpotyByType.get(spot.getType());
        numberFreeSpotyByType.replace(spot.getType(), elements - numberOfPositionsToBeEngaged);
    }

    public List<Spot> getRows() {
        return rows;
    }

    public void setRows(List<Spot> rows) {
        this.rows = rows;
    }

    public Map<SpotType, Integer> getNumberFreeSpotyByType() {
        return numberFreeSpotyByType;
    }

    public void setNumberFreeSpotyByType(Map<SpotType, Integer> numberFreeSpotyByType) {
        this.numberFreeSpotyByType = numberFreeSpotyByType;
    }


}
