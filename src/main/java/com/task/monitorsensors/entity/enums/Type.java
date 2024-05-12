package com.task.monitorsensors.entity.enums;

import org.mapstruct.Named;

public enum Type {
    PRESSURE("pressure"),
    VOLTAGE("voltage"),
    TEMPERATURE("temperature"),
    HUMIDITY("humidity");

    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static Type fromString(String string) {
        for (Type item : values()) {
            if (item.getType().equals(string)) {
                return item;
            }
        }
        throw new IllegalArgumentException();
    }
}
