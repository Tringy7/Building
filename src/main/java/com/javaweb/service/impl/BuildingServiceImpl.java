package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.javaweb.converter.BuilidingConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

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

    @Override
    @Transactional
    public void addOrUpdateBuilding(BuildingDTO buildingDTO){
        BuildingEntity buildingEntity =  builidingConverter.convertToBuildingEntity(buildingDTO);
        buildingRepository.save(buildingEntity);
    }

    @Transactional
    @Override
    public void deleteBuilding(List<Long> buildingId) {
        buildingRepository.deleteByIdIn(buildingId);
    }

    @Override
    public ResponseDTO getStaff(Long buildingId) {
        ResponseDTO responseDTO = new ResponseDTO();
        List<StaffResponseDTO> staffResponseDTOList = new ArrayList<>();

        BuildingEntity buildingEntity = buildingRepository.findById(buildingId).get();
        List<UserEntity> userEntityList = userRepository.findByStatusAndRoles_Code(1, "STAFF");
        List<UserEntity> staffs = buildingEntity.getUserEntities();

        for (UserEntity it : userEntityList) {
            StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
            staffResponseDTO.setStaffId(it.getId());
            staffResponseDTO.setFullName(it.getFullName());

            if(staffs.contains(it)) {
                staffResponseDTO.setChecked("checked");
            }
            else {
                staffResponseDTO.setChecked("");
            }

            staffResponseDTOList.add(staffResponseDTO);
        }

        responseDTO.setData(staffResponseDTOList);
        responseDTO.setMessage("success");
        return responseDTO;
    }

    @Override
    @Transactional
    public void updateAssignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO){
        BuildingEntity buildingEntity = buildingRepository.findById(assignmentBuildingDTO.getBuildingId()).get();
        List<UserEntity> userEntityList = userRepository.findAllById(assignmentBuildingDTO.getStaffs());
        buildingEntity.getUserEntities().clear();
        buildingEntity.setUserEntities(userEntityList);
        buildingRepository.save(buildingEntity);
    }

    @Override
    public void uploadFile(MultipartFile file, Long buildingId){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        BuildingEntity buildingEntity = new BuildingEntity();
        buildingEntity.setImage(fileName);


//        User savedUser = repo.save(user);
//
//        String uploadDir = "user-photos/" + savedUser.getId();
//
//        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//
//        return new RedirectView("/users", true);
    }
}
