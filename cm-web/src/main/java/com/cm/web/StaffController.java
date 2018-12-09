package com.cm.web;

import com.cm.common.business.BuildingsService;
import com.cm.common.business.StaffService;
import com.cm.entity.Buildings;
import com.cm.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class StaffController {

    @Autowired
    private StaffService staffService;
    @Autowired
    private BuildingsService buildingsService;

    @RequestMapping(value = "/staff_list/{sayfaNo}", method = RequestMethod.GET)
    public ModelAndView StaffList(@PathVariable("sayfaNo") Integer sayfaNo){
        ModelAndView modelAndView = new ModelAndView("staff_list");
        List<Staff> staffList = staffService.getStaffs(sayfaNo,10);
        modelAndView.addObject("Staffs", staffList);
        return modelAndView;
    }

    @RequestMapping(value="/staff_add", method=RequestMethod.GET)
    public ModelAndView StaffAddPage() {
        ModelAndView modelAndView=new ModelAndView("staff_add");
        modelAndView.addObject("staff", new Staff());
        List<Buildings> buildingsList= buildingsService.getAllBuildingss();
        modelAndView.addObject("buildingss", buildingsList);
        return modelAndView;
    }

    @RequestMapping(value="/staff_add", method=RequestMethod.POST)
    public ModelAndView StaffAdd(@ModelAttribute Staff staff) {
        staffService.addStaff(staff);
        ModelAndView modelAndView = new ModelAndView("redirect:"+"/staff_list/1");
        return modelAndView;
    }

    @RequestMapping(value = "/staff_update/{id}", method = RequestMethod.GET)
    public ModelAndView StaffUpdatePage(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("staff_update");
        Staff staff = staffService.getStaff(id);
        modelAndView.addObject("Staff", staff);
        List<Buildings> buildingsList = buildingsService.getAllBuildingss();
        modelAndView.addObject("buildingsList",buildingsList);
        return modelAndView;
    }

    @RequestMapping(value = "/staff_update/{id}", method = RequestMethod.POST)
    public ModelAndView StaffUpdate(@ModelAttribute Staff staff){
        staffService.updateStaff(staff);
        ModelAndView modelAndView = new ModelAndView("redirect:"+"/staff_list/1");
        return modelAndView;
    }

    @RequestMapping (value = "/staff_delete/{id}", method = RequestMethod.GET)
    public ModelAndView StaffDelete(@PathVariable Integer id){
        staffService.deleteStaff(id);
        ModelAndView modelAndView = new ModelAndView("redirect:"+"/staff_list/1");
        return modelAndView;
    }
}

