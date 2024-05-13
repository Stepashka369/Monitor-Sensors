package com.task.monitorsensors.validation;

import com.task.monitorsensors.entity.enums.Type;
import com.task.monitorsensors.entity.enums.Unit;
import com.task.monitorsensors.validation.annotation.EnumType;
import com.task.monitorsensors.validation.annotation.EnumUnit;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumUnitValidator implements ConstraintValidator<EnumUnit, String> {
    private Set<String> values;

    @Override
    public void initialize(EnumUnit constraintAnnotation) {
        values = Stream.of(Unit.values()).map(item -> item.getUnit()).collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return values.contains(value);
    }
}
