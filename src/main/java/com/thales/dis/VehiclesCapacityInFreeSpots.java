package com.thales.dis;

public class VehiclesCapacityInFreeSpots {
	public static final int NUMBER_OF_PLACES_FOR_BUSES = 5;
	public static final int NUMBER_OF_PLACES_FOR_MOTO_OR_CAR = 1;

	public int cars;
	public int motos;
	public int buses;

	public VehiclesCapacityInFreeSpots() {
		this.cars = 0;
		this.motos = 0;
		this.buses = 0;
	}

	public void addVehiclesByFreeSpotType(SpotType type, Integer number) {

		switch (type) {
		case COMPACT_TYPE:
			addNumberToCarsAndMotos(number);
			break;
		case LARGE_TYPE:
			addNumberToAllVehicles(number);
			break;
		case MOTORCYCLE_TYPE:
			addNumberToMotos(number);
			break;
		}

	}

	private void addNumberToMotos(Integer number) {
		motos += number;
	}

	private void addNumberToAllVehicles(Integer number) {
		addNumberToCarsAndMotos(number);
		if (number >= NUMBER_OF_PLACES_FOR_BUSES) {
			buses += (number / NUMBER_OF_PLACES_FOR_BUSES);
		}
	}

	private void addNumberToCarsAndMotos(Integer number) {
		cars += number;
		addNumberToMotos(number);
	}

	@Override
	public String toString() {
		StringBuffer informationText = new StringBuffer("THERE ARE:\n");

		informationText.append(makeForMotoCycleInformation()).append(makeForCarInformation())
				.append(makeForBusInformation());

		return informationText.toString();

	}

	private String makeForBusInformation() {
		String moreThanOneSustantiveTermination = moreThanOneSustantiveTermination(buses);
		return String.format("%s SPOT%s FOR BUSES", buses, moreThanOneSustantiveTermination);
	}

	private String makeForCarInformation() {
		String moreThanOneSustantiveTermination = moreThanOneSustantiveTermination(cars);
		return String.format("%s SPOT%s FOR CARS\n", cars, moreThanOneSustantiveTermination);
	}

	private String makeForMotoCycleInformation() {
		String moreThanOneSustantiveTermination = moreThanOneSustantiveTermination(motos);
		return String.format("%s SPOT%s FOR MOTOS\n", motos, moreThanOneSustantiveTermination);

	}

	private String moreThanOneSustantiveTermination(int numberOfPlacesForMotoOrCar) {
		return numberOfPlacesForMotoOrCar > 1 || numberOfPlacesForMotoOrCar == 0 ? "S" : "";
	}

}