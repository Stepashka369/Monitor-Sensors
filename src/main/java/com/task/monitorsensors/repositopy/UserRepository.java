package com.task.monitorsensors.repositopy;

import com.task.monitorsensors.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
