package com.task.monitorsensors.service;

import com.task.monitorsensors.dto.SensorDto;
import com.task.monitorsensors.entity.SensorEntity;
import com.task.monitorsensors.mapper.SensorMapper;
import com.task.monitorsensors.repositopy.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
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

    public SensorDto getByNameAndModel(String name, String model) {
        Optional<SensorEntity> optionalSensor = sensorRepository.findByNameAndModel(name, model);
        return sensorMapper.toDTO(optionalSensor.orElseThrow(() -> new NoSuchElementException()));
    }

    public List<SensorDto> searchByNameAndModel(String name, String model) {
        return sensorMapper.toDTOList(sensorRepository.findByNameStartingWithIgnoreCaseAndModelStartingWithIgnoreCase(name, model));
    }

    public SensorDto save(SensorDto dto) {
        return sensorMapper.toDTO(sensorRepository.save(sensorMapper.toEntity(dto)));
    }

}
