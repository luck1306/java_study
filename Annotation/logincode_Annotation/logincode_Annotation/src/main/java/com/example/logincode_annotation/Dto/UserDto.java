package com.example.logincode_annotation.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserDto {

    @NotBlank
    private String name;

    @NotBlank
    private String pwd;

    @Builder
    public UserDto(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

}
