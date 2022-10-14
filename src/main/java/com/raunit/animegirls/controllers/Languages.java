package com.raunit.animegirls.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.raunit.animegirls.Utils;
import com.raunit.animegirls.models.Language;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Languages {

    @GetMapping("/")
    public List<Language> listAvailableLanguages() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(Utils.BASE_URL + "/contents")
                .build();
        Response rawResponse = null;
        List<Language> result = new ArrayList<>();

        try {
              rawResponse = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String languagesArray = rawResponse.body().string();
        JSONArray languages = new JSONArray(languagesArray);

        for (int i=0; i<languages.length(); i++) {
            JSONObject languageJson = languages.getJSONObject(i);
            result.add(new Language(languageJson.getString("name"), languageJson.getString("path")));
        }

        return result;
    }
}