package com.example.demo.model.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.domain.Article;
import com.example.demo.model.domain.Board;
import com.example.demo.model.repository.BlogRepository;
import com.example.demo.model.repository.BoardRepository;
import com.example.demo.model.service.AddArticleRequest;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor // 생성자 자동 생성(부분)
public class BlogService {
@Autowired // 객체 주입 자동화, 생성자 1개면 생략 가능
private final BlogRepository blogRepository; // 리포지토리 선언
@Autowired
private final BoardRepository boardRepository; // Board 리포지토리 선언
public List<Article> findAll() { // 게시판 전체 목록 조회
return blogRepository.findAll();
}
public Article save(AddArticleRequest request){
// DTO가 없는 경우 이곳에 직접 구현 가능
// public ResponseEntity<Article> addArticle(@RequestParam String title, @RequestParam String content) {
// Article article = Article.builder()
// .title(title)
// .content(content)
// .build();
return blogRepository.save(request.toEntity());
}
public Optional<Article> findById(Long id) { // 게시판 특정 글 조회
return blogRepository.findById(id);
}
public List<Board> findAllBoard() { // Board 게시판 전체 목록 조회
return boardRepository.findAll();
}
public Optional<Board> findByIdBoard(Long id) { // Board 게시판 특정 글 조회
return boardRepository.findById(id);
}
public void update(Long id, AddArticleRequest request) {
Optional<Article> optionalArticle = blogRepository.findById(id); // 단일 글 조회
optionalArticle.ifPresent(article -> { // 값이 있으면
article.update(request.getTitle(), request.getContent()); // 값을 수정
blogRepository.save(article); // Article 객체에 저장
});
}
public void delete(Long id) {
blogRepository.deleteById(id);
}
public void updateBoard(Long id, AddArticleRequest request) {
Optional<Board> optionalBoard = boardRepository.findById(id); // 단일 글 조회
optionalBoard.ifPresent(board -> { // 값이 있으면
board.update(request.getTitle(), request.getContent()); // 값을 수정
// 추가된 필드가 null을 허용하지 않으므로 기존 값 유지
// board.getUser(), board.getNewdate(), board.getCount(), board.getLikec()는 그대로 유지됨
boardRepository.save(board); // Board 객체에 저장 (기존 필드 값 유지)
});
}
public void deleteBoard(Long id) {
boardRepository.deleteById(id);
}
}

