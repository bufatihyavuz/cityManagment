package com.cm.web;

import com.cm.common.business.ApartmentService;
import com.cm.common.business.BuildingsService;
import com.cm.common.business.MemberService;
import com.cm.common.business.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private BuildingsService buildingsService;
	@Autowired
	private ApartmentService apartmentService;
	@Autowired
	private UnitService unitService;

	@RequestMapping(value="/")
	public ModelAndView mainPage() {
		return new ModelAndView("redirect:index");
	}

	@RequestMapping(value="/index")
	public ModelAndView indexPage() {
		ModelAndView modelAndView = new ModelAndView("index");

		/*long ManagerCount=managerService.ManagerCount();
		long CustomerCount= customerService.CustomerCount();
		long FamilyCount = familyService.FamilyCount();
		 */
		int memberCount	= memberService.getMemberCount();
		int buildingsCount = buildingsService.getbuildingsCount();
		long apartmentCount = apartmentService.apartmentCount();
		long unitCount = unitService.unitCount();

		modelAndView.addObject("memberCount",memberCount);
		modelAndView.addObject("buildingsCount", buildingsCount);
		modelAndView.addObject("apartmentCount",apartmentCount);
		modelAndView.addObject("unitCount",unitCount);
		return modelAndView;
	}
}
