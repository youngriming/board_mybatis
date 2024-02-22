package com.codingrecipe.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardFileDTO {
    private Long id;
    private Long boardId; // 이 파일은 어떤 게시글에 적용된 파일인지 확인하기 위한 아이디
    private String originalFileName; //사용자가 올린 원본 파일
    private String storedFileName; //저장을 위한 파일 이름
}
