package com.cm.web;

import com.cm.common.business.ApartmentService;
import com.cm.common.business.BuildingsService;
import com.cm.common.business.FloorService;
import com.cm.entity.Apartment;
import com.cm.entity.Buildings;
import com.cm.entity.Floor;
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
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private BuildingsService buildingsService;
    @Autowired
    private FloorService floorService;

    @RequestMapping(value = "/apartment_list/{sayfaNo}" , method = RequestMethod.GET)
    public ModelAndView ApartmentAddPage(@PathVariable("sayfaNo") Integer sayfaNo){
        ModelAndView modelAndView = new ModelAndView("apartment_list");
        List<Apartment> apartmentList = apartmentService.getApartments(sayfaNo,10);
        modelAndView.addObject("Apartments" ,apartmentList);
        List<Integer> maxFloorCountList = apartmentService.getMaxFloorCountList();
        modelAndView.addObject("maxFloorCountList",maxFloorCountList);
        long apartmentCOunt = apartmentService.apartmentCount();
        return modelAndView;
    }

    @RequestMapping(value = "/apartment_add" , method = RequestMethod.GET)
    public ModelAndView ApartmentAddPage(){
        ModelAndView modelAndView = new ModelAndView("apartment_add");
        modelAndView.addObject("apartment", new Apartment());
        List<Buildings> buildingsList = buildingsService.getAllBuildingss();
        modelAndView.addObject("buildingss",buildingsList);
        return modelAndView;
    }

    @RequestMapping(value = "/apartment_add" , method = RequestMethod.POST)
    public ModelAndView ApartmentAdd(@ModelAttribute Apartment apartment){
        apartmentService.addApartment(apartment);
        Floor floor = new Floor();
        floor.setApartmentByAparmentId(apartment);
        floor.setFloorNo(1);
        floorService.addFloor(floor);
        ModelAndView modelAndView = new ModelAndView("redirect:"+"/apartment_list/1");
        return modelAndView;
    }

    @RequestMapping(value = "/apartment_update/{id}" , method = RequestMethod.GET)
    public ModelAndView ApartmentUpdatePage(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("apartment_update");
        Apartment apartment = apartmentService.getApartment(id);
        modelAndView.addObject("apartment",apartment);
        List<Buildings> buildingsList = buildingsService.getAllBuildingss();
        modelAndView.addObject("buildingsList",buildingsList);
        return modelAndView;
    }

    @RequestMapping(value = "/apartment_update/{id}" , method = RequestMethod.POST)
    public ModelAndView ApartmentUpdate(@ModelAttribute Apartment apartment){
        apartmentService.updateApartment(apartment);
        ModelAndView modelAndView = new ModelAndView("redirect:"+"/apartment_list/1");
        return modelAndView;
    }

    @RequestMapping(value = "/apartment_delete/{id}" , method = RequestMethod.GET)
    public ModelAndView ApartmentDelete(@PathVariable("id")Integer id , HttpServletRequest request){
        apartmentService.deleteApartment(id);
        String referer = request.getHeader("Referer");
        ModelAndView modelAndView = new ModelAndView("redirect:"+referer);
        return modelAndView;
    }

    @RequestMapping(value = "/floor_add/{id}" , method = RequestMethod.GET)
    public ModelAndView FloorAdd(@PathVariable("id")Integer id , HttpServletRequest request){
        apartmentService.addFloor(id);
        String referer = request.getHeader("Referer");
        ModelAndView modelAndView = new ModelAndView("redirect:"+referer);
        return modelAndView;
    }

    @RequestMapping(value = {"/floor_delete/{id}"}, method = RequestMethod.GET)
    public ModelAndView FloorDelete(@PathVariable("id")Integer id , HttpServletRequest request){
        apartmentService.deleteFloor(id);
        String referer = request.getHeader("Referer");
        ModelAndView modelAndView = new ModelAndView("redirect:"+referer);
        return modelAndView;
    }
}
