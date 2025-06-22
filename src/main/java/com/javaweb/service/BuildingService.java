package com.javaweb.service;

import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;

import java.util.List;
import java.util.Map;

public interface BuildingService {
    List<BuildingSearchResponse> searchBuilding(BuildingSearchRequest buildingSearchRequest);

    BuildingDTO findBuildingById(Long buildingId);
}
