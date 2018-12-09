package com.cm.business;

import com.cm.common.business.ApartmentService;
import com.cm.common.repo.ApartmentDAO;
import com.cm.entity.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    private ApartmentDAO apartmentDAO;


    @Override
    public long apartmentCount() {
        return apartmentDAO.apartmentCount();
    }

    @Override
    public void addApartment(Apartment apartment) {
        apartmentDAO.addApartment(apartment);
    }

    @Override
    public void updateApartment(Apartment apartment) {
        apartmentDAO.updateApartment(apartment);
    }

    @Override
    public void deleteApartment(Integer id) {
        apartmentDAO.deleteApartment(id);
    }

    @Override
    public Apartment getApartment(Integer id) {
        return apartmentDAO.getApartment(id);
    }

    @Override
    public List<Apartment> getAllApartments() {
        return apartmentDAO.getAllApartments();
    }

    @Override
    public List<Apartment> getApartments(Integer sayfaNo, Integer sayfaBasinaSayi) {
        return apartmentDAO.getApartments(sayfaNo,sayfaBasinaSayi);
    }

    @Override
    public List<Integer> getMaxFloorCountList() {
        return apartmentDAO.getMaxFloorCountList();
    }

    @Override
    public void addFloor(Integer id) {
        apartmentDAO.addFloor(id);
    }

    @Override
    public void deleteFloor(Integer id) {
        apartmentDAO.deleteFloor(id);
    }

    @Override
    public List<Apartment> getSelectedBuildingsApartmentNos(Integer id) {
        return apartmentDAO.getSelectedBuildingsApartmentNos(id);
    }


}
