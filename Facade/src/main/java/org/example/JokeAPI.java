package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JokeAPI {
    private static final String API_URL = "https://api.chucknorris.io/jokes/random";

    public String fetchRandomJoke() throws IOException {
        String jsonResponse = sendGetRequest(API_URL);
        return extractJokeFromJson(jsonResponse);
    }

    private String sendGetRequest(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try {
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("HTTP request failed with response code: " + responseCode);
            }

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            }
        } finally {
            connection.disconnect();
        }
    }

    private String extractJokeFromJson(String json) throws IOException {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);

            if (!jsonObject.containsKey("value")) {
                throw new IOException("Joke not found in response");
            }

            return (String) jsonObject.get("value");
        } catch (ParseException e) {
            throw new IOException("Failed to parse JSON response", e);
        }
    }
}
