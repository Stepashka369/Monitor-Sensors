//package com.task.monitorsensors.validation;
//
//import com.task.monitorsensors.dto.SensorDto;
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//
//public class EnumValidator implements ConstraintValidator<T, String> {
//    private Class<? extends Enum<?>> enumSelected;
//
//    @Override
//    public void initialize(ValidEnum constraintAnnotation) {
//        enumSelected = constraintAnnotation.targetClassType();
//    }
//
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext context) {
//        if(value == null) {
//            return true;
//        }
//
//        boolean result = false;
//        Object[] enumValues = enumSelected.getEnumConstants();
//
//        for(Object obj : enumValues) {
//            if(value.equals(obj.toString())) {
//                result = true;
//                break;
//            }
//        }
//
//        return result;
//    }
//}
