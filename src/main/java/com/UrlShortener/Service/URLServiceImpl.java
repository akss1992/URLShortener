package com.UrlShortener.Service;

import com.UrlShortener.Model.UrlEntity;
import com.UrlShortener.Model.UrlRequest;
import com.UrlShortener.Repository.UrlRepository;
import com.google.common.hash.Hashing;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
@Component
public class URLServiceImpl implements URLService {
    @Autowired
    private UrlRepository urlRepository;
    @Override
    public UrlEntity generateShortenedLink(UrlRequest urlInput) {
        if(StringUtils.isNotEmpty(urlInput.getInputUrl()))
        {
            String UrlHashId = Hashing.adler32().
                    hashString(urlInput.getInputUrl(), StandardCharsets.UTF_8).toString();
            UrlEntity setInDb = new UrlEntity();
            setInDb.setId(UrlHashId);
            setInDb.setInputUrl(urlInput.getInputUrl());
            setInDb.setShortenedUrl("http://localhost:8080/" + UrlHashId);
            UrlEntity retUrlEntity = saveToStorage(setInDb);
            if(retUrlEntity != null)
            {
                return retUrlEntity;
            }
        }

        return null;
    }

    @Override
    public UrlEntity getOriginalLink(String id) {
        UrlEntity urlEntity = urlRepository.findByid(id);
        return urlEntity;
    }

    @Override
    public UrlEntity saveToStorage(UrlEntity urlEntity) {
        UrlEntity retUrlEntity = urlRepository.save(urlEntity);
        return retUrlEntity;
    }
}
