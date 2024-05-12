package com.task.monitorsensors.entity;

import com.task.monitorsensors.entity.converter.TypeConverter;
import com.task.monitorsensors.entity.converter.UnitConverter;
import com.task.monitorsensors.entity.enums.Type;
import com.task.monitorsensors.entity.enums.Unit;
import jakarta.persistence.*;

@Entity
@Table(name = "sensor")
public class SensorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String model;

    @Convert(converter = TypeConverter.class)
    private Type type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "range_id", referencedColumnName = "id")
    private RangeEntity range;

    @Convert(converter = UnitConverter.class)
    private Unit unit;

    private String location;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public RangeEntity getRange() {
        return range;
    }

    public void setRange(RangeEntity range) {
        this.range = range;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
