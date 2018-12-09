package com.cm.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Apartment {
    private int id;
    private String apartmentNo;
    private Buildings buildingsByBuildingsId;
    private Collection<Floor> floorsById;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "apartmentNo", nullable = false)
    public String getApartmentNo() {
        return apartmentNo;
    }

    public void setApartmentNo(String apartmentNo) {
        this.apartmentNo = apartmentNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apartment apartment = (Apartment) o;

        if (id != apartment.id) return false;
        if (apartmentNo != apartment.apartmentNo) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (apartmentNo != null ? apartmentNo.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "buildingsId", referencedColumnName = "id", nullable = false)
    public Buildings getBuildingsByBuildingsId() {
        return buildingsByBuildingsId;
    }

    public void setBuildingsByBuildingsId(Buildings buildingsByBuildingsId) {
        this.buildingsByBuildingsId = buildingsByBuildingsId;
    }

    @OneToMany(mappedBy = "apartmentByAparmentId")
    public Collection<Floor> getFloorsById() {
        return floorsById;
    }

    public void setFloorsById(Collection<Floor> floorsById) {
        this.floorsById = floorsById;
    }
}
