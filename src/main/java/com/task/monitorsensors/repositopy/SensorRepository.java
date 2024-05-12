package com.task.monitorsensors.repositopy;

import com.task.monitorsensors.entity.SensorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SensorRepository extends CrudRepository<SensorEntity, Long> {

    List<SensorEntity> findAll();

    Optional<SensorEntity> findByNameAndModel(String name, String model);

    List<SensorEntity> findByNameStartingWithIgnoreCaseAndModelStartingWithIgnoreCase(String name, String model);
}
