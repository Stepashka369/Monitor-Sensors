package com.task.monitorsensors.entity.enums;

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
        //решил оставить выбрасивание исключения. Обработки этого исключения нет, поскольку
        //этот метод вызывается в маппере сервиса, а перед тем как вызвать данный метод
        //сервис производит валидацию dto, то есть данное исключение не будет выброшено.
        //мог возвращать null, но считаю это не самой лучшей практикой.
        throw new IllegalArgumentException();
    }
}
