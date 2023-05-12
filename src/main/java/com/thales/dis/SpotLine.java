package com.thales.dis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SpotLine {
    public static final int NUMBER_OF_PLACES_FOR_BUSES = 5;
    public static final int NUMBER_OF_PLACES_FOR_MOTO_OR_CAR = 1;
    private List<Spot> rows;

    public SpotLine(List<Spot> rows) {
        this.rows = rows;
    }

    public SpotLine() {
        this.rows = new ArrayList<>();
    }

    public void reset () {
        rows = new ArrayList<>();
    }

    public List<Spot> generate (Map<SpotType, Integer> spotDitributionByType) {
    	reset();
        spotDitributionByType.forEach((type, numElments) ->  generateRowsOfSameType(type, numElments));
        return rows;
    }

    private List<Spot> generateRowsOfSameType(SpotType spotType, int numberOfRows) {

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

    public boolean parkVehicleInSpotLine(VehiclesType vehicle) {
        int position = 0;
        boolean vehicleIsParked = false;
        do {
            vehicleIsParked = parkVehicle(position, vehicle);
            if(!vehicleIsParked) {
                position ++;
            }
        } while(!vehicleIsParked && position < rows.size());

        return vehicleIsParked;
    }



    public List<Spot> getRows() {
        return rows;
    }

    public void setRows(List<Spot> rows) {
        this.rows = rows;
    }

}
