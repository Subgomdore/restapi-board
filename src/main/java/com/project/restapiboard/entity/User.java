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
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String userId;

    private String userPass;

    private String userEmail;

    private String role;

    @CreationTimestamp
    private Timestamp createDate;

}