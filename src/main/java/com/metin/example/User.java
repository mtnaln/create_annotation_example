package com.metin.example;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class User {

    private String username;
    private List<String> authorities = new ArrayList<String>();

    public User() {

        username = "yusuf.alniacik";

        authorities.add("ADD_PERSONEL");
        authorities.add("DISPLAY_PERSONEL");
        authorities.add("REPORT_PERSONEL");
        authorities.add("TASK");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }
}
