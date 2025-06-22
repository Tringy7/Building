package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javaweb.converter.BuilidingConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuilidingConverter builidingConverter;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<BuildingSearchResponse> searchBuilding(BuildingSearchRequest buildingSearchRequest) {
        List<BuildingEntity> buildings = buildingRepository.searchBuilding(buildingSearchRequest);
        List<BuildingSearchResponse> buildingSearchResponseList = new ArrayList<>();
        for (BuildingEntity buildingEntity : buildings) {
            BuildingSearchResponse temp = builidingConverter.convertToBuildingReponse(buildingEntity);
            buildingSearchResponseList.add(temp);
        }
        return buildingSearchResponseList;
    }

    @Override
    public BuildingDTO findBuildingById(Long buildingId) {
        BuildingEntity buildingEntity = buildingRepository.findById(buildingId).orElse(null);
        BuildingDTO buildingDTO = builidingConverter.convertToBuildingDTO(buildingEntity);
        return buildingDTO;
    }
}
