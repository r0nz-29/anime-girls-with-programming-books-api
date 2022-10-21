//package com.raunits.animegirls.controllers;
//
//import com.raunits.animegirls.models.Image;
//import com.raunits.animegirls.models.ImageDetails;
//import com.raunits.animegirls.models.Language;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class PopulateDB {
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @GetMapping("/create")
//    public void createTable() {
//        jdbcTemplate.execute("CREATE TABLE Images(id SERIAL PRIMARY KEY, filename text NOT NULL, link text NOT NULL, category text NOT NULL)");
//    }
//
//    @GetMapping("/run")
//    public List<Image> runQuery() {
//
//        return new ArrayList<>(jdbcTemplate
//                .query(
//                        "SELECT * FROM Images",
//                        (rs, rowNum) -> new Image(rs.getString("link"), rs.getString("category"), rs.getString("filename"))
//                ));
//    }
//
//    @GetMapping("/populate")
//    public String populate() throws IOException {
//        Languages controller = new Languages();
//        List<Language> languages = controller.listAvailableLanguages();
//
//        Images imageController = new Images();
//
//        for (Language language : languages) {
//            List<ImageDetails> imagesOfLang = imageController.getAllImagesOfALanguage(language.path);
//
//            for (ImageDetails img : imagesOfLang) {
//                jdbcTemplate
//                        .update(
//                                "INSERT INTO Images(filename, link, category) VALUES (?,?,?)",
//                                new Object[]{img.name, img.image, language.path}
//                        );
//            }
//            System.out.println("Done " + language.path);
//        }
//
//        return "Done. All Ok";
//    }
//
//}
