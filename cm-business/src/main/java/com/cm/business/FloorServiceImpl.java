package com.cm.business;

import com.cm.common.business.FloorService;
import com.cm.common.repo.FloorDAO;
import com.cm.entity.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FloorServiceImpl implements FloorService {

    @Autowired
    private FloorDAO floorDAO;


    @Override
    public void addFloor(Floor floor) {
        floorDAO.addFloor(floor);
    }

    @Override
    public void updateFloor(Floor floor) {
        floorDAO.updateFloor(floor);
    }

    @Override
    public void deleteFloor(Integer id) {
        floorDAO.deleteFloor(id);
    }

    @Override
    public Floor getFloor(int id) {
        return floorDAO.getFloor(id);
    }

    @Override
    public List<Floor> getAllFloors() {
        return floorDAO.getAllFloors();
    }

    @Override
    public List<Floor> getFloors(Integer sayfaNo, Integer sayfaBasinaSayi) {
        return floorDAO.getFloors(sayfaNo,sayfaBasinaSayi);
    }

    @Override
    public List<Floor> getUnitFloors(Integer id) {
        return floorDAO.getUnitFloors(id);
    }

    @Override
    public List<Floor> getSelectedApartmentFloornos(Integer id) {
        return floorDAO.getSelectedApartmentFloornos(id);
    }
}
