package com.example.ShortURL.controller;

import com.example.ShortURL.model.Chotaurl;
import com.example.ShortURL.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/damini")
public class Ctrl {
    @Autowired
    private UrlService urlService;

    @GetMapping("ping")
    public String ping(){
        return "pong";
    }

    @GetMapping("")
    public List<Chotaurl> read(){
        return urlService.read();
    }

    @GetMapping("{id}")
    public Chotaurl readByID(@PathVariable(value="id")long id){
        return urlService.readByID(id);
    }

    @PostMapping("")
    public Chotaurl create(@RequestBody Chotaurl shrtUrl){
        return urlService.create(shrtUrl);
    }

    @PutMapping("{id}")
    public Chotaurl update(@PathVariable(value="id")long id, @RequestBody Chotaurl body)
    {
        return urlService.update(id,body);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable(value="id") long id){
        urlService.delete(id);
        return "Deleted";
    }

    @GetMapping("chotaURL/{id}")
    public ResponseEntity<Void> redirect(@PathVariable(value="id") long id){
        urlService.incrementCounter(id);
        Chotaurl chotaurl=urlService.readByID(id);
        String longUrl = chotaurl.getLongURL();
        if (!longUrl.startsWith("http://") && !longUrl.startsWith("https://")) {
            longUrl = "https://" + longUrl;
        }
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(longUrl))
                .build();

    }


}
