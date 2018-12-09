package com.cm.common.business;

import com.cm.entity.Staff;

import java.util.List;

public interface StaffService {

    public void addStaff(Staff staff);
    public void updateStaff(Staff staff);
    public void deleteStaff(int id);
    public Staff getStaff(int id);
    public List<Staff> getAllStaff();
    public List<Staff> getStaffs(Integer sayfaNo , Integer sayfaBasinaSayi);


}
