package com.cm.repo;

import com.cm.common.repo.PhoneDAO;
import com.cm.entity.Member;
import com.cm.entity.Phone;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhoneDAOImpl implements PhoneDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void addPhone(Phone phone) {
        getCurrentSession().save(phone);
    }

    @Override
    public void updatePhone(Phone phone) {
        getCurrentSession().update(phone);
    }

    @Override
    public void deletePhone(int id) {
        Phone phone = getPhone(id);
        if(phone!= null){
            getCurrentSession().delete(phone);
        }

    }

    @Override
    public Phone getPhone(int id) {
        return (Phone)getCurrentSession().get(Phone.class,id);
    }

    @Override
    public List<Phone> getAllPhone() {
        return getCurrentSession().createSQLQuery("SELECT * FROM Phone").list();
    }

    // member id'si verilen telefonların numaralarını getirir. {"05325623652" , "05325623652"}
    @Override
    public List<String> getPhones(Integer memberId) {
        return getCurrentSession().createSQLQuery("EXEC  getPhonesByMember  :memberId")
                .setInteger("memberId",memberId).list();

    }

    @Override
    public List<Integer> getPhoneIdsByMemberId(Integer memberId) {
        return getCurrentSession().createSQLQuery("SELECT p.id FROM Phone p WHERE memberId=:memberId ")
                .setInteger("memberId",memberId).list();
    }


}
