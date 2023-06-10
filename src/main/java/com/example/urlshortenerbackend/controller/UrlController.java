package com.example.urlshortenerbackend.controller;

import com.example.urlshortenerbackend.model.Url;
import com.example.urlshortenerbackend.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("url/shortener")
@RequiredArgsConstructor
public class UrlController {
    private final UrlService urlService;

    @GetMapping("{id}")
    public String getOriginalUrl(@PathVariable String id) {
        return urlService.getOriginalUrl(id);
    }

    @PostMapping
    public Url generateShortUrl(@RequestBody String url) {
        return urlService.generateShortUrl(url);
    }
}
