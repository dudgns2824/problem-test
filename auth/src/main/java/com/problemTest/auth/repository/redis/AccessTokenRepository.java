package com.problemTest.auth.repository.redis;

import com.problemTest.auth.entity.redis.AccessTokenEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AccessTokenRepository extends CrudRepository<AccessTokenEntity, UUID> {
}
