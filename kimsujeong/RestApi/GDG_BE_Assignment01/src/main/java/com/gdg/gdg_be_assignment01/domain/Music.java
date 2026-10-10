package com.gdg.gdg_be_assignment01.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Music {
    private Long id;
    private String title; // 노래 제목
    private String artist; // 가수
    private String genre; // 장르

    // 노래 정보를 수정하기 위한 메서드
    public void update(String title, String artist, String genre) {
        if (title != null) {
            this.title = title;
        }
        if (artist != null) {
            this.artist = artist;
        }
        if (genre != null) {
            this.genre = genre;
        }
    }

}
