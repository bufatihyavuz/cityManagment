package com.cm.repo;

import com.cm.common.repo.ApartmentDAO;
import com.cm.entity.Apartment;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ApartmentDAOImpl implements ApartmentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    private List<Apartment> apartmentList = new ArrayList<Apartment>();



    @Override
    public long apartmentCount() {
        return ((Long)getCurrentSession().createQuery("select count(*) from Apartment ").uniqueResult()).longValue();
    }

    @Override
    public void addApartment(Apartment apartment) {
        getCurrentSession().save(apartment);
    }

    @Override
    public void updateApartment(Apartment apartment) {
        getCurrentSession().update(apartment);
    }

    @Override
    public void deleteApartment(Integer id) {
        Apartment apartment = getApartment(id);
        if(apartment!=null) {
            getCurrentSession().delete(apartment);
        }
    }

    @Override
    public Apartment getApartment(int id) {
        return (Apartment)getCurrentSession().get(Apartment.class,id);
    }

    @Override
    public List<Apartment> getAllApartments() {
        return getCurrentSession().createQuery("SELECT a FROM Apartment a").list();
    }

    @Override
    public List<Apartment> getApartments(Integer sayfaNo, Integer sayfaBasinaSayi) {
        Query query;
        query = getCurrentSession().createSQLQuery("EXEC Apartment_List :sayfaNo , :sayfaBasinaSayi")
                .addEntity(Apartment.class)
                .setInteger("sayfaNo",sayfaNo)
                .setInteger("sayfaBasinaSayi",sayfaBasinaSayi);
        apartmentList = query.list();
        return apartmentList;
    }

    @Override
    public List<Integer> getMaxFloorCountList() {
        List<Integer> maxFloorList = new ArrayList<Integer>() ;
        for (Apartment apartment:apartmentList)
        {
            Integer apId = apartment.getId();
            Integer maxFloor = ((Integer)getCurrentSession().createSQLQuery("EXEC getFloorNumber :apartmentId")
                    .setInteger("apartmentId",apId)
                    .uniqueResult())
                    .intValue();
            maxFloorList.add(maxFloor);
        }
        return maxFloorList;
    }

    @Override
    public void addFloor(Integer id) {
        // KatSayısını alıp 1 arttırma
        Integer maxFloor = ((Integer)getCurrentSession().createSQLQuery("EXEC getFloorNumber :apartmentId")
                .setInteger("apartmentId",id)
                .uniqueResult())
                .intValue();
        maxFloor++;
        //
                getCurrentSession().createSQLQuery("INSERT INTO Floor (apartmentId,floorNo) VALUES (:apartmentId , :floorNo)")
                .setInteger("apartmentId" , id)
                .setInteger("floorNo" , maxFloor)
                .executeUpdate();
    }

    @Override
    public void deleteFloor(Integer id) {
        //katsayısını al
        Integer maxFloor = ((Integer)getCurrentSession().createSQLQuery("EXEC getFloorNumber :apartmentId")
                .setInteger("apartmentId",id)
                .uniqueResult())
                .intValue();
        if(maxFloor > 1) {
            getCurrentSession().createSQLQuery("DELETE  FROM Floor WHERE apartmentId=:id and floorNo=:maxFloor")
                    .setInteger("id", id)
                    .setInteger("maxFloor", maxFloor)
                    .executeUpdate();
        }
    }

    @Override
    public List<Apartment> getSelectedBuildingsApartmentNos(Integer id) {
        List<Apartment> selectedApartmentNoList = getCurrentSession().createSQLQuery("EXEC getSelectedApartmentList :id")
                .setInteger("id",id).list();
        return selectedApartmentNoList;
    }

}
