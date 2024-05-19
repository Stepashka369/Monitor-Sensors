package com.task.monitorsensors.mapper;

import com.task.monitorsensors.dto.SensorDto;
import com.task.monitorsensors.entity.SensorEntity;
import com.task.monitorsensors.entity.enums.Type;
import com.task.monitorsensors.entity.enums.Unit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = RangeMapper.class)
public interface SensorMapper {

    @Named("convertTypeToStr")
    default String convertTypeToStr(Type type){
        return type.getType();
    }

    @Named("convertUnitToStr")
    default String convertUnitToStr(Unit unit){
        return unit.getUnit();
    }

    @Named("convertTypeToEnum")
    default Type convertTypeToEnum(String type) {
        return Type.fromString(type);
    }

    @Named("convertUnitToEnum")
    default Unit convertUnitToEnum(String unit) {
        return Unit.fromString(unit);
    }

    @Mapping(target = "type", source = "type", qualifiedByName = "convertTypeToStr")
    @Mapping(target = "unit", source = "unit", qualifiedByName = "convertUnitToStr")
    SensorDto toDTO(SensorEntity entity);


    @Mapping(target = "type", source = "type", qualifiedByName = "convertTypeToEnum")
    @Mapping(target = "unit", source = "unit", qualifiedByName = "convertUnitToEnum")
    SensorEntity toEntity(SensorDto dto);

    List<SensorDto> toDTOList(List<SensorEntity> entities);

    List<SensorEntity> toEntityList(List<SensorDto> dtos);
}
