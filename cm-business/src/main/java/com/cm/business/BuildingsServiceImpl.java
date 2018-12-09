package com.cm.business;

import com.cm.common.business.BuildingsService;
import com.cm.common.repo.BuildingsDAO;
import com.cm.entity.Buildings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BuildingsServiceImpl implements BuildingsService {

    @Autowired
    private BuildingsDAO buildingsDAO;

    @Override
    public void addBuildings(Buildings buildings) {
        buildingsDAO.addBuildings(buildings);
    }

    @Override
    public void updateBuildings(Buildings buildings) {
        buildingsDAO.updateBuildings(buildings);
    }

    @Override
    public void deleteBuildings(int id) {
        buildingsDAO.deleteBuildings(id);
    }

    @Override
    public Buildings getBuildings(int id) {
        return buildingsDAO.getBuildings(id);
    }

    @Override
    public List<Buildings> getAllBuildingss() {
        return buildingsDAO.getAllBuildingss();
    }

    @Override
    public List<Buildings> getBuildingss(Integer sayfaNo, Integer sayfaBasinaSayi) {
        return buildingsDAO.getBuildingss(sayfaNo,sayfaBasinaSayi);
    }

    @Override
    public int getbuildingsCount() {
        return buildingsDAO.getbuildingsCount();
    }
}
