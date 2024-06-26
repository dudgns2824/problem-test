package com.problemTest.auth.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenerationTime;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table(name = UserEntity.TABLE_NAME)
public class UserEntity implements Serializable{
    public static final String TABLE_NAME = "user";

    @org.hibernate.annotations.Generated(GenerationTime.INSERT)
    @Column(insertable = false, updatable = false, columnDefinition = "int auto_increment")
    private Integer idx;

    @Id
    @Column(name = "user_guid", nullable = false, updatable = false, columnDefinition = "Binary(16)")
    private UUID UserGUID;

    @Column(name = "user_id", nullable = false, columnDefinition = "VARCHAR(256)")
    private String UserId;

    @Column(name = "user_password" , nullable = false, columnDefinition = "VARCHAR(256)")
    private String password;

    @Column(name = "user_roles", nullable = false)
    private String role;

    @Column(name = "user_email", nullable = false, columnDefinition = "VARCHAR(256)")
    private String UserEmail;

    @Column(name = "user_created_date", nullable = false, columnDefinition = "DATETIME")
    @CreationTimestamp
    private LocalDateTime UserCreatedDate;

}
