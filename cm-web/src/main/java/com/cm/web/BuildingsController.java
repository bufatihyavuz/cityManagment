package com.cm.web;

import com.cm.common.business.BuildingsService;
import com.cm.entity.Buildings;
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
public class BuildingsController {

    @Autowired
    private BuildingsService buildingsService;

    @RequestMapping(value = "/buildings_list/{sayfaNo}" , method = RequestMethod.GET)
    public ModelAndView BuildingsList(@PathVariable("sayfaNo")Integer id){
        ModelAndView modelAndView = new ModelAndView("buildings_list");
        List<Buildings> buildingsList = buildingsService.getBuildingss(id,10);
        modelAndView.addObject("Buildingss",buildingsList);
        return modelAndView;
    }

    @RequestMapping(value = "/buildings_add" , method = RequestMethod.GET)
    public ModelAndView BuildingsAddPage(){
        ModelAndView modelAndView = new ModelAndView("buildings_add");
        modelAndView.addObject("buildings",new Buildings());
        return modelAndView;
    }

    @RequestMapping(value = "/buildings_add" , method = RequestMethod.POST)
    public ModelAndView BuildingsAdd(@ModelAttribute Buildings buildings){
        buildingsService.addBuildings(buildings);
        ModelAndView modelAndView = new ModelAndView("redirect:"+"/buildings_list/1");
        return modelAndView;
    }

    @RequestMapping(value = "/buildings_update/{id}" , method = RequestMethod.GET)
    public ModelAndView BuildingsUpdatePage(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("/buildings_update");
        Buildings buildings = buildingsService.getBuildings(id);
        modelAndView.addObject("buildings" ,buildings);
        return modelAndView;
    }

    @RequestMapping(value = "/buildings_update/{id}" , method = RequestMethod.POST)
    public ModelAndView BuildingsUpdate(@ModelAttribute Buildings buildings){
        buildingsService.updateBuildings(buildings);
        ModelAndView modelAndView = new ModelAndView("redirect:"+"/buildings_list/1");
        return modelAndView;
    }

    @RequestMapping(value = "/buildings_delete/{id}" , method = RequestMethod.GET)
    public ModelAndView BuildingsDelete(@PathVariable("id")Integer id){
        buildingsService.deleteBuildings(id);
        ModelAndView modelAndView = new ModelAndView("redirect:"+"/buildings_list/1");
        return modelAndView;
    }

}
