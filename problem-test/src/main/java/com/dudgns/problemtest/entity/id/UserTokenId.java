package com.dudgns.problemtest.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserTokenId implements Serializable {
    @Column(name = "user_guid", nullable = false, updatable = false)
    private UUID UserGUID;
    @Column(name = "access_token", nullable = false, updatable = false)
    private String AccessToken;
}
