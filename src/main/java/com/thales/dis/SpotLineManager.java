package com.thales.dis;

import java.util.List;
import java.util.Map;

import io.vavr.control.Either;

public class SpotLineManager {

	private SpotLine spotLine;
	private SpotLineInformation vehiclesCapacityInfo;
	
	
	
	
	public SpotLineManager() {
		spotLine = new SpotLine();
		vehiclesCapacityInfo = new SpotLineInformation();
	}
	

	public SpotLineManager(Map<SpotType, Integer> numberSpotsByType) {
		vehiclesCapacityInfo = new SpotLineInformation(numberSpotsByType);
		spotLine = new SpotLine(numberSpotsByType);
	}



	public SpotLine getSpotLine() {
		return spotLine;
	}


	public void setSpotLine(SpotLine spotLine) {
		this.spotLine = spotLine;
	}


	public SpotLineInformation getVehiclesCapacityInfo() {
		return vehiclesCapacityInfo;
	}


	public void setVehiclesCapacityInfo(SpotLineInformation vehiclesCapacityInfo) {
		this.vehiclesCapacityInfo = vehiclesCapacityInfo;
	}


	public boolean parkVehicleInSpotLine(VehiclesType vehicle) {
		Either<Boolean, Spot> parkVehicleInSpotLineResult = spotLine.parkVehicleInSpotLine(vehicle);
		if(parkVehicleInSpotLineResult.isLeft()){
			return false;
		}
		
		Spot spot = parkVehicleInSpotLineResult.get();
		vehiclesCapacityInfo.updateNumberOfFreePositions(spot, vehicle);
		return true;
	}


	public VehiclesCapacityInFreeSpots getVehiclesPossibility”ccupation() {
		return getVehiclesCapacityInfo().getVehiclesPossibility”ccupation();
	}



}
