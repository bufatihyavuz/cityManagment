package com.cm.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Income {
    private int id;
    private BigDecimal amount;
    private Timestamp date;
    private boolean paymentType;
    private IncomeType incomeTypeByIncomeTypeId;
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
    @Column(name = "amount", nullable = false)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "paymentType", nullable = false)
    public boolean isPaymentType() {
        return paymentType;
    }

    public void setPaymentType(boolean paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Income ıncome = (Income) o;

        if (id != ıncome.id) return false;
        if (paymentType != ıncome.paymentType) return false;
        if (amount != null ? !amount.equals(ıncome.amount) : ıncome.amount != null) return false;
        if (date != null ? !date.equals(ıncome.date) : ıncome.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (paymentType ? 1 : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "incomeTypeId", referencedColumnName = "id", nullable = false)
    public IncomeType getIncomeTypeByIncomeTypeId() {
        return incomeTypeByIncomeTypeId;
    }

    public void setIncomeTypeByIncomeTypeId(IncomeType incomeTypeByIncomeTypeId) {
        this.incomeTypeByIncomeTypeId = incomeTypeByIncomeTypeId;
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
