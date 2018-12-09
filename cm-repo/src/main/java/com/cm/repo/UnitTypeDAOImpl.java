package com.cm.repo;

import com.cm.common.repo.UnitTypeDAO;
import com.cm.entity.UnitType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UnitTypeDAOImpl implements UnitTypeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession(){
        return (Session)sessionFactory.getCurrentSession();
    }

    @Override
    public UnitType getUnitType(Integer id) {
        return null;
    }

    @Override
    public void addUnitType(UnitType unitType) {

    }

    @Override
    public void updateUnitType(UnitType unit) {

    }

    @Override
    public void deleteUnitType(Integer id) {

    }

    @Override
    public List<UnitType> getAllUnitTypes() {
        List<UnitType> unitTypeList = getCurrentSession().createSQLQuery("SELECT * from UnitType ").list();
        return unitTypeList;
    }

    @Override
    public List<UnitType> getUnitTypes(Integer sayfaNo, Integer sayfaBasinaSayi) {
        return null;
    }
}
