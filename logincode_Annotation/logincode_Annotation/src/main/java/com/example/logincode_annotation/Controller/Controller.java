package com.example.logincode_annotation.Controller;

// class
import com.example.logincode_annotation.Dto.UserDto;
import com.example.logincode_annotation.Service.UserService;

// lombok
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;

// 어노테이션
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

// validation
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class Controller {

    private final UserService userService;

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.CREATED)
    public void join(@RequestBody @Valid UserDto userDto) {
        userService.saveData(userDto);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto login(@RequestBody @Valid UserDto userDto) {
        return userService.login(userDto);
    }

    @GetMapping("/login/{name}/exists")
    @ResponseStatus(HttpStatus.OK)
    private void exists(@PathVariable String name) {
        userService.exists(name);
    }


}
