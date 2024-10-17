package com.example.articleapiapp.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class Article {
    private long id;
    @NotEmpty(message = "Description cannot be empty")
    private String description;

    @Positive(message = "Weight must be positive")
    private double weight;
    @Positive(message = "Volume must be positive")
    private long volume;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", volume=" + volume +
                '}';
    }
}
