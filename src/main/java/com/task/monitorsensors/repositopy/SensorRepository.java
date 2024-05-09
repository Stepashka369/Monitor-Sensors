package com.task.monitorsensors.repositopy;

import com.task.monitorsensors.entity.SensorEntity;
import org.springframework.data.repository.CrudRepository;

public interface SensorRepository extends CrudRepository<SensorEntity, Long> {
}
