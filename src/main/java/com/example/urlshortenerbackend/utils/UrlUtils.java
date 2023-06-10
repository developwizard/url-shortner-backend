package com.example.urlshortenerbackend.utils;

import com.google.common.hash.Hashing;
import org.apache.commons.validator.routines.UrlValidator;

import java.nio.charset.Charset;

public class UrlUtils {
    public static String getShortUrl(String url) {
        return Hashing.murmur3_32_fixed().hashString(url, Charset.defaultCharset()).toString();
    }

    public static boolean isUrlValid(String url) {
        return UrlValidator.getInstance().isValid(url);
    }
}
