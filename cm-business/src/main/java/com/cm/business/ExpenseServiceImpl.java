package com.cm.business;

import com.cm.common.business.ExpenseService;
import com.cm.common.repo.ExpenseDAO;
import com.cm.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseDAO expenseDAO;

    @Override
    public void addExpense(Expense expense) {
        expenseDAO.addExpense(expense);
    }

    @Override
    public void updateExpense(Expense expense) {
        expenseDAO.updateExpense(expense);
    }

    @Override
    public void deleteExpense(Integer id) {
        expenseDAO.deleteExpense(id);
    }

    @Override
    public Expense getExpense(Integer id) {
        return expenseDAO.getExpense(id);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseDAO.getAllExpenses();
    }

    @Override
    public List<Expense> getExpenses(Integer sayfaNo, Integer sayfaBasinaSayi) {
        return expenseDAO.getExpenses(sayfaNo,sayfaBasinaSayi);
    }
}
