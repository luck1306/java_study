package com.example.logincode_annotation.Service;

import com.example.logincode_annotation.Dto.UserDto;
import com.example.logincode_annotation.Entity.UserEntity;
import com.example.logincode_annotation.Entity.UserRepository;
import com.example.logincode_annotation.Exception.ConflictException;
import com.example.logincode_annotation.Exception.NotFoundException;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@RequiredArgsConstructor // final이나 @NonNull을 매개변수로 받는 생성자 생성
@Service // 비즈니스 로직수행을 명시
public class UserService {

    private final UserRepository userRepository;

    public void saveData(UserDto userDto) {

        UserEntity userEntity = UserEntity.builder()
                .name(userDto.getName())
                .pwd(userDto.getPwd())
                .build();

        userRepository.save(userEntity);
    }

    public void findDate(UserDto userDto) {

    }

    public UserDto login(UserDto userDto) {
        UserEntity userEntity = userRepository.findByname(userDto.getName())
                .filter(entity -> entity.getPwd().equals(userDto.getPwd()))
                .orElseThrow(NotFoundException::new);

        return UserDto.builder()
                .name(userEntity.getName())
                .pwd(userEntity.getPwd())
                .build();
    }

    public void exists(String name) {
        if (userRepository.existsByname(name)) {
            throw new ConflictException();
        }
    }
}
