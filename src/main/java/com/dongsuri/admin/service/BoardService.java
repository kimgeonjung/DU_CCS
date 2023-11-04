package com.dongsuri.admin.service;

import com.dongsuri.admin.domain.Board;
import com.dongsuri.admin.dto.boardDto.BoardListResponseDto;
import com.dongsuri.admin.dto.boardDto.BoardResponseDto;
import com.dongsuri.admin.dto.boardDto.BoardSaveRequestDto;
import com.dongsuri.admin.dto.boardDto.BoardUpdateRequestDto;
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

    // 게시글 저장 기능
    @Transactional
    public Long save(BoardSaveRequestDto requestDto){
        return boardRepository.save(requestDto.toEntity()).getId();
    }

    // 게시글 수정 기능
    @Transactional
    public Long update(Long id, BoardUpdateRequestDto requestDto){
        Board board = boardRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        board.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getCategories());
        return id;
    }

    // 게시글 삭제 기능
    @Transactional
    public void delete(Long id){
        Board board = boardRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        boardRepository.delete(board);
    }

    // 게시글 불러오기
    public BoardResponseDto findById (Long id){
        Board board = boardRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        board.increaseViewCount();
        return new BoardResponseDto(board);
    }

    //게시글 목록 불러오기
    @Transactional(readOnly = true)
    public List<BoardListResponseDto> findAllDesc(){
        return boardRepository.findAllDesc().stream()
                .map(BoardListResponseDto::new)
                .collect(Collectors.toList());
    }

}
