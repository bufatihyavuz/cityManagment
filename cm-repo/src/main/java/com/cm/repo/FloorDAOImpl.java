package com.cm.repo;

import com.cm.common.repo.FloorDAO;
import com.cm.entity.Floor;
import com.cm.entity.Unit;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FloorDAOImpl implements FloorDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void addFloor(Floor floor) {
        getCurrentSession().save(floor);
    }

    @Override
    public void updateFloor(Floor floor) {
        getCurrentSession().update(floor);
    }

    @Override
    public void deleteFloor(Integer id) {
        Floor floor = getFloor(id);
        if(floor!=null){
            getCurrentSession().update(floor);
        }
    }

    @Override
    public Floor getFloor(int id) {
        return (Floor)getCurrentSession().get(Floor.class,id);
    }

    @Override
    public List<Floor> getAllFloors() {
        return getCurrentSession().createQuery("SELECT f FROM Floor f").list();
    }

    @Override
    public List<Floor> getFloors(Integer sayfaNo, Integer sayfaBasinaSayi) {

        Query query = getCurrentSession().createSQLQuery("EXEC Floor_List  :sayfaNo , :sayfaBasinaSayi")
                .addEntity(Floor.class)
                .setInteger("sayfaNo",sayfaNo)
                .setInteger("sayfaBasinaSayi",sayfaBasinaSayi);
        List<Floor> queryList = query.list();
        return queryList;
    }

    @Override
    public List<Floor> getUnitFloors(Integer id) {
        Query query =  getCurrentSession().createSQLQuery("EXEC getUnitFloors :unitId")
                .addEntity(Floor.class)
                .setInteger("unitId",id);
        List<Floor> floorList =  query.list();
        return floorList;
    }

    @Override
    public List<Floor> getSelectedApartmentFloornos(Integer id) {
        List<Floor> selectedFloorNoList = getCurrentSession().createSQLQuery("EXEC getSelectedFloorList :id")
                .setInteger("id",id).list();
        return selectedFloorNoList;
    }
}
