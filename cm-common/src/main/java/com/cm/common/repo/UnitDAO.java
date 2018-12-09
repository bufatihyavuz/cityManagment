package com.cm.common.repo;

import com.cm.entity.Unit;

import java.util.List;

public interface UnitDAO {

    public Unit getUnit(Integer id);
    public void addUnit(Unit unit);
    public void updateUnit(Unit unit);
    public void deleteUnit(Integer id);
    public List<Unit> getAllUnits();
    public List<Unit> getUnits(Integer sayfaNo ,Integer sayfaBasinaSayi , String searching);
    public long unitCount();
    public long unitListSearchedCount(String searching);
}
