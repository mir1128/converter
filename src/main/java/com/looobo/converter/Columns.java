package com.looobo.converter;

public enum Columns {
    INDEX("index"),
    IDENTITY("identity_id"),
    NAME("name"),
    AGE("age"),
    ADDRESS("family_address"),
    HOME_BACKGROUND("home_background"),
    VILLAGE_AMOUNT("village_amount"),
    ALLOWANCES_AMOUNT("allowances_amount"),
    TOWN_AMOUNT("town_amount"),


    OTHER("other");
    private final String value;

    Columns(String value) {
        this.value = value;
    }
}
