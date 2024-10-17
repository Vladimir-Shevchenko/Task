package com.example.articleapiapp.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class IdGenerator {
    private final AtomicLong counter = new AtomicLong();

    public long generateId() {
        return counter.incrementAndGet();
    }
}
