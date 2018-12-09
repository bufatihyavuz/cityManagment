package com.cm.repo;

import com.cm.common.repo.ExpenseDAO;
import com.cm.entity.Expense;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ExpenseDAOImpl implements ExpenseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addExpense(Expense expense) {
        getCurrentSession().save(expense);
    }

    @Override
    public void updateExpense(Expense expense) {
        getCurrentSession().update(expense);
    }

    @Override
    public void deleteExpense(Integer id) {
        Expense expense = getExpense(id);
        if(expense!=null){
            getCurrentSession().delete(expense);
        }
    }

    @Override
    public Expense getExpense(Integer id) {
        return (Expense)getCurrentSession().get(Expense.class,id);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return getCurrentSession().createSQLQuery("SELECT * FROM Expense").list();
    }

    @Override
    public List<Expense> getExpenses(Integer sayfaNo, Integer sayfaBasinaSayi) {
                Query query = getCurrentSession().createSQLQuery("EXEC Expense_List  :sayfaNo , :sayfaBasinaSayi")
                .addEntity(Expense.class)
                .setInteger("sayfaNo",sayfaNo)
                .setInteger("sayfaBasinaSayi",sayfaBasinaSayi);
                List<Expense> expenseList = query.list();
                return expenseList;
    }
}
