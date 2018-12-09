package com.cm.common.business;

import com.cm.entity.UnitType;

import java.util.List;

public interface UnitTypeService {

    public UnitType getUnitType(Integer id);
    public void addUnitType(UnitType unitType);
    public void updateUnitType(UnitType unit);
    public void deleteUnitType(Integer id);
    public List<UnitType> getAllUnitTypes();
    public List<UnitType> getUnitTypes(Integer sayfaNo ,Integer sayfaBasinaSayi);
}
