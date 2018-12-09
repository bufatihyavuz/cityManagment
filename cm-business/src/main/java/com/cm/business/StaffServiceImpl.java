package com.cm.business;

import com.cm.common.business.StaffService;
import com.cm.common.repo.StaffDAO;
import com.cm.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {

    @Autowired
    public StaffDAO staffDAO;




    @Override
    public void addStaff(Staff staff) { staffDAO.addStaff(staff);

    }

    @Override
    public void updateStaff(Staff staff) { staffDAO.updateStaff(staff);

    }

    @Override
    public void deleteStaff(int id) { staffDAO.deleteStaff(id);

    }

    @Override
    public Staff getStaff(int id) {return staffDAO.getStaff(id);
    }

    @Override
    public List<Staff> getAllStaff() { return staffDAO.getAllStaff();}

    @Override
    public List<Staff> getStaffs(Integer sayfaNo, Integer sayfaBasinaSayi) {
        return staffDAO.getStaffs(sayfaNo, sayfaBasinaSayi);
    }
}
