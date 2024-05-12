package com.task.monitorsensors.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SensorDto {

    @NotNull
    @Size(min = 3, max = 30, message = "The name size must be within the limits [3, 30]")
    private String name;

    @NotNull
    @Size(min = 1, max = 15, message = "The model size must be within the limits [1, 15]")
    private String model;

    @NotNull(message = "Type can not be empty field")
    private String type;

    @Valid
    private RangeDto range;

    @NotNull(message = "Unit can not be empty field")
    private String unit;

    @Max(value = 40, message = "Location field must contain no more than 40 characters")
    private String location;

    @Max(value = 200, message = "Description field must contain no more than 200 characters")
    private String description;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RangeDto getRange() {
        return range;
    }

    public void setRange(RangeDto range) {
        this.range = range;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
