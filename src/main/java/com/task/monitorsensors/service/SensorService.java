package com.task.monitorsensors.service;

import com.task.monitorsensors.dto.SensorDto;
import com.task.monitorsensors.entity.SensorEntity;
import com.task.monitorsensors.exception.ElementNotFoundException;
import com.task.monitorsensors.mapper.SensorMapper;
import com.task.monitorsensors.repositopy.SensorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Validated
public class SensorService {

    private SensorRepository sensorRepository;
    private SensorMapper sensorMapper;

    @Autowired
     public SensorService(SensorRepository sensorRepository, SensorMapper sensorMapper){
         this.sensorRepository = sensorRepository;
         this.sensorMapper = sensorMapper;
     }

     public List<SensorDto> getAll() {
        return sensorMapper.toDTOList(sensorRepository.findAll());
     }

    public SensorDto getById(UUID id) throws ElementNotFoundException {
        Optional<SensorEntity> optionalSensor = sensorRepository.findById(id);
        return sensorMapper.toDTO(optionalSensor.
                orElseThrow(() -> new ElementNotFoundException("Such element does not exist.")));
    }

    public List<SensorDto> searchByNameAndModel(String name, String model) {
        return sensorMapper.toDTOList(sensorRepository.findByNameStartsWithAndModelStartsWithAllIgnoreCase(name, model));
    }

    public SensorDto save(@Valid SensorDto dto) {
        return sensorMapper.toDTO(sensorRepository.save(sensorMapper.toEntity(dto)));
    }

    public void deleteById(UUID id){
        sensorRepository.deleteById(id);
    }
}
