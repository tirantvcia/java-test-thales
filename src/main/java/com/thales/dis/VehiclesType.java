package com.thales.dis;

public enum VehiclesType {
    MOTORCYCLE("M"),
    CAR("C"),
    BUS("B");

    public String getType() {
        return type;
    }

    private final String type;

    private VehiclesType(String type) {
        this.type = type;
    }
    public static VehiclesType valueOfType(String type) {
        for(VehiclesType v: values()) {
            if(v.type.equals(type)) {
                return v;
            }
        }
        return null;
    }

}