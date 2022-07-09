package com.UrlShortener.Controller;

import com.UrlShortener.Model.UrlEntity;
import com.UrlShortener.Model.UrlRequest;
import com.UrlShortener.Model.UrlResponse;
import com.UrlShortener.Service.URLService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class UrlShorteningController {
    @Autowired
    private URLService urlService;

    @PostMapping("/generate")
    public ResponseEntity<?> GenerateShortenedLink(@RequestBody UrlRequest urlRequest){
        UrlEntity retUrlEntity = urlService.generateShortenedLink(urlRequest);

        if(retUrlEntity != null)
        {
            UrlResponse urlResponse = new UrlResponse();
            urlResponse.setOutputUrl(retUrlEntity.getShortenedUrl());
            return new ResponseEntity<UrlResponse>(urlResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GenerateShortenedLink(HttpServletResponse response, @PathVariable String id) throws IOException {
        if(StringUtils.isEmpty(id))
        {
            return new ResponseEntity<>("The short link doesn't exist.", HttpStatus.BAD_REQUEST);
        }
        UrlEntity urlResponseEntity = urlService.getOriginalLink(id);

        if(urlResponseEntity == null)
        {
            return new ResponseEntity<>("The short link doesn't exist.", HttpStatus.BAD_REQUEST);
        }

        response.sendRedirect(urlResponseEntity.getInputUrl());
        return null;
    }

}
