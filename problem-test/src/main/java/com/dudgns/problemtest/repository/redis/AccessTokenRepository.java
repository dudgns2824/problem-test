package com.dudgns.problemtest.repository.redis;


import com.dudgns.problemtest.entity.redis.AccessTokenEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AccessTokenRepository extends CrudRepository<AccessTokenEntity, UUID> {
}
