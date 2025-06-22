package com.javaweb.model.response;


import com.javaweb.model.dto.AbstractDTO;

public class BuildingSearchResponse extends AbstractDTO {
    private Long id;
    private String name;
    private String address;
    private Long numberOfBasement;
    private String managerName;
    private String managerPhone;
    private Long floorArea;
    private String rentArea;

    public BuildingSearchResponse() {
    }

    public BuildingSearchResponse(Long id, String name, String address, Long numberOfBasement, String managerName, String managerPhone, Long floorArea, String rentArea) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.numberOfBasement = numberOfBasement;
        this.managerName = managerName;
        this.managerPhone = managerPhone;
        this.floorArea = floorArea;
        this.rentArea = rentArea;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Long numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public Long getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Long floorArea) {
        this.floorArea = floorArea;
    }

    public String getRentArea() {
        return rentArea;
    }

    public void setRentArea(String rentArea) {
        this.rentArea = rentArea;
    }
}
