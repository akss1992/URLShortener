package com.UrlShortener.Model;

public class UrlRequest {
    private String inputUrl;

    public UrlRequest(String inputUrl) {
        this.inputUrl = inputUrl;
    }
    public UrlRequest(){

    }
    public String getInputUrl() {
        return inputUrl;
    }

    public void setInputUrl(String inputUrl) {
        this.inputUrl = inputUrl;
    }

    @Override
    public String toString() {
        return "UrlInput{" +
                "inputUrl='" + inputUrl + '\'' +
                '}';
    }
}
