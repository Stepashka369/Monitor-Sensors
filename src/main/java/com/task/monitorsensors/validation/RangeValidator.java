package com.task.monitorsensors.validation;

import com.task.monitorsensors.dto.RangeDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangeValidator implements ConstraintValidator<Range, RangeDto> {

    @Override
    public void initialize(Range constraintAnnotation) {
    }

    @Override
    public boolean isValid(RangeDto rangeDto, ConstraintValidatorContext context) {
        return rangeDto.getFrom() < rangeDto.getTo();
    }
}

