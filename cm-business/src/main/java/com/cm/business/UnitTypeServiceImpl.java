package com.cm.business;

import com.cm.common.business.UnitTypeService;
import com.cm.common.repo.UnitTypeDAO;
import com.cm.entity.UnitType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UnitTypeServiceImpl implements UnitTypeService {

    @Autowired
    private UnitTypeDAO unitTypeDAO;

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
        return unitTypeDAO.getAllUnitTypes();
    }

    @Override
    public List<UnitType> getUnitTypes(Integer sayfaNo, Integer sayfaBasinaSayi) {
        return null;
    }
}
