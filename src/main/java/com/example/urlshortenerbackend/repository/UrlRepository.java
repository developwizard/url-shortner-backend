package com.example.urlshortenerbackend.repository;

import com.example.urlshortenerbackend.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UrlRepository extends JpaRepository<Url, Integer> {
    @Query(value = "select originalUrl from Url where shortUrl = ?1")
    String findByShortUrl(String id);
}
