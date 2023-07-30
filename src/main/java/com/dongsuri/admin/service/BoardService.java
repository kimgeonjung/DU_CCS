package com.dongsuri.admin.service;

import com.dongsuri.admin.domain.Board;
import com.dongsuri.admin.dto.BoardListResponseDto;
import com.dongsuri.admin.dto.BoardResponseDto;
import com.dongsuri.admin.dto.BoardSaveRequestDto;
import com.dongsuri.admin.dto.BoardUpdateRequestDto;
import com.dongsuri.admin.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardSaveRequestDto requestDto){
        return boardRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, BoardUpdateRequestDto requestDto){
        Board board = boardRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        board.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getCategorys());
        return id;
    }

    @Transactional
    public void delete(Long id){
        Board board = boardRepository.findById(id) .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        boardRepository.delete(board);
    }

    public BoardResponseDto findById (Long id){
        Board entity = boardRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        entity.setViewCount(entity.getViewCount() + 1);
        return new BoardResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<BoardListResponseDto> findAllDesc(){
        return boardRepository.findAllDesc().stream()
                .map(BoardListResponseDto::new)
                .collect(Collectors.toList());
    }
}
