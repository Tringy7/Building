package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.service.BuildingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuilidingConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BuildingService buildingService;

    public BuildingSearchResponse convertToBuildingReponse(BuildingEntity buildingEntity) {
        BuildingSearchResponse buildingSearchResponse = modelMapper.map(buildingEntity, BuildingSearchResponse.class);
        buildingSearchResponse.setAddress(buildingEntity.getStreet() + ", " + buildingEntity.getWard() + ", " + buildingEntity.getDistrict());
        List<RentAreaEntity> value = buildingEntity.getRentAreaEntities();
        String temp = value.stream().map(v -> v.getValue()).collect(Collectors.joining(","));
        buildingSearchResponse.setRentArea(temp);
        return buildingSearchResponse;
    }

    public BuildingDTO convertToBuildingDTO(BuildingEntity buildingEntity) {
        BuildingDTO buildingDTO = modelMapper.map(buildingEntity, BuildingDTO.class);
        buildingDTO.setAddress(buildingEntity.getStreet() + ", " + buildingEntity.getWard() + ", " + buildingEntity.getDistrict());
        List<RentAreaEntity> value = buildingEntity.getRentAreaEntities();
        String temp = value.stream().map(v -> v.getValue()).collect(Collectors.joining(","));
        buildingDTO.setRentArea(temp);

        String typeCode = buildingEntity.getTypeCode();
        List<String> typeCodeList = Arrays.asList(typeCode.split(","));
        buildingDTO.setTypeCode(typeCodeList);

        return buildingDTO;
    }

    public BuildingEntity convertToBuildingEntity(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = modelMapper.map(buildingDTO, BuildingEntity.class);

        List<String> temp = buildingDTO.getTypeCode();
        String typeCode = temp.stream().collect(Collectors.joining(","));
        buildingEntity.setTypeCode(typeCode);

        List<RentAreaEntity> rentAreaEntityList = new ArrayList<>();
        String valueRentArea = buildingDTO.getRentArea();
        List<String> rentAreaList = Arrays.stream(valueRentArea.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        // Get value table RentArea
//        List<RentAreaEntity> areaEntityList = buildingEntity.getRentAreaEntities();

        for (String rentArea : rentAreaList) {
            RentAreaEntity rentAreaEntity = new RentAreaEntity();
            rentAreaEntity.setValue(rentArea);
            rentAreaEntityList.add(rentAreaEntity);
        }
        buildingEntity.setRentAreaEntities(rentAreaEntityList);
        return buildingEntity;
    }
}
