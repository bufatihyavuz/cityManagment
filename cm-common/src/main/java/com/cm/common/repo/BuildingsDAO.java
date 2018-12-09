package com.cm.common.repo;

import com.cm.entity.Buildings;

import java.util.List;

public interface BuildingsDAO {

    public void addBuildings(Buildings buildings);
    public void updateBuildings(Buildings buildings);
    public void deleteBuildings(int id);
    public Buildings getBuildings(int id);
    public List<Buildings> getAllBuildingss();
    public List<Buildings> getBuildingss(Integer sayfaNo ,Integer sayfaBasinaSayi);
    public int getbuildingsCount();
}
