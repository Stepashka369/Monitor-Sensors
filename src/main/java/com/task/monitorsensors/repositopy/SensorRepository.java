package com.task.monitorsensors.repositopy;

import com.task.monitorsensors.entity.SensorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface SensorRepository extends CrudRepository<SensorEntity, UUID> {

    List<SensorEntity> findAll();

    List<SensorEntity> findByNameStartsWithAndModelStartsWithAllIgnoreCase(String name, String model);
}
