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

@Table(name = "user77")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "USER_SEQ_GENERATOR")
    private Long user_no;

    private String user_id;
    private String user_pass;
    private String user_email;
    private String user_content;

}