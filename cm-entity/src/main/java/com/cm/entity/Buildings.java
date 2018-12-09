package com.cm.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Buildings {
    private int id;
    private String name;
    private String address;
    private Collection<Apartment> apartmentsById;
    private Collection<Expense> expensesById;
    private Collection<Income> incomesById;
    private Collection<MemberBuildings> memberBuildingsById;
    private Collection<Staff> staffById;

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
    @Column(name = "address", nullable = false, length = 250)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Buildings buildings = (Buildings) o;

        if (id != buildings.id) return false;
        if (name != null ? !name.equals(buildings.name) : buildings.name != null) return false;
        if (address != null ? !address.equals(buildings.address) : buildings.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "buildingsByBuildingsId")
    public Collection<Apartment> getApartmentsById() {
        return apartmentsById;
    }

    public void setApartmentsById(Collection<Apartment> apartmentsById) {
        this.apartmentsById = apartmentsById;
    }

    @OneToMany(mappedBy = "buildingsByBuildingsId")
    public Collection<Expense> getExpensesById() {
        return expensesById;
    }

    public void setExpensesById(Collection<Expense> expensesById) {
        this.expensesById = expensesById;
    }

    @OneToMany(mappedBy = "buildingsByBuildingsId")
    public Collection<Income> getIncomesById() {
        return incomesById;
    }

    public void setIncomesById(Collection<Income> incomesById) {
        this.incomesById = incomesById;
    }

    @OneToMany(mappedBy = "buildingsByBuildingsId")
    public Collection<MemberBuildings> getMemberBuildingsById() {
        return memberBuildingsById;
    }

    public void setMemberBuildingsById(Collection<MemberBuildings> memberBuildingsById) {
        this.memberBuildingsById = memberBuildingsById;
    }

    @OneToMany(mappedBy = "buildingsByBuildingsId")
    public Collection<Staff> getStaffById() {
        return staffById;
    }

    public void setStaffById(Collection<Staff> staffById) {
        this.staffById = staffById;
    }
}
