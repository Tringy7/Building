package com.javaweb.controller.admin;

import com.javaweb.enums.districtCode;
import com.javaweb.enums.typeCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.service.BuildingService;
import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
    private ModelAndView buildingListPage(@ModelAttribute BuildingSearchRequest buildingSearchRequest, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("modelSearch", buildingSearchRequest);
        List<BuildingSearchResponse> buildingSearchResponseList = buildingService.searchBuilding(buildingSearchRequest);
        mav.addObject("buildingList", buildingSearchResponseList);
        mav.addObject("staffList", userService.getStaff());
        mav.addObject("districtType", districtCode.getDistrictCode());
        mav.addObject("typeCode", typeCode.getTypeCode());
        return mav;
    }

    @RequestMapping(value = "/admin/building-edit", method = RequestMethod.GET)
    private ModelAndView buildingEditPage(@ModelAttribute("buildingEdit") BuildingDTO buildingDTO, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/edit");
        mav.addObject("districtType", districtCode.getDistrictCode());
        mav.addObject("typeCode", typeCode.getTypeCode());
        return mav;
    }

    @RequestMapping(value = "/admin/building-edit-{id}", method = RequestMethod.GET)
    private ModelAndView buildingEditPage(@PathVariable("id") Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/edit");
        BuildingDTO buildingDTO = buildingService.findBuildingById(id);
        mav.addObject("buildingEdit", buildingDTO);
        mav.addObject("typeCode", typeCode.getTypeCode());
        mav.addObject("districtType", districtCode.getDistrictCode());
        return mav;
    }
}
