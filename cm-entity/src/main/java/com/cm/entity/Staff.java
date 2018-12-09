package com.cm.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Staff {
    private int id;
    private String name;
    private String surname;
    private String address;
    private Date endTime;
    private BigDecimal salary;
    private Date startTime;
    private boolean status;
    private StaffType staffTypeByStaffTypeId;
    private Buildings buildingsByBuildingsId;

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
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 50)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 250)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "endTime", nullable = false)
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "salary", nullable = false)
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "startTime", nullable = false)
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (id != staff.id) return false;
        if (status != staff.status) return false;
        if (address != null ? !address.equals(staff.address) : staff.address != null) return false;
        if (endTime != null ? !endTime.equals(staff.endTime) : staff.endTime != null) return false;
        if (salary != null ? !salary.equals(staff.salary) : staff.salary != null) return false;
        if (startTime != null ? !startTime.equals(staff.startTime) : staff.startTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (status ? 1 : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "staffTypeId", referencedColumnName = "id", nullable = false)
    public StaffType getStaffTypeByStaffTypeId() {
        return staffTypeByStaffTypeId;
    }

    public void setStaffTypeByStaffTypeId(StaffType staffTypeByStaffTypeId) {
        this.staffTypeByStaffTypeId = staffTypeByStaffTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "buildingsId", referencedColumnName = "id", nullable = false)
    public Buildings getBuildingsByBuildingsId() {
        return buildingsByBuildingsId;
    }

    public void setBuildingsByBuildingsId(Buildings buildingsByBuildingsId) {
        this.buildingsByBuildingsId = buildingsByBuildingsId;
    }
}
