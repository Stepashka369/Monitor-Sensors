package com.task.monitorsensors.entity.converter;

import com.task.monitorsensors.entity.enums.Type;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TypeConverter implements AttributeConverter<Type, String> {

    @Override
    public String convertToDatabaseColumn(Type attribute) {
        return attribute == null ? null : attribute.getType();
    }

    @Override
    public Type convertToEntityAttribute(String dbData) {
        return Type.fromString(dbData);
    }
}