package com.example.ShortURL.model;

import jakarta.persistence.*;

@Entity
@Table(name="url_shortner")
public class Chotaurl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="long_url")
    private String LongURL;

    public Chotaurl(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLongURL() {
        return LongURL;
    }

    public void setLongURL(String longURL) {
        LongURL = longURL;
    }

}
