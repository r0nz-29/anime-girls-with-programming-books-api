package com.raunits.animegirls.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Languages {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public List<String> listAvailableLanguages() {
        String query = new StringBuilder().append("SELECT DISTINCT ON (category) ").append("category").append(" FROM Images").toString();

        return new ArrayList<>(jdbcTemplate.query(query, (rs, rowNum) -> rs.getString("category")));
    }
}