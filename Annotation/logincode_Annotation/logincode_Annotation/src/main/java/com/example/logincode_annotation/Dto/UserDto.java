package com.example.logincode_annotation.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter // getter를 생성한다. ( get(필드명, 첫 글자 대문자)() )
@NoArgsConstructor // 인자가 없는 생성자를 생성한다. (기본 생성자)
public class UserDto {

    @NotBlank // null, "", " "의 사용을 금한다.
    private String name;

    @NotBlank
    private String pwd;

    @Builder // builder pattern을 생성한다.
    public UserDto(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
    /*builder pattern
     * 생성자와 비슷하지만, 생성자와 다르게 어떤 매개변수 위치에 어떤 값이 들어갔는지 명시됨
     * ex) string 값으로 받는 매개변수가 2개일 때 둘 중 어떤 값이 어떤 매개변수 위치에 할당되는지 혼동이 오기도 함
     * */
}
