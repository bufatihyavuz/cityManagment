package com.cm.business;


import com.cm.common.business.VehicleService;
import com.cm.common.repo.VehicleDAO;
import com.cm.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleDAO vehicleDAO;

    @Override
    public void addVehicle(Vehicle vehicle) { vehicleDAO.addVehicle(vehicle);

    }

    @Override
    public void updateVehicle(Vehicle vehicle) { vehicleDAO.updateVehicle(vehicle);
    }

    @Override
    public void deleteVehicle(int id) { vehicleDAO.deleteVehicle(id);

    }

    @Override
    public Vehicle getVehicle(int id) {
        return vehicleDAO.getVehicle(id);
    }

    @Override
    public List<Vehicle> getVehicles(Integer sayfaNo, Integer sayfaBasinaSayi) {
        return vehicleDAO.getVehicles(sayfaNo, sayfaBasinaSayi);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.getAllVehicles();
    }
}
