package com.example.articleapiapp.service;

import com.example.articleapiapp.entity.Article;

import java.util.List;

public interface ArticleManager {
    void createArticle(Article article);

    void updateArticle(long id, Article updatedArticle);

    void deleteArticle(long id);

    List<Article> getAllArticles();
}
