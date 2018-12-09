package com.cm.common.business;

import com.cm.entity.Floor;

import java.util.List;

public interface FloorService {

    public void addFloor(Floor floor);
    public void updateFloor(Floor floor);
    public void deleteFloor (Integer id);
    public Floor getFloor(int id);
    public List<Floor> getAllFloors();
    public List<Floor> getFloors(Integer sayfaNo ,Integer sayfaBasinaSayi);
    public List<Floor> getUnitFloors(Integer id);
    public List<Floor> getSelectedApartmentFloornos(Integer id);
}
