package com.cm.web;

import com.cm.common.business.*;
import com.cm.entity.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class UnitController {

    @Autowired
    private UnitService unitService;
    @Autowired
    private FloorService floorService;
    @Autowired
    private BuildingsService buildingsService;
    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private MemberService memberService;
    @Autowired
    UnitTypeService unitTypeService;


    @RequestMapping(value = "/unit_list/{searching}/{sayfaNo}", method = RequestMethod.GET)
    public ModelAndView UnitList(@PathVariable("sayfaNo") Integer sayfaNo,@PathVariable("searching")String searching) {
        ModelAndView modelAndView = new ModelAndView("unit_list");
        List<Unit> unitList = unitService.getUnits(sayfaNo, 9 , searching);
        modelAndView.addObject("Units", unitList);
        modelAndView.addObject("searching",searching);
        long unitListSearchedCount = unitService.unitListSearchedCount(searching);
        int sayfaSayisi=(int)unitListSearchedCount/10;
        if(unitListSearchedCount%10!=0)
            sayfaSayisi++;
        modelAndView.addObject("sayfaSayisi",sayfaSayisi);
        return modelAndView;
    }

    @RequestMapping(value = "/unit_add", method = RequestMethod.GET)
    public ModelAndView UnitAddPage() {
        ModelAndView modelAndView = new ModelAndView("unit_add");
        modelAndView.addObject("unit", new Unit());
        modelAndView.addObject("buildings", new Buildings());
        modelAndView.addObject("apartment",new Apartment());
        List<Buildings> buildingsList = buildingsService.getAllBuildingss();
        modelAndView.addObject("buildingsList", buildingsList);
        List<Member> memberList = memberService.getAllMembers();
        modelAndView.addObject("memberList",memberList);
        List<UnitType> unitTypeList = unitTypeService.getAllUnitTypes();
        modelAndView.addObject("unitTypeList",unitTypeList);
        return modelAndView;
    }

    @RequestMapping(value = "/unit_add", method = RequestMethod.POST)
    public ModelAndView UnitAdd(@ModelAttribute Unit unit) {
        unitService.addUnit(unit);
        ModelAndView modelAndView = new ModelAndView("redirect:" + "/unit_list/all/1");
        System.out.println("unit_add çalıştı");
        return modelAndView;
    }

    @RequestMapping(value="/unit_add/selectBuilds",method=RequestMethod.GET)
    @ResponseBody
    public List<Apartment> apList(@RequestParam(value="key")Integer id) throws IOException {
        List<Apartment> getSelectedBuildingsApartmentNos = apartmentService.getSelectedBuildingsApartmentNos(id);
        ObjectMapper mapper = new ObjectMapper();
        Apartment obj = new Apartment();
        //mapper.writeValue(new File("c:\\file.json"),obj);   json dosya kaydetme..
        String jsonInString = mapper.writeValueAsString(obj);
        return  getSelectedBuildingsApartmentNos;
    }

    @RequestMapping(value = "unit_add/selectApartments" , method = RequestMethod.GET)
    @ResponseBody
    public List<Floor> floorList(@RequestParam(value="key")Integer id) throws IOException {
        List<Floor> getSelectedApartmentFloornos = floorService.getSelectedApartmentFloornos(id);
        ObjectMapper mapper = new ObjectMapper();
        Floor obj = new Floor();
        //mapper.writeValue(new File("c:\\file.json"),obj);   json dosya kaydetme..
        String jsonInString = mapper.writeValueAsString(obj);
        return  getSelectedApartmentFloornos;
    }

    @RequestMapping(value = "/unit_update/{id}", method = RequestMethod.GET)
    public ModelAndView UnitUpdatePage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("unit_update");
        Unit unit = unitService.getUnit(id);
        modelAndView.addObject("unit", unit);
        List<Floor> floorList = floorService.getUnitFloors(id);
        modelAndView.addObject("floorList", floorList);
        List<UnitType> unitTypeList = unitTypeService.getAllUnitTypes();
        modelAndView.addObject("unitTypeList",unitTypeList);
        List<Member> memberList = memberService.getAllMembers();
        modelAndView.addObject("memberList",memberList);
        return modelAndView;
    }

    @RequestMapping(value = "/unit_update/{id}", method = RequestMethod.POST)
    public ModelAndView UnitUpdate(@ModelAttribute Unit unit) {
        //System.out.println("floorNo" + unit.getFloorByFloorId().getFloorNo() + " member name"+ unit.getMemberByMemberId().getName() + " unit no"+unit.getUnitNo()+" unit type"+unit.getUnitTypeByUnitTypeId().getUnitType());
        unitService.updateUnit(unit);
        ModelAndView modelAndView = new ModelAndView("redirect:" + "/unit_list/all/1");
        return modelAndView;
    }

    @RequestMapping(value = "/unit_delete/{id}", method = RequestMethod.GET)
    public ModelAndView UnitDelete(@PathVariable("id") Integer id, HttpServletRequest request) {
        unitService.deleteUnit(id);
        String referer = request.getHeader("Referer");
        ModelAndView modelAndView = new ModelAndView("redirect:" + referer);
        return modelAndView;
    }
}
