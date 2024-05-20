package com.task.monitorsensors.dto;

import com.task.monitorsensors.validation.annotation.EnumType;
import com.task.monitorsensors.validation.annotation.EnumUnit;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.UUID;

@Schema(description = "DTO for transmitting information about sensor")
public class SensorDto {

    @Schema(description = "Id of sensor presented in UUID")
    private UUID id;

    @NotNull
    @Size(min = 3, max = 30)
    @Schema(description = "Name of sensor")
    private String name;

    @NotNull
    @Size(min = 1, max = 15)
    @Schema(description = "Model of sensor")
    private String model;

    @NotNull()
    @EnumType
    @Schema(description = "Type of sensor. Can be presented only in listed values: 'pressure', 'voltage', 'temperature', 'humidity'")
    private String type;

    @Valid
    @Schema(description = "Maximal and minimal values of sensor")
    private RangeDto range;

    @NotNull()
    @EnumUnit
    @Schema(description = "Unit of sensor. Can be presented only in listed values: 'bar', 'voltage', '°C', '%'")
    private String unit;

    @Size(max = 40)
    @Schema(description = "Location where you should place sensor")
    private String location;

    @Size(max = 200)
    @Schema(description = "Sensor description")
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
