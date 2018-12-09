package com.cm.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Renter {
    private int id;
    private Timestamp endTime;
    private Timestamp startTime;
    private boolean status;
    private int unitId;
    private Member memberByMemberId;

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
    @Column(name = "endTime", nullable = true)
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "startTime", nullable = false)
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Basic
    @Column(name = "unitId", nullable = false)
    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Renter renter = (Renter) o;

        if (id != renter.id) return false;
        if (status != renter.status) return false;
        if (unitId != renter.unitId) return false;
        if (endTime != null ? !endTime.equals(renter.endTime) : renter.endTime != null) return false;
        if (startTime != null ? !startTime.equals(renter.startTime) : renter.startTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (status ? 1 : 0);
        result = 31 * result + unitId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "memberId", referencedColumnName = "id", nullable = false)
    public Member getMemberByMemberId() {
        return memberByMemberId;
    }

    public void setMemberByMemberId(Member memberByMemberId) {
        this.memberByMemberId = memberByMemberId;
    }
}
