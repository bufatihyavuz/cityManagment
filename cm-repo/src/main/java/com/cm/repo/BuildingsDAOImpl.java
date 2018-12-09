package com.cm.repo;

import com.cm.common.repo.BuildingsDAO;
import com.cm.entity.Buildings;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuildingsDAOImpl implements BuildingsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession(){ return sessionFactory.getCurrentSession();}


    @Override
    public void addBuildings(Buildings buildings) {
        getCurrentSession().save(buildings);
    }

    @Override
    public void updateBuildings(Buildings buildings) {
        getCurrentSession().update(buildings);
    }

    @Override
    public void deleteBuildings(int id) {
        Buildings buildings = getBuildings(id);
        if(buildings!=null){
            getCurrentSession().delete(buildings);
        }
    }

    @Override
    public Buildings getBuildings(int id) {
        return (Buildings)getCurrentSession().get(Buildings.class,id);
    }

    @Override
    public List<Buildings> getAllBuildingss() {
        return getCurrentSession().createQuery("SELECT b FROM Buildings b").list();
    }

    @Override
    public List<Buildings> getBuildingss(Integer sayfaNo, Integer sayfaBasinaSayi) {

        Query query;
        query = getCurrentSession().createSQLQuery("EXEC Buildings_List :sayfaNo ,:sayfaBasinaSayi")
                 .addEntity(Buildings.class)
                 .setInteger("sayfaNo",sayfaNo)
                 .setInteger("sayfaBasinaSayi",sayfaBasinaSayi);
        List<Buildings> buildingsList = query.list();
        return  buildingsList;
    }

    @Override
    public int getbuildingsCount() {
        return ((Integer)getCurrentSession().createSQLQuery("SELECT COUNT (*) FROM Buildings").uniqueResult()).intValue();
    }


}
