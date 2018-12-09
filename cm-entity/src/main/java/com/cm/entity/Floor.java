package com.cm.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Floor {
    private int id;
    private int floorNo;
    private Apartment apartmentByApartmentId;
    private Collection<Unit> unitsById;

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
    @Column(name = "floorNo", nullable = false)
    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Floor floor = (Floor) o;

        if (id != floor.id) return false;
        if (floorNo != floor.floorNo) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + floorNo;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "apartmentId", referencedColumnName = "id", nullable = false)
    public Apartment getApartmentByAparmentId() {
        return apartmentByApartmentId;
    }

    public void setApartmentByAparmentId(Apartment apartmentByAparmentId) {
        this.apartmentByApartmentId = apartmentByAparmentId;
    }

    @OneToMany(mappedBy = "floorByFloorId")
    public Collection<Unit> getUnitsById() {
        return unitsById;
    }

    public void setUnitsById(Collection<Unit> unitsById) {
        this.unitsById = unitsById;
    }
}
