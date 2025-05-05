package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeAPI {
    private static final String API_URL = "https://api.fxratesapi.com/latest";
    private static final String API_URL_WITH_BASE = "https://api.fxratesapi.com/latest?base=USD";

    public String fetchBaseCurrency() throws IOException {
        String jsonResponse = sendGetRequest(API_URL);
        return extractBaseCurrencyFromJson(jsonResponse);
    }

    public String fetchUsdToAudRate() throws IOException {
        String jsonResponse = sendGetRequest(API_URL_WITH_BASE);
        return extractUsdToAudRateFromJson(jsonResponse);
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

    private String extractBaseCurrencyFromJson(String json) throws IOException {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);

            if (!jsonObject.containsKey("base")) {
                throw new IOException("Base currency not found in response");
            }

            return (String) jsonObject.get("base");
        } catch (ParseException e) {
            throw new IOException("Failed to parse JSON response", e);
        }
    }

    private String extractUsdToAudRateFromJson(String json) throws IOException {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);

            if (!jsonObject.containsKey("rates")) {
                throw new IOException("Rates not found in response");
            }

            JSONObject rates = (JSONObject) jsonObject.get("rates");
            if (!rates.containsKey("AUD")) {
                throw new IOException("AUD rate not found in response");
            }

            Object audRate = rates.get("AUD");
            return "1 USD = " + audRate + " AUD";
        } catch (ParseException e) {
            throw new IOException("Failed to parse JSON response", e);
        }
    }
}
