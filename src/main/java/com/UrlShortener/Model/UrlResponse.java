package com.UrlShortener.Model;

public class UrlResponse {
    private String outputUrl;

    public UrlResponse(String outputUrl) {
        this.outputUrl = outputUrl;
    }

    public UrlResponse() {
    }
    public String getOutputUrl() {
        return outputUrl;
    }

    public void setOutputUrl(String outputUrl) {
        this.outputUrl = outputUrl;
    }

    @Override
    public String toString() {
        return "UrlResponse{" +
                "outputUrl='" + outputUrl + '\'' +
                '}';
    }
}
