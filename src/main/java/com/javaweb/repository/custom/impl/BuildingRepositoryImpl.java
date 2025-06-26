package com.javaweb.repository.custom.impl;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public void joinTable(BuildingSearchRequest buildingSearchRequest, StringBuilder sql) {
        Long staff = buildingSearchRequest.getStaffId();
        if (staff != null) {
            sql.append(" INNER JOIN assignmentbuilding ON assignmentbuilding.buildingid = b.id");
            sql.append(" INNER JOIN user ON user.id = assignmentbuilding.staffid");
        }

    }

    public void queryNormal(BuildingSearchRequest buildingSearchRequest, StringBuilder sql) {
        try {
            // Get fields
            Field[] fields = BuildingSearchRequest.class.getDeclaredFields();
            for (Field it : fields) {
                // Permit access into the field of the object
                it.setAccessible(true);
                String fieldName = it.getName();
                if (!fieldName.equals("typeCode") && !fieldName.startsWith("value") && !fieldName.startsWith("rentprice") && !fieldName.startsWith("staff")) {
                    // Can use the function to check condition alternative function other
                    Object fieldValue = it.get(buildingSearchRequest);
                    if (fieldValue != null && !fieldValue.equals("")) {
                        if (it.getType().getName().equals("java.lang.Long") || it.getType().getName().equals("java.lang.Integer")) {
                            sql.append(" AND b." + fieldName + " = " + fieldValue);
                        } else {
                            sql.append(" AND b." + fieldName + " LIKE '%" + fieldValue + "%'");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void querySpecial(BuildingSearchRequest buildingSearchRequest, StringBuilder sql) {
        List<String> typeCode = buildingSearchRequest.getTypeCode();
        if (typeCode != null && !typeCode.isEmpty()) {
            sql.append(" AND (");
            String code = typeCode.stream()
                    .map(it -> "b.type LIKE '%" + it + "%'")
                    .collect(Collectors.joining(" OR "));
            sql.append(code);
            sql.append(")");
        }

        Long staffId = buildingSearchRequest.getStaffId();
        if (staffId != null) {
            sql.append(" AND user.id = " + staffId);
        }

        Long valueFrom = buildingSearchRequest.getAreaFrom();
        Long valueTo = buildingSearchRequest.getAreaTo();
        if (valueFrom != null || valueTo != null) {
            sql.append(" AND EXISTS (SELECT * FROM rentarea sql rentarea.buildingid = b.id");
            if (valueFrom != null) {
                sql.append(" AND rentarea.value >= " + valueFrom);
            }
            if (valueTo != null) {
                sql.append(" AND rentarea.value <= " + valueTo);
            }
            sql.append(")");
        }

        Long rentPriceFrom = buildingSearchRequest.getRentPriceFrom();
        Long rentPriceTo = buildingSearchRequest.getRentPriceTo();
        if (rentPriceFrom != null || rentPriceTo != null) {
            if (rentPriceFrom != null) {
                sql.append(" AND b.rentprice >= " + rentPriceFrom);
            }
            if (rentPriceTo != null) {
                sql.append(" AND b.rentprice <= " + rentPriceTo);
            }
        }
    }

    @Override
    public List<BuildingEntity> searchBuilding(BuildingSearchRequest buildingSearchRequest) {
        StringBuilder sql = new StringBuilder("SELECT b.id, b.name, b.street, b.ward, b.district, b.numberofbasement, b.floorarea, b.rentprice, b.managername, b.managerphone, b.type, b.image");
        sql.append(" FROM building b");
        joinTable(buildingSearchRequest, sql);
        sql.append(" WHERE 1=1");
        queryNormal(buildingSearchRequest, sql);
        querySpecial(buildingSearchRequest, sql);
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }
}
