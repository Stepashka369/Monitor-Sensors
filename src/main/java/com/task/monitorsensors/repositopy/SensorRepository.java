package com.task.monitorsensors.repositopy;

import com.task.monitorsensors.entity.SensorEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface SensorRepository extends CrudRepository<SensorEntity, Long> {

    List<SensorEntity> findAll();

    Optional<SensorEntity> findByNameAndModel(String name, String model);

    @Query(value = "SELECT t FROM SensorEntity t WHERE (:name IS null OR t.name LIKE :name%) AND (:model IS null OR t.model LIKE :model%)")
    List<SensorEntity> searchByNameAndModel(String name, String model);

    @Transactional
    Integer removeSensorEntitiesByNameAndModel(String name, String model);
}
