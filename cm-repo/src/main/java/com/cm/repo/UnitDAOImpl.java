package com.cm.repo;

import com.cm.common.repo.UnitDAO;
import com.cm.entity.Unit;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UnitDAOImpl implements UnitDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }


    @Override
    public Unit getUnit(Integer id) {
        return (Unit)getCurrentSession().get(Unit.class,id);
    }

    @Override
    public void addUnit(Unit unit) {
        getCurrentSession().save(unit);
    }

    @Override
    public void updateUnit(Unit unit) {
        getCurrentSession().update(unit);
    }

    @Override
    public void deleteUnit(Integer id) {
        Unit unit = getUnit(id);
        if( unit!= null){
            getCurrentSession().delete(unit);
        }

    }

    @Override
    public List<Unit> getAllUnits() {
        return getCurrentSession().createQuery("SELECT f FROM Unit f").list();
    }

    @Override
    public List<Unit> getUnits(Integer sayfaNo, Integer sayfaBasinaSayi ,String searching) {

        Query query;
        if(searching.equals("all"))
        {
            query = getCurrentSession().createSQLQuery("EXEC Unit_List   :sayfaNo , :sayfaBasinaSayi")
                    .addEntity(Unit.class)
                    .setInteger("sayfaNo",sayfaNo)
                    .setInteger("sayfaBasinaSayi",sayfaBasinaSayi);
        }
        else
        {
            query = getCurrentSession().createSQLQuery(
                    " EXEC Unit_List_Searched :Sayfano, :SayfabasinaSayi, :searchKey")
                    .addEntity(Unit.class)
                    .setInteger("Sayfano",sayfaNo)
                    .setInteger("SayfabasinaSayi",sayfaBasinaSayi)
                    .setParameter("searchKey",searching);
        }
        List<Unit> unitList = query.list();

        return unitList;
    }

    @Override
    public long unitCount() {
        return ((Long)getCurrentSession().createQuery("select count(*) from Unit ").uniqueResult()).longValue();

    }

    @Override
    public long unitListSearchedCount(String searching) {
        long sayi;
        System.out.println("searching budur : "+searching);
        if(searching.equals("all"))
        {
            sayi=unitCount();
        }
        else
        {
            try{
                System.out.println(Integer.parseInt(searching));
                sayi=((Long)getCurrentSession().createQuery("SELECT count(*) from Unit u where u.unitNo = ? or u.floorByFloorId.floorNo = ?")
                        .setInteger(0,Integer.parseInt(searching))
                        .setInteger(1,Integer.parseInt(searching)).uniqueResult()).longValue();
            }
            catch(Exception e) {
                e.printStackTrace();
                System.out.println("Integer bir değer girmediniz");
                sayi=((Long)getCurrentSession().createQuery("SELECT count(*) from Unit u where u.memberByMemberId.name LIKE ? or u.unitTypeByUnitTypeId.unitType LIKE ?")
                        .setParameter(0,"%"+searching+"%")
                        .setParameter(1,"%"+searching+"%").uniqueResult()).longValue();
            }
        }

        return sayi;
    }


}
