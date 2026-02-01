package com.example.ShortURL.controller;

import com.example.ShortURL.model.Chotaurl;
import com.example.ShortURL.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
