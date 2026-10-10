package com.gdg.gdg_be_assignment01.controller;

import com.gdg.gdg_be_assignment01.dto.MusicRequest;
import com.gdg.gdg_be_assignment01.dto.MusicResponse;
import com.gdg.gdg_be_assignment01.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/musics")
public class MusicController {
    private final MusicService musicService;

    @PostMapping
    public ResponseEntity<MusicResponse> create(@RequestBody MusicRequest request) { // 클라이언트가 요청 body에 보낸 json 데이터를 MusicRequest 객체로 변환
        return ResponseEntity.status(HttpStatus.CREATED).body(musicService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<MusicResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(musicService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicResponse> findById(@PathVariable("id") Long id) { // @PathVariable : URL 경로에 포함된 값을 메서드의 매개변수로 받아옴. 전달받은 id는 Service에 전달
        return ResponseEntity.status(HttpStatus.OK).body(musicService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MusicResponse> update(@PathVariable("id") Long id, @RequestBody MusicRequest request) { // 수장할 노래의 id는 URL에서, 수정할 내용은 요청 body에서 받아 service에 전달
        return ResponseEntity.status(HttpStatus.OK).body(musicService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        musicService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
