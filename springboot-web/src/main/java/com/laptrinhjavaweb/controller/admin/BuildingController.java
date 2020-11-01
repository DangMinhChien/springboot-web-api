package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.IDistrictService;
import com.laptrinhjavaweb.service.IUserService;

@Controller()
public class BuildingController {
	@Autowired 
	private IDistrictService districtService;
	
	@Autowired 
	private IBuildingService buildingService;
	
	@Autowired 
	private IUserService userService;
	
	@RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
	public ModelAndView buildingList(@ModelAttribute("modelSearch") BuildingSearchBuilder buildingSearchBuilder) {
		ModelAndView mav = new ModelAndView("admin/building/list");
		mav.addObject("modelSearch", buildingSearchBuilder);
		mav.addObject("districts", districtService.getDistrict());
		mav.addObject("buildingTypes", buildingService.getBuilding());
		mav.addObject("staff",userService.getStaffMaps());
		mav.addObject("buldings",buildingService.getBuildings(buildingSearchBuilder));
		return mav;
	}
	@RequestMapping(value = "admin/building-edit", method = RequestMethod.GET)
	public ModelAndView buildingEdit() {
		ModelAndView mav = new ModelAndView("admin/building/edit");
		return mav;
	}

}