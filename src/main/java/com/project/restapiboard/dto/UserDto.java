package com.project.restapiboard.dto;

import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotNull
    private String user_id;

    @NotNull
    private String user_pass;

    @NotNull
    private String user_email;

}
