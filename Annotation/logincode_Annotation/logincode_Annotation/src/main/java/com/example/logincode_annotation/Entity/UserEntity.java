package com.example.logincode_annotation.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity // 모델 정의 하는곳 이라고 명시
@Getter // getter 생성
@Builder // builder pattern 생성
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자 생성
@NoArgsConstructor // 어떤 필드도 매개변수로 받지 않는 생성자 생성
@Table(name = "user") // table 이름을 = "user"로 함
public class UserEntity {

    @Id // 기본 키 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 옵션 같은 것
    /* @GeneratedValue
     * (strategy = GenerationType.IDENTITY) : 기본 키 생성을 db에 위임(AUTO_INCREMENT)
     * 그 외 세 가지가 더 있지만 생략 (보통 mysql 에서는 identity 를 많이 사용)*/
    private Long id;

    @Column(nullable = false) // 속성임을 명시 뒤의 nullable = false 는 null 값을 허용하지 않음을 나타냄
    private String name;

    @Column(nullable = false)
    private String pwd;


}
