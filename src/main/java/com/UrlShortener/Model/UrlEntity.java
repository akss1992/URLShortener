package com.UrlShortener.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class UrlEntity {
    @Id
    private String id;
    @Lob
    private String inputUrl;
    @Lob
    private String shortenedUrl;

    public UrlEntity() {
    }

    public UrlEntity(String id, String inputUrl, String shortenedUrl) {
        this.id = id;
        this.inputUrl = inputUrl;
        this.shortenedUrl = shortenedUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInputUrl() {
        return inputUrl;
    }

    public void setInputUrl(String inputUrl) {
        this.inputUrl = inputUrl;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public void setShortenedUrl(String shortenedUrl) {
        this.shortenedUrl = shortenedUrl;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id='" + id + '\'' +
                ", inputUrl='" + inputUrl + '\'' +
                ", shortenedUrl='" + shortenedUrl + '\'' +
                '}';
    }
}
