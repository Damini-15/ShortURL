package com.example.ShortURL.repo;

import com.example.ShortURL.model.Chotaurl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepo extends JpaRepository<Chotaurl,Long> {

}
