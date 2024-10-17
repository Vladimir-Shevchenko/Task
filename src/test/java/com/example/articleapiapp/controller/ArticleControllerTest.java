package com.example.articleapiapp.controller;

import com.example.articleapiapp.entity.Article;
import com.example.articleapiapp.service.ArticleManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ArticleControllerTest {

    @InjectMocks
    private ArticleController articleController;

    @Mock
    private ArticleManager articleManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createArticleShouldCallArticleManager() {
        Article article = new Article();
        article.setDescription("Test Article");
        article.setWeight(2.5);
        article.setVolume(10);

        ResponseEntity<Void> response = articleController.createArticle(article);

        assertEquals(200, response.getStatusCodeValue());
        verify(articleManager, times(1)).createArticle(article);
    }

    @Test
    public void updateArticleShouldCallArticleManager() {
        long id = 1;
        Article article = new Article();
        article.setDescription("Updated Article");
        article.setWeight(3.0);
        article.setVolume(15);

        ResponseEntity<Void> response = articleController.updateArticle(id, article);

        assertEquals(200, response.getStatusCodeValue());
        verify(articleManager, times(1)).updateArticle(eq(id), any(Article.class));
    }

    @Test
    public void deleteArticleShouldCallArticleManager() {
        long id = 1;

        ResponseEntity<Void> response = articleController.deleteArticle(id);

        assertEquals(200, response.getStatusCodeValue());
        verify(articleManager, times(1)).deleteArticle(id);
    }

    @Test
    public void getAllArticlesShouldReturnArticles() {
        List<Article> articles = new ArrayList<>();
        articles.add(new Article());
        when(articleManager.getAllArticles()).thenReturn(articles);

        ResponseEntity<List<Article>> response = articleController.getAllArticles();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
    }
}
