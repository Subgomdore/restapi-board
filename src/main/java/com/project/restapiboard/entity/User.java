package com.project.restapiboard.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "user1003")
@Builder
@NoArgsConstructor
public class User {

    @Id
    private String userId;

    private String userPass;

    private String userEmail;

    private String role;

    private String provider;

    private String providerId;

    @CreationTimestamp
    private Timestamp createDate;

    @Builder
    public User(String userId, String userPass, String userEmail, String role, String provider, String providerId, Timestamp createDate) {
        this.userId = userId;
        this.userPass = userPass;
        this.userEmail = userEmail;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
        this.createDate = createDate;
    }
}