package com.javaweb.api.admin;

import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "buildingAPIOfAdmin")
@RequestMapping("/admin/building")
public class BuildingAPI {
    @Autowired
    private BuildingService buildingService;

    @PostMapping()
    public void addAndUpdateBuilding(@RequestBody BuildingDTO buildingDTO) {
        buildingService.addBuilding(buildingDTO);
    }

    @DeleteMapping("/{ids}")
    public void deleteBuilding(@PathVariable List<Long> ids) {
        buildingService.deleteBuilding(ids);
    }
}
