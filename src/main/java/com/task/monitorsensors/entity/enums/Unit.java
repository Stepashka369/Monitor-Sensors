package com.task.monitorsensors.entity.enums;

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
        //решил оставить выбрасивание исключения. Обработки этого исключения нет, поскольку
        //этот метод вызывается в маппере сервиса, а перед тем как вызвать данный метод
        //сервис производит валидацию dto, то есть данное исключение не будет выброшено.
        //мог возвращать null, но считаю это не самой лучшей практикой.
        throw new IllegalArgumentException();
    }
}
