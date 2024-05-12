package com.task.monitorsensors.repositopy;

import com.task.monitorsensors.entity.RangeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RangeRepository extends CrudRepository<RangeEntity, Long> {
}
