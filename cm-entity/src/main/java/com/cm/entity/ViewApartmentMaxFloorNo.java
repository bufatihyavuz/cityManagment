package com.cm.entity;

import javax.persistence.*;

@Entity
public class ViewApartmentMaxFloorNo {
    private int apartmentId;
    private Integer floorNo;

    @Id
    @GeneratedValue
    @Column(name = "apartmentId", nullable = false)
    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    @Basic
    @Column(name = "floorNo", nullable = true)
    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewApartmentMaxFloorNo that = (ViewApartmentMaxFloorNo) o;

        if (apartmentId != that.apartmentId) return false;
        if (floorNo != null ? !floorNo.equals(that.floorNo) : that.floorNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = apartmentId;
        result = 31 * result + (floorNo != null ? floorNo.hashCode() : 0);
        return result;
    }
}
