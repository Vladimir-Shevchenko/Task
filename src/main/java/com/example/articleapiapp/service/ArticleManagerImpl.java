package com.example.articleapiapp.service;

import com.example.articleapiapp.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleManagerImpl implements ArticleManager {

    private List<Article> articles = new ArrayList<>();

    private final IdGenerator idGenerator;

    @Autowired
    public ArticleManagerImpl(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public void createArticle(Article article) {
        article.setId(idGenerator.generateId());
        articles.add(article);
    }

    @Override
    public void updateArticle(long id, Article updatedArticle) {
        Optional<Article> existingArticle = articles.stream()
                .filter(article -> article.getId() == id)
                .findFirst();

        existingArticle.ifPresent(article -> {
            article.setDescription(updatedArticle.getDescription());
            article.setWeight(updatedArticle.getWeight());
            article.setVolume(updatedArticle.getVolume());
        });
    }

    @Override
    public void deleteArticle(long id) {
        articles.removeIf(article -> article.getId() == id);
    }

    public List<Article> getAllArticles() {
        return articles;
    }
}
