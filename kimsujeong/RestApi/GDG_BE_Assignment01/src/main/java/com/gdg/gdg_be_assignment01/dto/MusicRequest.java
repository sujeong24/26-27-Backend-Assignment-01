package com.gdg.gdg_be_assignment01.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import org.openapitools.jackson.nullable.JsonNullable;

public class MusicRequest { // 생성이나 수정 요청에서 전달되는 값
    @NotBlank(message = "제목은 필수입니다.")
    private JsonNullable<String> title = JsonNullable.undefined();
    private JsonNullable<String> artist = JsonNullable.undefined();
    private JsonNullable<String> genre = JsonNullable.undefined();

    // Setter
    @JsonProperty("title") // JsonProperty(): JSON 데이터와 Java 객체 간 매핑할 필드명을 지정할 때 사용
    public void setTitle(String title) {
        this.title = JsonNullable.of(title); // 값이 있으면 값을, 명시된 null이면 null을 저장 / 입력 생략한 경우 Setter가 호출되지 않아 값 그대로 유지
    }

    @JsonProperty("artist")
    public void setArtist(String artist) {
        this.artist = JsonNullable.of(artist);
    }

    @JsonProperty("genre")
    public void setGenre(String genre) {
        this.genre = JsonNullable.of(genre);
    }

    // Service 계층에서 값을 꺼낼 때 사용하는 Getter
    public JsonNullable<String> getTitle() { return title; }
    public JsonNullable<String> getArtist() { return artist; }
    public JsonNullable<String> getGenre() { return genre; }
}