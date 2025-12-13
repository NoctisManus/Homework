package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.domain.Article;
import com.example.demo.model.service.AddArticleRequest;
import com.example.demo.model.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
@RequiredArgsConstructor
@RestController // @Controller + @ResponseBody
public class BlogRestController {
private final BlogService blogService;
@GetMapping("/favicon.ico")
public void favicon() {
// 아무 작업도 하지 않음
}
// @PostMapping("/api/articles") // post 요청
// public RedirectView addArticle(@ModelAttribute AddArticleRequest request) {
// Article saveArticle = blogService.save(request); // 게시글 저장
// return new RedirectView("/article_list"); // 게시판 목록으로 리다이렉트
// }
}

