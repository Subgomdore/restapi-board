package com.project.restapiboard.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
@Entity
@SequenceGenerator(
        name = "USER_SEQ_GENERATOR"
        , sequenceName = "USER_SEQ"
        , initialValue = 1
        , allocationSize = 1
)
@Table(name = "user711")
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "USER_SEQ_GENERATOR")
    private Long user_no;

    @Size(min=2, message = "ID 2글자 이상 입력해 주세요.")
    @ApiModelProperty(notes = "사용자 이름을 입력해 주세요.")
    private String user_id;
    @ApiModelProperty(notes = "사용자의 패스워드를 입력해 주세요.")
    private String user_password;
    @ApiModelProperty(notes = "사용자의 이메일 입력해 주세요.")
    private String user_email;
    @ApiModelProperty(notes = "사용자의 내용을 입력해 주세요.")
    private String user_content;
//    @OneToMany(mappedBy = "user")
//    private List<Post> posts;

    @CreationTimestamp
    private Timestamp createDate;

    @Builder
    public User(String user_id, String user_password, String user_email,String user_content) {
        this.user_id = user_id;
        this.user_password = user_password;
        this.user_email = user_email;
        this.user_content = user_content;
    }
}