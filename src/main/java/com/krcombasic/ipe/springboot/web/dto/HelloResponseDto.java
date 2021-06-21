package com.krcombasic.ipe.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
//  Data Transfer Object 는 계층 간에 데이터 교환을 위한 객체를 이야기하며 DTO 는 이 영역을 가리킨다.
//  (Service Layer 와는 다르다.)
    private final String name;
    private final int amount;

}
