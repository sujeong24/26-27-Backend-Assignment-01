package com.gdg.gdg_be_assignment01.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gdg.gdg_be_assignment01.domain.Music;
import lombok.Getter;

@Getter
@JsonPropertyOrder({"id", "title", "artist", "genre"})
public class MusicResponse {
    private final Long id;
    private final String title;
    private final String artist;
    private final String genre;

    public MusicResponse(Music music) {
        this.id = music.getId();
        this.title = music.getTitle();
        this.artist = music.getArtist();
        this.genre = music.getGenre();
    }
}
