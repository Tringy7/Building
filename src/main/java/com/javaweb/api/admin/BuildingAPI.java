package com.javaweb.api.admin;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController(value = "buildingAPIOfAdmin")
@RequestMapping("/admin/building")
public class BuildingAPI {
    @Autowired
    private BuildingService buildingService;

    @PostMapping()
    public void addOrUpdateBuilding(@RequestBody BuildingDTO buildingDTO) {
        buildingService.addOrUpdateBuilding(buildingDTO);
    }

    @DeleteMapping("/{ids}")
    public void deleteBuilding(@PathVariable List<Long> ids) {
        buildingService.deleteBuilding(ids);
    }

    @GetMapping("{id}/staff")
    public ResponseDTO getStaff(@PathVariable Long id) {
        ResponseDTO responseDTO = buildingService.getStaff(id);
        return responseDTO;
    }

    @PostMapping("/assignmentBuilding")
    public void updateAssignmentBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO) {
        buildingService.updateAssignmentBuilding(assignmentBuildingDTO);
    }

    @PostMapping("/uploadFile")
    public void uploadFile(@RequestParam("file") MultipartFile file,
                           @RequestParam("id") Long buildingId) {
        buildingService.uploadFile(file, buildingId);
    }
}
