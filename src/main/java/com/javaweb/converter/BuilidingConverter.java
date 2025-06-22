package com.javaweb.converter;

import com.javaweb.config.ModelMapperConfig;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.rentAreaEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuilidingConverter {

    @Autowired
    private ModelMapper modelMapper;

    public BuildingSearchResponse convertToBuildingReponse(BuildingEntity buildingEntity) {
        BuildingSearchResponse buildingSearchResponse = modelMapper.map(buildingEntity, BuildingSearchResponse.class);
        buildingSearchResponse.setAddress(buildingEntity.getStreet() + ", " + buildingEntity.getWard() + ", " + buildingEntity.getDistrict());
        List<rentAreaEntity> value = buildingEntity.getRentAreaEntities();
        String temp = value.stream().map(v -> v.getValue()).collect(Collectors.joining(","));
        buildingSearchResponse.setRentArea(temp);
        return buildingSearchResponse;
    }

    public BuildingDTO convertToBuildingDTO(BuildingEntity buildingEntity) {
        BuildingDTO buildingDTO = modelMapper.map(buildingEntity, BuildingDTO.class);
        buildingDTO.setAddress(buildingEntity.getStreet() + ", " + buildingEntity.getWard() + ", " + buildingEntity.getDistrict());
        List<rentAreaEntity> value = buildingEntity.getRentAreaEntities();
        String temp = value.stream().map(v -> v.getValue()).collect(Collectors.joining(","));
        buildingDTO.setRentArea(temp);
        return buildingDTO;
    }
}
