package com.gdg.gdg_be_assignment01.dto;

import lombok.Getter;

@Getter
public class MusicRequest { // 생성이나 수정 요청에서 전달되는 값
    private String title;
    private String artist;
    private String genre;
}
