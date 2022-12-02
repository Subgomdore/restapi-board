package com.project.restapiboard.dto;

import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotNull
    private  String user_id;

    @NotNull
    private String user_pass;


}
