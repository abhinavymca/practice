package com.practice.dsa.lld.parkinglot.vehicletype;

import java.util.Objects;

public abstract class Vehicle {

    protected String regNo;
    protected VehicleType vehicleType;

    public Vehicle(String regNo, VehicleType vehicleType) {
        this.regNo = regNo;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getRegNo(){
        return regNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(getRegNo(), vehicle.getRegNo()) && getVehicleType() == vehicle.getVehicleType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegNo(), getVehicleType());
    }
}
