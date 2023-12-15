package com.example.p1.controller.dto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;

//    public HelloResponseDto(String name, int amount) {
//        this.name = name;
//        this.amount = amount;
//    }
}

