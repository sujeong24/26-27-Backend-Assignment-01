package com.gdg.gdg_be_assignment01.repository;

import com.gdg.gdg_be_assignment01.domain.Music;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MusicRepository {
    private final Map<Long, Music> musics = new HashMap<>(); // 실제 DB 대신 노래 정보를 저장하는 변수
    private long sequence = 0L;

    public MusicRepository() { // 초기 노래 데이터
        save(new Music(null, "맹그로브", "윤하", "Korean Rock/Alt"));
        save(new Music(null, "blue moon", "엔플라잉", "Korean Rock/Alt"));
        save(new Music(null, "Yes or No", "그루비룸", "R&B/Soul"));
        save(new Music(null, "riptide", "Vance Joy", "인디 포크"));
    }

    public Music save(Music newMusic) {
        Music music = new Music(++sequence, newMusic.getTitle(), newMusic.getArtist(), newMusic.getGenre());
        musics.put(music.getId(), music);   // musics Map에 put()으로 music 정보 저장
        return music;
    }

    public List<Music> findAll() {
        return new ArrayList<>(musics.values());
    }

    public Optional<Music> findById(Long id) {
        return Optional.ofNullable(musics.get(id)); // ofNullable : null일 수도 있는 값 담기
    }

    public boolean delete(Long id) {
        return musics.remove(id) != null;
    }
}
