package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.demo.model.domain.Article;
import com.example.demo.model.service.BlogService;
import com.example.demo.model.service.AddArticleRequest;

@Controller
public class BlogController {
	
@Autowired
private BlogService blogService;

@GetMapping("/article_list") // 게시판 링크 지정
public String article_list(Model model) {
List<Article> list = blogService.findAll(); // 게시판 리스트
model.addAttribute("articles", list); // 모델에 추가
return "article_list"; // .HTML 연결
}
@PostMapping("/api/articles") // post 요청
public String addArticle(@ModelAttribute AddArticleRequest request) {
Article saveArticle = blogService.save(request); // 게시글 저장
return "redirect:/article_list"; // 게시판 목록으로 리다이렉트
}
}

