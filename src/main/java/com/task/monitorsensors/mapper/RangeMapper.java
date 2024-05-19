package com.task.monitorsensors.mapper;

import com.task.monitorsensors.dto.RangeDto;
import com.task.monitorsensors.entity.RangeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RangeMapper {

    RangeDto toDTO(RangeEntity entity);

    @Mapping(target = "id", ignore = true)
    RangeEntity toEntity(RangeDto dto);
}
