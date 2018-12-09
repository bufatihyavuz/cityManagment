package com.cm.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class UnitType {
    private int id;
    private String unitType;
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
    @Column(name = "unitType", nullable = false, length = 20)
    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitType unitType1 = (UnitType) o;

        if (id != unitType1.id) return false;
        if (unitType != null ? !unitType.equals(unitType1.unitType) : unitType1.unitType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (unitType != null ? unitType.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "unitTypeByUnitTypeId")
    public Collection<Unit> getUnitsById() {
        return unitsById;
    }

    public void setUnitsById(Collection<Unit> unitsById) {
        this.unitsById = unitsById;
    }
}
