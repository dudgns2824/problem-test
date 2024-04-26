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
    @Column(name = "user_guid", nullable = false)
    private UUID userGUID;
    @Column(name = "refresh_token", nullable = false)
    private String refreshToken;
}
