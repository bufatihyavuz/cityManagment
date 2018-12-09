package com.cm.business;

import com.cm.common.business.PhoneService;
import com.cm.common.repo.PhoneDAO;
import com.cm.entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneDAO phoneDAO;


    @Override
    public void addPhone(Phone phone) {
        phoneDAO.addPhone(phone);
    }

    @Override
    public void updatePhone(Phone phone) {
        phoneDAO.updatePhone(phone);
    }

    @Override
    public void deletePhone(int id) {
        phoneDAO.deletePhone(id);
    }

    @Override
    public Phone getPhone(int id) {
        return phoneDAO.getPhone(id);
    }

    @Override
    public List<Phone> getAllPhone() {
        return phoneDAO.getAllPhone();
    }

    @Override
    public List<String> getPhones(Integer memberId) {
        return phoneDAO.getPhones(memberId);
    }

    @Override
    public List<Integer> getPhoneIdsByMemberId(Integer memberId) {
        return phoneDAO.getPhoneIdsByMemberId(memberId);
    }
}
