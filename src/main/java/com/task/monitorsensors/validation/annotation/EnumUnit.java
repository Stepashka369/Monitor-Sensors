package com.task.monitorsensors.validation.annotation;

import com.task.monitorsensors.validation.EnumUnitValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = EnumUnitValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumUnit {
    String message() default "Enum unit does not contain such constant";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

