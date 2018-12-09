package com.cm.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Expense {
    private int id;
    private BigDecimal amount;
    private Date date;
    private Buildings buildingsByBuildingsId;
    private ExpenseType expenseTypeByExpenseTypeId;

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
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expense expense = (Expense) o;

        if (id != expense.id) return false;
        if (amount != null ? !amount.equals(expense.amount) : expense.amount != null) return false;
        if (date != null ? !date.equals(expense.date) : expense.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "expenseTypeId", referencedColumnName = "id", nullable = false)
    public ExpenseType getExpenseTypeByExpenseTypeId() {
        return expenseTypeByExpenseTypeId;
    }

    public void setExpenseTypeByExpenseTypeId(ExpenseType expenseTypeByExpenseTypeId) {
        this.expenseTypeByExpenseTypeId = expenseTypeByExpenseTypeId;
    }
}
