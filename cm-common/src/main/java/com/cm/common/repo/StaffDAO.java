package com.cm.common.repo;

import com.cm.entity.Staff;

import java.util.List;

public interface StaffDAO {
    public void addStaff(Staff staff);
    public void updateStaff(Staff staff);
    public void deleteStaff(int id);
    public Staff getStaff(int id);
    public List<Staff> getAllStaff();
    public List<Staff> getStaffs(Integer sayfaNo , Integer sayfaBasinaSayi);


}
