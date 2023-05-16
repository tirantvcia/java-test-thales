package com.thales.dis;

import java.util.Map;

import io.vavr.control.Either;

public class SpotLineManager {

	private SpotLine spotLine;
	private SpotLineInformation vehiclesCapacityInfo;
	
	
	
	
	public SpotLineManager() {
	}
	





	public SpotLineManager(SpotLine spotLine, SpotLineInformation vehiclesCapacityInfo) {
		super();
		this.spotLine = spotLine;
		this.vehiclesCapacityInfo = vehiclesCapacityInfo;
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






	public static Either<Object, SpotLineManager> create(SpotLine spotLine, SpotLineInformation spotLineInfo) {
		try {
			return Either.right(new SpotLineManager(spotLine, (SpotLineInformation) spotLineInfo.clone()));
		} catch (CloneNotSupportedException e) {
			return Either.left(null);
		}
	}



}
