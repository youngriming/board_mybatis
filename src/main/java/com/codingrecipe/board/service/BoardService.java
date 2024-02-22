package com.codingrecipe.board.service;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.dto.BoardFileDTO;
import com.codingrecipe.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }
    public void save(BoardDTO boardDTO) throws IOException {
        if(boardDTO.getBoardFile().isEmpty()){ //첨부된 파일이 없으면
            boardDTO.setFileAttached(0);
            boardRepository.save(boardDTO);
        } else{
            boardDTO.setFileAttached(1);
            BoardDTO saveBoard = boardRepository.save(boardDTO); // 게시글 저장 후 id값 활용을 위한 리턴 받음
            MultipartFile boardFile = boardDTO.getBoardFile(); //파일만 따로 가져오기
            String originalFilename = boardFile.getOriginalFilename(); // 파일 이름 가져오기
            System.out.println("originalFileName = "+ originalFilename);
            System.out.println(System.currentTimeMillis()); // 저장용 이름 만들기 위한 시간 로그 찍기
            String storedFileName = System.currentTimeMillis() +"-"+originalFilename; // 저장용 이름은 시간 + 원본이름
            System.out.println("storedFileName = "+storedFileName);
            BoardFileDTO boardFileDTO = new BoardFileDTO();
            boardFileDTO.setOriginalFileName(originalFilename);
            boardFileDTO.setStoredFileName(storedFileName);
            boardFileDTO.setBoardId(saveBoard.getId());
            //파일 저장용 폴더에 파일 저장 처리
            String savePath = "/Users/youngriming/Desktop/Practice/"+storedFileName;
            boardFile.transferTo(new File(savePath));
            boardRepository.saveFile(boardFileDTO);
        }
    }
    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public BoardDTO findById(Long id) {
        return boardRepository.findById(id);
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }

    public BoardFileDTO findFile(Long id) {
        return boardRepository.findFile(id);
    }
}
