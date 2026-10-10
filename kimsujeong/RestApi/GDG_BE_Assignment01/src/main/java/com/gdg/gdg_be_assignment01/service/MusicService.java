package com.gdg.gdg_be_assignment01.service;

import com.gdg.gdg_be_assignment01.domain.Music;
import com.gdg.gdg_be_assignment01.dto.MusicRequest;
import com.gdg.gdg_be_assignment01.dto.MusicResponse;
import com.gdg.gdg_be_assignment01.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final MusicRepository musicRepository;

    // 클라이언트가 보낸 musicRequest 값을 이용해 새로운 Music 객체 생성, 레포지토리 저장 후 MusicResponse로 변환 뒤 반환
    public MusicResponse create(MusicRequest request) {
        Music music = new Music(null, request.getTitle(), request.getArtist(), request.getGenre());
        return new MusicResponse(musicRepository.save(music));
    }

    // Repository에서 모든 노래 데이터 조회
    public List<MusicResponse> findAll() {
        return musicRepository.findAll().stream()
                .map(MusicResponse::new)
                .toList();
    }

    public MusicResponse findById(Long id) {
        return new MusicResponse(musicRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 노래입니다.")));
    }

    public MusicResponse update(Long id, MusicRequest request) {
        Music music = musicRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 노래입니다."));

        music.update(request.getTitle(), request.getArtist(), request.getGenre());
        return new MusicResponse(music);
    }

    public void delete(Long id) {
        if (!musicRepository.delete(id)) {
            throw new IllegalArgumentException(("존재하지 않는 노래입니다."));
        }
    }
}
