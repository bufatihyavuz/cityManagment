package com.cm.web;

import com.cm.common.business.MemberService;
import com.cm.common.business.VehicleService;
import com.cm.entity.Member;
import com.cm.entity.Vehicle;
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
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/vehicle_list/{sayfaNo}", method = RequestMethod.GET)
    public ModelAndView VehicleList(@PathVariable("sayfaNo") Integer sayfaNo){
        ModelAndView modelAndView= new ModelAndView("vehicle_list");
        List<Vehicle> vehicleList= vehicleService.getVehicles(sayfaNo, 10);
        modelAndView.addObject("Vehicles", vehicleList);
        return modelAndView;
    }
    @RequestMapping(value = "/vehicle_add" , method = RequestMethod.GET)
    public ModelAndView VehicleAddPage(){
        ModelAndView modelAndView = new ModelAndView("vehicle_add");
        modelAndView.addObject("vehicle",new Vehicle());
        List<Member> memberList = memberService.getAllMembers();
        modelAndView.addObject("members",memberList);
        return modelAndView;
    }

    @RequestMapping(value = "/vehicle_add" , method = RequestMethod.POST)
    public ModelAndView VehicleAdd(@ModelAttribute Vehicle vehicle){
        vehicleService.addVehicle(vehicle);
        ModelAndView modelAndView = new ModelAndView("redirect:"+"/vehicle_list/1");
        return modelAndView;
    }

    @RequestMapping(value = "/vehicle_update/{id}" , method = RequestMethod.GET)
    public ModelAndView VehicleUpdatePage(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("vehicle_update");
        Vehicle vehicle  = vehicleService.getVehicle(id);
        modelAndView.addObject("vehicle", vehicle);
        List<Member> memberList  = memberService.getAllMembers();
        modelAndView.addObject("memberList", memberList);
        return modelAndView;
    }
    @RequestMapping(value = "/vehicle_update/{id}" , method = RequestMethod.POST)
    public ModelAndView VehicleUpdate(@ModelAttribute Vehicle vehicle){
        vehicleService.updateVehicle(vehicle);
        ModelAndView modelAndView = new ModelAndView("redirect:"+"/vehicle_list/1");
        return modelAndView;
    }
    @RequestMapping(value = "/vehicle_delete/{id}" , method = RequestMethod.GET)
    public ModelAndView VehicleDelete(@PathVariable("id") Integer id , HttpServletRequest request){
        vehicleService.deleteVehicle(id);
        String referer = request.getHeader("Referer");
        ModelAndView modelAndView = new ModelAndView("redirect:"+referer);
        return modelAndView;
    }
}


