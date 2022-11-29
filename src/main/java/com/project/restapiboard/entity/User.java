package com.project.restapiboard.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(
        name = "USER_SEQ_GENERATOR"
        , sequenceName = "USER_SEQ"
        , initialValue = 1
        , allocationSize = 1
)
@Embeddable
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private String user_id;

    private String user_pass;
    private String user_email;


}