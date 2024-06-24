package com.task.monitorsensors.repositopy;

import com.task.monitorsensors.entity.RangeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface RangeRepository extends CrudRepository<RangeEntity, UUID> {
}
