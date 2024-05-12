package com.task.monitorsensors.entity.converter;

import com.task.monitorsensors.entity.enums.Type;
import com.task.monitorsensors.entity.enums.Unit;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UnitConverter implements AttributeConverter<Unit, String> {

    @Override
    public String convertToDatabaseColumn(Unit attribute) {
        return attribute == null ? null : attribute.getUnit();
    }

    @Override
    public Unit convertToEntityAttribute(String dbData) {
        return Unit.fromString(dbData);
    }
}