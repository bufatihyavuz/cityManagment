package com.cm.repo;

import com.cm.common.repo.StaffDAO;
import com.cm.entity.Staff;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffDAOImpl implements StaffDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addStaff(Staff staff) { getCurrentSession().save(staff);
    }

    @Override
    public void updateStaff(Staff staff) { getCurrentSession().update(staff);
    }

    @Override
    public void deleteStaff(int id) { Staff staff = getStaff(id);
        if(staff!=null){
            getCurrentSession().delete(staff);
        }

    }

    @Override
    public Staff getStaff(int id) {
        return (Staff)getCurrentSession().get(Staff.class, id);
    }

    @Override
    public List<Staff> getAllStaff() {
        return getCurrentSession().createQuery("SELECT s FROM  Staff s").list();
    }

    @Override
    public List<Staff> getStaffs(Integer sayfaNo, Integer sayfaBasinaSayi) {

        Query query;
        query = getCurrentSession().createSQLQuery(" EXEC Staff_List :sayfaNo , :sayfaBasinaSayi")
                .addEntity(Staff.class)
                .setInteger("sayfaNo", sayfaNo)
                .setInteger("sayfaBasinaSayi", sayfaBasinaSayi);
        List<Staff> staffList = query.list();
        return staffList;

    }


}
