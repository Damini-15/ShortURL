package com.example.ShortURL.service;

import com.example.ShortURL.model.Chotaurl;
import com.example.ShortURL.repo.UrlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UrlService {
    @Autowired
    private UrlRepo urlRepo;

    public List<Chotaurl> read(){
        return urlRepo.findAll();
    }

    public Chotaurl readByID(long id){
        Optional<Chotaurl> ans = urlRepo.findById(id);
        return ans.get();
    }

    public Chotaurl create(Chotaurl shrtUrl){
        return urlRepo.save(shrtUrl);
    }

    public Chotaurl update(long id, Chotaurl newshrturl){
        Optional<Chotaurl> shrt = urlRepo.findById(id);
        Chotaurl oldshrt = shrt.get();

        oldshrt.setLongURL(newshrturl.getLongURL());
        return urlRepo.save(oldshrt);
    }

    public void delete(long id){
        urlRepo.deleteById(id);
    }
}
