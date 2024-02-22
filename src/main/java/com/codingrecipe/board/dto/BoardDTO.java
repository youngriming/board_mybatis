package com.codingrecipe.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class BoardDTO {
    private Long id;  //글번호
    private String boardWriter;  //작성자
    private String boardPass; //글 비밀번호
    private String boardTitle; //제목
    private String boardContents; //내용
    private int boardHits; //조회수
    private String createdAt; //작성시간
    private int fileAttached; // 첨부파일의 유무 구분
    private MultipartFile boardFile; // 파일 자체를 담기 위한 필드
}
