package com.javaweb.model.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildingDTO extends AbstractDTO {
    private Long id;
    private String name;
    private String street;
    private String ward;
    private String district;
    private String address;
    private Long numberOfBasement;
    private Long floorArea;
    private List<String> typeCode;
    private String managerName;
    private String managerPhone;
    private Long rentPrice;
    private String rentArea;

    public BuildingDTO() {
    }

    public BuildingDTO(Long id, String name, String street, String ward, String district, String address, Long numberOfBasement, Long floorArea, List<String> typeCode, String managerName, String managerPhone, Long rentPrice, String rentArea) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.ward = ward;
        this.district = district;
        this.address = address;
        this.numberOfBasement = numberOfBasement;
        this.floorArea = floorArea;
        this.typeCode = typeCode;
        this.managerName = managerName;
        this.managerPhone = managerPhone;
        this.rentPrice = rentPrice;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
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

    public Long getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Long floorArea) {
        this.floorArea = floorArea;
    }

    public List<String> getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(List<String> typeCode) {
        this.typeCode = typeCode;
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

    public Long getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Long rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getRentArea() {
        return rentArea;
    }

    public void setRentArea(String rentArea) {
        this.rentArea = rentArea;
    }
}