package com.gdg.gdg_be_assignment01.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Music {
    private Long id;
    private String title; // 노래 제목
    private String artist; // 가수
    private String genre; // 장르
}
