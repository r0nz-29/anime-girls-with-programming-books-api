package com.raunit.animegirls.controllers;

import com.raunit.animegirls.Utils;
import com.raunit.animegirls.models.Image;
import com.raunit.animegirls.models.Language;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RestController
public class Images {

    @GetMapping("/{language}")
    public List<Image> getAllImagesOfALanguage(@PathVariable String language) throws IOException {
        List<Image> downloadLinks = new ArrayList<>();
        language = language.substring(0, 1).toUpperCase() + language.substring(1);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(Utils.BASE_URL + "/contents/" + language)
                .build();

        Response rawResponse = null;

        try {
            rawResponse = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String rawArray = rawResponse.body().string();

        if (rawArray.contains("Not Found")) {
            return Collections.emptyList();
        }

        JSONArray imageDetails = new JSONArray(rawArray);

        for (int i=0; i<imageDetails.length(); i++) {
            JSONObject imageDetail = imageDetails.getJSONObject(i);

            downloadLinks.add(new Image(
                    imageDetail.getString("name"),
                    imageDetail.getString("download_url")
            ));
        }

        return downloadLinks;
    }

    @GetMapping("/{language}/random")
    public Image getRandomImageOfLanguage(@PathVariable String language) throws IOException {
        List<Image> images = this.getAllImagesOfALanguage(language);

        return images.get(Utils.randomIntBetween(0, images.size()));
    }

    @GetMapping("/random")
    public Image getRandomImage() throws IOException {
        Languages controller = new Languages();
        List<Language> languages = controller.listAvailableLanguages();

        return getRandomImageOfLanguage(languages.get(Utils.randomIntBetween(0, languages.size())).name);
    }
}
