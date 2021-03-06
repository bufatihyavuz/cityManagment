package com.cm.common.repo;

import com.cm.entity.Expense;

import java.util.List;

public interface ExpenseDAO {

    public void addExpense(Expense expense);
    public void updateExpense(Expense expense);
    public void deleteExpense(Integer id);
    public Expense getExpense(Integer id);
    public List<Expense> getAllExpenses();
    public List<Expense> getExpenses(Integer sayfaNo ,Integer sayfaBasinaSayi);
}
