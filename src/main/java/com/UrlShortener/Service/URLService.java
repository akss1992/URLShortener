package com.UrlShortener.Service;

import com.UrlShortener.Model.UrlEntity;
import com.UrlShortener.Model.UrlRequest;
import org.springframework.stereotype.Service;

@Service
public interface URLService {
    public UrlEntity generateShortenedLink(UrlRequest urlInput);
    public UrlEntity getOriginalLink(String id);
    public UrlEntity saveToStorage(UrlEntity urlEntity);
}
