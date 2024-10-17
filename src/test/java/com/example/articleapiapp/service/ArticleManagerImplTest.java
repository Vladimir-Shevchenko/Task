package com.example.articleapiapp.service;

import com.example.articleapiapp.entity.Article;
import com.example.articleapiapp.service.ArticleManagerImpl;
import com.example.articleapiapp.service.IdGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ArticleManagerImplTest {

    @InjectMocks
    private ArticleManagerImpl articleManager;

    @Mock
    private IdGenerator idGenerator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createArticleShouldAddArticle() {
        Article article = new Article();
        article.setDescription("New Article");
        article.setWeight(1.0);
        article.setVolume(100);
        when(idGenerator.generateId()).thenReturn(1L);

        articleManager.createArticle(article);

        List<Article> articles = articleManager.getAllArticles();
        assertEquals(1, articles.size());
        assertEquals("New Article", articles.get(0).getDescription());
    }

    @Test
    public void updateArticleShouldUpdateExistingArticle() {
        Article article = new Article();
        article.setDescription("Existing Article");
        article.setWeight(1.0);
        article.setVolume(100);
        when(idGenerator.generateId()).thenReturn(1L);
        articleManager.createArticle(article);

        Article updatedArticle = new Article();
        updatedArticle.setDescription("Updated Article");
        updatedArticle.setWeight(2.0);
        updatedArticle.setVolume(200);

        articleManager.updateArticle(1, updatedArticle);

        Article existingArticle = articleManager.getAllArticles().get(0);
        assertEquals("Updated Article", existingArticle.getDescription());
        assertEquals(2.0, existingArticle.getWeight());
        assertEquals(200, existingArticle.getVolume());
    }

    @Test
    public void deleteArticleShouldRemoveArticle() {
        Article article = new Article();
        article.setDescription("Article to delete");
        article.setWeight(1.0);
        article.setVolume(100);
        when(idGenerator.generateId()).thenReturn(1L);
        articleManager.createArticle(article);

        articleManager.deleteArticle(1);

        assertTrue(articleManager.getAllArticles().isEmpty());
    }

    @Test
    public void getAllArticlesShouldReturnListOfArticles() {
        Article article1 = new Article();
        article1.setDescription("Article 1");
        article1.setWeight(1.0);
        article1.setVolume(100);
        when(idGenerator.generateId()).thenReturn(1L);
        articleManager.createArticle(article1);

        Article article2 = new Article();
        article2.setDescription("Article 2");
        article2.setWeight(2.0);
        article2.setVolume(200);
        when(idGenerator.generateId()).thenReturn(2L);
        articleManager.createArticle(article2);

        List<Article> articles = articleManager.getAllArticles();
        assertEquals(2, articles.size());
    }
}
