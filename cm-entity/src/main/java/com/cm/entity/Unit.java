package com.cm.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Unit {
    private int id;
    private int unitNo;
    private Collection<Debt> debtsById;
    private Collection<Dues> duesById;
    private Floor floorByFloorId;
    private Member memberByMemberId;
    private UnitType unitTypeByUnitTypeId;

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
    @Column(name = "unitNo", nullable = false)
    public int getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(int unitNo) {
        this.unitNo = unitNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit = (Unit) o;

        if (id != unit.id) return false;
        if (unitNo != unit.unitNo) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + unitNo;
        return result;
    }

    @OneToMany(mappedBy = "unitByUnitId")
    public Collection<Debt> getDebtsById() {
        return debtsById;
    }

    public void setDebtsById(Collection<Debt> debtsById) {
        this.debtsById = debtsById;
    }

    @OneToMany(mappedBy = "unitByUnitId")
    public Collection<Dues> getDuesById() {
        return duesById;
    }

    public void setDuesById(Collection<Dues> duesById) {
        this.duesById = duesById;
    }

    @ManyToOne
    @JoinColumn(name = "floorId", referencedColumnName = "id", nullable = false)
    public Floor getFloorByFloorId() {
        return floorByFloorId;
    }

    public void setFloorByFloorId(Floor floorByFloorId) {
        this.floorByFloorId = floorByFloorId;
    }

    @ManyToOne
    @JoinColumn(name = "memberId", referencedColumnName = "id", nullable = false)
    public Member getMemberByMemberId() {
        return memberByMemberId;
    }

    public void setMemberByMemberId(Member memberByMemberId) {
        this.memberByMemberId = memberByMemberId;
    }

    @ManyToOne
    @JoinColumn(name = "unitTypeId", referencedColumnName = "id", nullable = false)
    public UnitType getUnitTypeByUnitTypeId() {
        return unitTypeByUnitTypeId;
    }

    public void setUnitTypeByUnitTypeId(UnitType unitTypeByUnitTypeId) {
        this.unitTypeByUnitTypeId = unitTypeByUnitTypeId;
    }
}
