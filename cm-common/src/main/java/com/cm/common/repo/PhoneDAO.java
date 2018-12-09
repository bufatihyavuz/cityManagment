package com.cm.common.repo;

import com.cm.entity.Member;
import com.cm.entity.Phone;

import java.util.List;

public interface PhoneDAO {

    public void addPhone(Phone phone);
    public void updatePhone(Phone phone);
    public void deletePhone(int id);
    public Phone getPhone(int id);
    public List<Phone> getAllPhone();
    public List<String> getPhones(Integer memberId);
    public List<Integer> getPhoneIdsByMemberId(Integer memberId);
}
