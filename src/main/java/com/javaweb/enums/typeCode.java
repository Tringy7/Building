package com.javaweb.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public enum typeCode {
    NOI_THAT("Nội thất"),
    TANG_TRET("Tầng trệt"),
    NGUYEN_CAN("Nguyên căn"),
    ;

    private final String typeCodeName;
    typeCode(String typeCodeName) {
        this.typeCodeName = typeCodeName;
    }

    public static Map<String, String> getTypeCode(){
        Map<String, String> res = new TreeMap<>();
        for(typeCode it : typeCode.values()){
            res.put(it.toString(), it.typeCodeName);
        }
        return res;
    }
}
