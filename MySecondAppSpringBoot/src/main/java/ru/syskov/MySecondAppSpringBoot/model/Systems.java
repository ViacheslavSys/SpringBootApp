package ru.syskov.MySecondAppSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Systems {
    ERP("Enterprise Resource Planning"),
    CRM("Customer Relationship Management"),
    WMS("Warehouse Management System");

    private final String description;

    Systems(String description) {
        this.description = description;
    }

    @JsonCreator
    public static Systems fromValue(String value) {
        if (value == null) {
            return null;
        }


        for (Systems system : Systems.values()) {
            if (system.name().equalsIgnoreCase(value)) {
                return system;
            }
        }

        for (Systems system : Systems.values()) {
            if (system.getDescription().equalsIgnoreCase(value)) {
                return system;
            }
        }

        throw new IllegalArgumentException("Unknown system: " + value);
    }


    @JsonValue
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name();
    }
}
