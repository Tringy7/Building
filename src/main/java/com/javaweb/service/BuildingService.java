package com.javaweb.service;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BuildingService {
    List<BuildingSearchResponse> searchBuilding(BuildingSearchRequest buildingSearchRequest);

    BuildingDTO findBuildingById(Long buildingId);

    void addOrUpdateBuilding(BuildingDTO buildingDTO);

    void deleteBuilding(List<Long> buildingId);

    ResponseDTO getStaff(Long buildingId);

    void updateAssignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO);

    void uploadFile(MultipartFile file, Long buildingId);
}
