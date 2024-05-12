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

    @Named("typeFromString")
    default Type typeFromString(String string){
        return Type.fromString(string);
    }

    @Named("unitFromString")
    default Unit unitFromString(String string){
        return Unit.fromString(string);
    }

    SensorDto toDTO(SensorEntity entity);

    @Mapping(target = "type", source = "type", qualifiedByName = "typeFromString")
    @Mapping(target = "unit", source = "unit", qualifiedByName = "unitFromString")
    SensorEntity toEntity(SensorDto dto);

    List<SensorDto> toDTOList(List<SensorEntity> entities);

    List<SensorEntity> toEntityList(List<SensorDto> dtos);
}
