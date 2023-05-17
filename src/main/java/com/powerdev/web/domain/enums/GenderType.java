package com.powerdev.web.domain.enums;

public enum GenderType {
    Male("남"),
    Female("여");

    private final String value;

    GenderType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
