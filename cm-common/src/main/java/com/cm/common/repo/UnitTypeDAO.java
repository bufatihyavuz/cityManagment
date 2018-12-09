package com.cm.common.repo;

import com.cm.entity.UnitType;

import java.util.List;

public interface UnitTypeDAO {

    public UnitType getUnitType(Integer id);
    public void addUnitType(UnitType unitType);
    public void updateUnitType(UnitType unitType);
    public void deleteUnitType(Integer id);
    public List<UnitType> getAllUnitTypes();
    public List<UnitType> getUnitTypes(Integer sayfaNo ,Integer sayfaBasinaSayi);
}
