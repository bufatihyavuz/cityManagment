package com.cm.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class IncomeType {
    private int id;
    private String name;
    private Collection<Income> incomesById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IncomeType that = (IncomeType) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "incomeTypeByIncomeTypeId")
    public Collection<Income> getIncomesById() {
        return incomesById;
    }

    public void setIncomesById(Collection<Income> incomesById) {
        this.incomesById = incomesById;
    }
}
