package com.task.monitorsensors.service;

import com.task.monitorsensors.dto.SensorDto;
import com.task.monitorsensors.entity.SensorEntity;
import com.task.monitorsensors.exception.ElementAlreadyExistsException;
import com.task.monitorsensors.exception.ElementNotFoundException;
import com.task.monitorsensors.mapper.SensorMapper;
import com.task.monitorsensors.repositopy.SensorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class SensorService {

    private SensorRepository sensorRepository;
    private SensorMapper sensorMapper;

    @Autowired
     public SensorService(SensorRepository sensorRepository, SensorMapper sensorMapper){
         this.sensorRepository = sensorRepository;
         this.sensorMapper =sensorMapper;
     }

     public List<SensorDto> getAll() {
        return sensorMapper.toDTOList(sensorRepository.findAll());
     }

    public SensorDto getByNameAndModel(String name, String model) throws ElementNotFoundException{
        Optional<SensorEntity> optionalSensor = sensorRepository.findByNameAndModel(name, model);
        return sensorMapper.toDTO(optionalSensor.
                orElseThrow(() -> new ElementNotFoundException("Such element does not exist.")));
    }

    public List<SensorDto> searchByNameAndModel(String name, String model) {
        return sensorMapper.toDTOList(sensorRepository.searchByNameAndModel(name, model));
    }

    public SensorDto save(@Valid SensorDto dto) throws ElementAlreadyExistsException {
        try {
            return sensorMapper.toDTO(sensorRepository.save(sensorMapper.toEntity(dto)));
        }
        catch (Exception exception) {
           throw new ElementAlreadyExistsException("Sensor with such name and model already exists.");
        }
    }

    public Integer deleteByNameAndModel(String name, String model){
        return sensorRepository.removeSensorEntitiesByNameAndModel(name, model);
    }
}
