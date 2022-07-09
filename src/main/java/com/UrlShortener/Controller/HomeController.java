package com.UrlShortener.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String HomePage() throws Exception{
        return "Home";
    }
}
