package com.javaweb.entity;

import com.javaweb.model.response.StaffResponseDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "building")
public class BuildingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "street")
    private String street;

    @Column(name = "ward")
    private String ward;

    @Column(name = "district")
    private String district;

    @Column(name = "numberofbasement")
    private Long numberofbasement;

    @Column(name = "floorarea")
    private Long floorarea;

    @Column(name = "rentprice")
    private Long rentprice;

    @Column(name = "managername")
    private String managername;

    @Column(name = "managerphone")
    private String managerphone;

    @Column(name = "type")
    private String typeCode;

    @OneToMany(mappedBy = "buildingEntity")
    private List<RentAreaEntity> rentAreaEntities;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "assignmentbuilding",
            joinColumns = @JoinColumn(name = "buildingid", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "staffid", nullable = false)
    )
    private List<UserEntity> userEntities;

    public BuildingEntity() {
    }

    public BuildingEntity(Long id, String name, String street, String ward, String district, Long numberofbasement, Long floorarea, Long rentprice, String managername, String managerphone, String typeCode, List<RentAreaEntity> rentAreaEntities) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.ward = ward;
        this.district = district;
        this.numberofbasement = numberofbasement;
        this.floorarea = floorarea;
        this.rentprice = rentprice;
        this.managername = managername;
        this.managerphone = managerphone;
        this.typeCode = typeCode;
        this.rentAreaEntities = rentAreaEntities;
    }

    public List<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getNumberofbasement() {
        return numberofbasement;
    }

    public void setNumberofbasement(Long numberofbasement) {
        this.numberofbasement = numberofbasement;
    }

    public Long getFloorarea() {
        return floorarea;
    }

    public void setFloorarea(Long floorarea) {
        this.floorarea = floorarea;
    }

    public Long getRentprice() {
        return rentprice;
    }

    public void setRentprice(Long rentprice) {
        this.rentprice = rentprice;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

    public String getManagerphone() {
        return managerphone;
    }

    public void setManagerphone(String managerphone) {
        this.managerphone = managerphone;
    }

    public List<RentAreaEntity> getRentAreaEntities() {
        return rentAreaEntities;
    }

    public void setRentAreaEntities(List<RentAreaEntity> rentAreaEntities) {
        this.rentAreaEntities = rentAreaEntities;
    }
}
