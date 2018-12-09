package com.cm.business;

import com.cm.common.business.UnitService;
import com.cm.common.repo.UnitDAO;
import com.cm.entity.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitDAO unitDAO;

    @Override
    public Unit getUnit(int id) {
        return unitDAO.getUnit(id);
    }

    @Override
    public void addUnit(Unit unit) {
        unitDAO.addUnit(unit);
    }

    @Override
    public void updateUnit(Unit unit) {
        unitDAO.updateUnit(unit);
    }

    @Override
    public void deleteUnit(int id) {
        unitDAO.deleteUnit(id);
    }

    @Override
    public List<Unit> getAllUnits() {
        return unitDAO.getAllUnits();
    }

    @Override
    public List<Unit> getUnits(Integer sayfaNo, Integer sayfaBasinaSayi ,String searching) {
        return unitDAO.getUnits(sayfaNo,sayfaBasinaSayi ,searching);
    }

    @Override
    public long unitCount() {
        return unitDAO.unitCount();
    }

    @Override
    public long unitListSearchedCount(String searching) {
        return unitDAO.unitListSearchedCount(searching);
    }

}
