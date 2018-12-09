package com.cm.common.business;

import com.cm.entity.Unit;

import java.util.List;

public interface UnitService {

    public Unit getUnit(int id);
    public void addUnit(Unit unit);
    public void updateUnit(Unit unit);
    public void deleteUnit(int id);
    public List<Unit> getAllUnits();
    public List<Unit> getUnits(Integer sayfaNo ,Integer sayfaBasinaSayi ,String searching);
    public long unitCount();
    public long unitListSearchedCount(String searching);
}
