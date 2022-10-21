package com.raunits.animegirls.controllers;

import com.raunits.animegirls.models.Image;
import com.raunits.animegirls.models.LanguageCover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Images {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/{language}")
    public List<Image> getAllImagesOfALanguage(@PathVariable String language) {
        String sql = new StringBuilder().append("SELECT filename, link, category FROM Images WHERE category='").append(language).append("'").toString();
        System.out.println(sql);
        return new ArrayList<>(jdbcTemplate.query(sql, (rs, rowNum) -> new Image(rs.getString("link"), rs.getString("category"), rs.getString("filename"))));
    }

    @GetMapping("/{language}/random")
    public Image getRandomImageOfLanguage(@PathVariable String language) {
        if (language.isEmpty()) {
            return null;
        }
        String sql = new StringBuilder().append("SELECT filename, link, category FROM Images WHERE category='").append(language).append("'").append(" ORDER BY RANDOM() LIMIT 1").toString();
        System.out.println(sql);
        return new ArrayList<>(jdbcTemplate.query(sql, (rs, n) -> new Image(rs.getString("link"), rs.getString("category"), rs.getString("filename")))).get(0);
    }

    @GetMapping("/random")
    public Image getRandomImage() {
        String sql = new StringBuilder().append("SELECT filename, link, category FROM Images WHERE category=(SELECT category FROM Images ORDER BY RANDOM() LIMIT 1) ORDER BY RANDOM() LIMIT 1").toString();
        System.out.println(sql);
        return new ArrayList<>(jdbcTemplate.query(sql, (result, n) -> new Image(result.getString("link"), result.getString("category"), result.getString("filename")))).get(0);
    }

    @GetMapping("/covers")
    public List<LanguageCover> getCovers() {
        String sql = new StringBuilder().append("SELECT DISTINCT ON (category) filename, link, category FROM Images").toString();
        return new ArrayList<>(jdbcTemplate.query(sql, (result, n) -> new LanguageCover(result.getString("category"), new Image(result.getString("link"), result.getString("category"), result.getString("filename")))));
    }

    @GetMapping("/{language}/cover")
    public LanguageCover getLanguageWithRandomCover(@PathVariable String language) {
        return new LanguageCover(language, this.getRandomImageOfLanguage(language));
    }

    @GetMapping("/search/{term}")
    public List<Image> search(@PathVariable String term) {
        String sql = new StringBuilder().append("SELECT filename, link, category FROM Images WHERE LOWER(filename) LIKE '%").append(term.toLowerCase()).append("%'").toString();
        System.out.println(sql);
        return new ArrayList<>(jdbcTemplate.query(sql, (result, n) -> new Image(result.getString("link"), result.getString("category"), result.getString("filename"))));
    }
}
