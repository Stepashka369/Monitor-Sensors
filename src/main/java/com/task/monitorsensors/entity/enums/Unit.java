package com.task.monitorsensors.entity.enums;

import org.mapstruct.Named;

public enum Unit {
    BAR("bar"),
    VOLTAGE("voltage"),
    CELSIUS("°C"),
    PERCENTAGE("%");

    private String unit;

    Unit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public static Unit fromString(String string) {
        for (Unit item : values()) {
            if (item.getUnit().equals(string)) {
                return item;
            }
        }
        throw new IllegalArgumentException();
    }
}
