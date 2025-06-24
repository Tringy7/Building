package com.javaweb.service;

import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;

import java.util.List;

public interface BuildingService {
    List<BuildingSearchResponse> searchBuilding(BuildingSearchRequest buildingSearchRequest);

    BuildingDTO findBuildingById(Long buildingId);

    void addBuilding(BuildingDTO buildingDTO);

    void deleteBuilding(List<Long> buildingId);

    ResponseDTO getStaff(Long buildingId);
}
