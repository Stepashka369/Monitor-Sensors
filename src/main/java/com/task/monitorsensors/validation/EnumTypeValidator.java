package com.task.monitorsensors.validation;

import com.task.monitorsensors.entity.enums.Type;
import com.task.monitorsensors.validation.annotation.EnumType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumTypeValidator implements ConstraintValidator<EnumType, String> {
    private Set<String> values;

    @Override
    public void initialize(EnumType constraintAnnotation) {
        values = Stream.of(Type.values()).map(item -> item.getType()).collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return values.contains(value);
    }
}
