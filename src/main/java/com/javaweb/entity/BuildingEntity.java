package com.javaweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "buildingEntity")
//    @OneToMany(mappedBy = "buildingEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RentAreaEntity> rentAreaEntities;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "assignmentbuilding",
            joinColumns = @JoinColumn(name = "buildingid", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "staffid", nullable = false)
    )
    private List<UserEntity> userEntities;
}
