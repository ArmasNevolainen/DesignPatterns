package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.simple.JSONObject; // add Maven dependency for JSON.simple
import org.json.simple.parser.JSONParser; // add Maven dependency for JSON.simple
import org.json.simple.parser.ParseException;

public class ApiFacade {
    private final JokeAPI jokeAPI;
    private final ExchangeAPI exchangeAPI;

    public ApiFacade() {
        this.jokeAPI = new JokeAPI();
        this.exchangeAPI = new ExchangeAPI();
    }


    public String getRandomJoke() throws IOException {
        return jokeAPI.fetchRandomJoke();
    }


    public String getBaseCurrency() throws IOException {
        return exchangeAPI.fetchBaseCurrency();
    }

    public String getUsdToAudRate() throws IOException {
        return exchangeAPI.fetchUsdToAudRate();
    }

}