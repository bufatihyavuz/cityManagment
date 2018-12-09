package com.cm.common.business;

import com.cm.entity.Apartment;

import java.util.List;

public interface ApartmentService {

    public void addApartment(Apartment apartment);
    public void updateApartment(Apartment apartment);
    public void deleteApartment(Integer id);
    public Apartment getApartment(Integer id);
    public List<Apartment> getAllApartments();
    public List<Apartment> getApartments(Integer sayfaNo ,Integer sayfaBasinaSayi);
    public List<Integer> getMaxFloorCountList();
    public void addFloor(Integer id);
    public void deleteFloor(Integer id);
    public List<Apartment> getSelectedBuildingsApartmentNos(Integer id);
    public long apartmentCount();
}
