package com.powerdev.web.domain.enums;

public enum SpaceType {
    OFFICE("오피스"),
    HOTEL("호텔"),
    SPORT("스포츠시설"),
    ETC("기타");

    private final String label;

    SpaceType(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
