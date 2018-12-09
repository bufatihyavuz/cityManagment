package com.cm.common.business;

import com.cm.entity.Vehicle;

import java.util.List;

public interface VehicleService {


    public void addVehicle(Vehicle vehicle);
    public void updateVehicle(Vehicle vehicle);
    public void deleteVehicle(int id);
    public Vehicle getVehicle(int id);
    public List<Vehicle> getVehicles(Integer sayfaNo, Integer sayfaBasinaSayi);
    public List<Vehicle> getAllVehicles();

}
