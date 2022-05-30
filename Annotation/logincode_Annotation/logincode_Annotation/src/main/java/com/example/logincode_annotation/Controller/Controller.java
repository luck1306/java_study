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

@RequiredArgsConstructor // final, @NonNull이 붙은 필드들을 매개변수로 갖는 생성자 생성
@RestController // 이 파일이 controller라 명명 앞의 rest는 view가 아닌 json을 응답할 것을 의미
public class Controller {

    private final UserService userService;

    @PostMapping("/join") // 괄호 안의 경로로 post요청이 왔을 때 실행
    @ResponseStatus(HttpStatus.CREATED) // 응답시 http status code를 정해준다.
    public void join(@RequestBody @Valid UserDto userDto) {
        userService.saveData(userDto);
    }
    // @RequestBody : 클라에서 보낸 요청의 값을 뒤의 인자에 값을 할당함
    // @Valid : 유효성 검사
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto login(@RequestBody @Valid UserDto userDto) {
        return userService.login(userDto);
    }

    @GetMapping("/login/{name}/exists") // 괄호 안의 경로로 get요청이 왔을 때 실행
    @ResponseStatus(HttpStatus.OK)
    private void exists(@PathVariable String name) {
        userService.exists(name);
    }
    // @PathVariable : 위 경로 중 {name}의 위치에 있는 값을 뒤의 인자에 값을 할당함
    // @RequestParam : ? 뒤에 존재하는 키=값의 형태를 뒤의 인자에 값을 할당한다.

}
