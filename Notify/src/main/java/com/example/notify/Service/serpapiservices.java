package com.example.notify.Service;

import java.util.Map;
import java.util.HashMap;


import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.notify.Entity.ApiDataResponse;

import com.fasterxml.jackson.databind.ObjectMapper;





@Service
public class serpapiservices {

    private final String apiUrl = "https://serpapi.com/search.json";
    private final String apiKey = "your api key";
    public String  Artist;
    public String City;

  





    public ApiDataResponse searchEvents() {
        String search_query = "Events of " + Artist + " in " + City;
        Map<String, String> parameters = new HashMap<>();
        parameters.put("q", search_query);
        parameters.put("google_domain", "google.com");
        parameters.put("hl", "en");

        try {
            return searchEvents(parameters);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }






    public ApiDataResponse searchEvents(Map<String, String> parameters) {
        parameters.put("api_key", apiKey);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                buildUrl(parameters),
                HttpMethod.GET,
                null,
                String.class);

        String jsonResponse = responseEntity.getBody();



        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonResponse, ApiDataResponse.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
            return null;
        }
    }        
    private String buildUrl(Map<String, String> parameters) {
        StringBuilder urlBuilder = new StringBuilder(apiUrl + "?");
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        return urlBuilder.toString();
    }

}
    

