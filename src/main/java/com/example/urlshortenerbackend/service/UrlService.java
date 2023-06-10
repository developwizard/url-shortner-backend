package com.example.urlshortenerbackend.service;

import com.example.urlshortenerbackend.model.Url;
import com.example.urlshortenerbackend.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.urlshortenerbackend.utils.UrlUtils.getShortUrl;
import static com.example.urlshortenerbackend.utils.UrlUtils.isUrlValid;

@Service
@RequiredArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;

    public String getOriginalUrl(String id) {
        return urlRepository.findByShortUrl(id);
    }

    public Url generateShortUrl(String url) {
        if(!isUrlValid(url)) {
            System.out.println("Url is not valid");
        }

        Url urlObject = new Url();
        urlObject.setOriginalUrl(url);
        urlObject.setShortUrl(getShortUrl(url));

        return urlRepository.save(urlObject);
    }
}
