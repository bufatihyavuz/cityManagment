package com.cm.repo;

import com.cm.common.repo.VehicleDAO;
import com.cm.entity.Vehicle;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleDAOImpl implements VehicleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() { return sessionFactory.getCurrentSession(); }

    @Override
    public void addVehicle(Vehicle vehicle) { getCurrentSession().save(vehicle);

    }

    @Override
    public void updateVehicle(Vehicle vehicle) { getCurrentSession().update(vehicle);

    }

    @Override
    public void deleteVehicle(int id) {
        Vehicle vehicle = getVehicle(id);
        if( vehicle!= null){
            getCurrentSession().delete(vehicle);
        }

    }

    @Override
    public Vehicle getVehicle(int id) {
        return (Vehicle) getCurrentSession().get(Vehicle.class, id);
    }

    @Override
    public List<Vehicle> getVehicles(Integer sayfaNo, Integer sayfaBasinaSayi) {

        Query query;
        query = getCurrentSession().createSQLQuery("EXEC Vehicle_List :sayfaNo , :sayfaBasinaSayi")
                .addEntity(Vehicle.class)
                .setInteger("sayfaNo" ,sayfaNo)
                .setInteger("sayfaBasinaSayi" ,sayfaBasinaSayi);
        List<Vehicle> vehicleList = query.list();
        return vehicleList;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
      return   getCurrentSession().createQuery("SELECT v FROM Vehicle v").list();
    }
}
