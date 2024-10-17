package com.example.articleapiapp.controller;


import com.example.articleapiapp.entity.Article;
import com.example.articleapiapp.service.ArticleManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleManager articleManager;


    @PostMapping("/create")
    public ResponseEntity<Void> createArticle(@Valid @RequestBody Article article) {
        articleManager.createArticle(article);
        return ResponseEntity.ok().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Void> updateArticle(@PathVariable long id, @RequestBody Article article) {
        articleManager.updateArticle(id, article);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        articleManager.deleteArticle(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get")
    public ResponseEntity<List<Article>> getAllArticles() {
        return ResponseEntity.ok(articleManager.getAllArticles());
    }
}
