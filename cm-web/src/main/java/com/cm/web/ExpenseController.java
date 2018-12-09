package com.cm.web;

import com.cm.common.business.BuildingsService;
import com.cm.common.business.ExpenseService;
import com.cm.entity.Buildings;
import com.cm.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private BuildingsService buildingsService;

    @RequestMapping(value = "/expense_list/{sayfaNo}" , method = RequestMethod.GET)
    public ModelAndView ExpenseList(@PathVariable("sayfaNo") Integer sayfaNo){
        ModelAndView modelAndView = new ModelAndView("expense_list");
        List<Expense> expenseList = expenseService.getExpenses(sayfaNo,10);
        modelAndView.addObject("Expenses" ,expenseList);
        return modelAndView;
    }

    @RequestMapping(value = "/expense_add" , method = RequestMethod.GET)
    public ModelAndView ExpenseAddPage(){
        ModelAndView modelAndView = new ModelAndView("expense_add");
        modelAndView.addObject("expense", new Expense());
        List<Buildings> buildingsList = buildingsService.getAllBuildingss();
        modelAndView.addObject("buildingsList",buildingsList);
        return modelAndView;
    }

    @RequestMapping(value = "/expense_add" , method = RequestMethod.POST)
    public ModelAndView ApartmentAdd(@ModelAttribute Expense expense){
        expenseService.addExpense(expense);
        ModelAndView modelAndView = new ModelAndView("redirect:"+"/expense_list/1");
        return modelAndView;
    }

    @RequestMapping(value = "/expense_update/{id}" , method = RequestMethod.GET)
    public ModelAndView ApartmentUpdatePage(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("expense_update");
        Expense expense = expenseService.getExpense(id);
        modelAndView.addObject("expense",expense);
        List<Buildings> buildingsList = buildingsService.getAllBuildingss();
        modelAndView.addObject("buildingsList",buildingsList);
        return modelAndView;
    }

    @RequestMapping(value = "/expense_update/{id}" , method = RequestMethod.POST)
    public ModelAndView ApartmentUpdate(@ModelAttribute Expense expense){
        expenseService.updateExpense(expense);
        ModelAndView modelAndView = new ModelAndView("redirect:"+"/expense_list/1");
        return modelAndView;
    }

    @RequestMapping(value = "/expense_delete/{id}" , method = RequestMethod.GET)
    public ModelAndView ApartmentDelete(@PathVariable("id")Integer id , HttpServletRequest request){
        expenseService.deleteExpense(id);
        String referer = request.getHeader("Referer");
        ModelAndView modelAndView = new ModelAndView("redirect:"+referer);
        return modelAndView;
    }
}
