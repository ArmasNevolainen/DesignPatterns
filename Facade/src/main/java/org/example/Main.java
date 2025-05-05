package org.example;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ApiFacade apiFacade = new ApiFacade();

        // Chuck Norris joke using the facade
        System.out.println("Chuck Norris Joke");
        try {
            String joke = apiFacade.getRandomJoke();
            System.out.println("Joke: " + joke);
        } catch (IOException e) {
            System.err.println("Error getting Chuck Norris joke: " + e.getMessage());
        }

        System.out.println("\n-----------------------------------\n");

        // Get exchange rate data using the facade
        System.out.println("Exchange Rate Data");
        try {
            String baseCurrency = apiFacade.getBaseCurrency();
            System.out.println("Base Currency: " + baseCurrency);
        } catch (IOException e) {
            System.err.println("Error getting exchange rate data: " + e.getMessage());
        }

        System.out.println("\n-----------------------------------\n");

        System.out.println("Exchange Rate Data - USD to AUD");
        try {
            String usdToAud = apiFacade.getUsdToAudRate();
            System.out.println("Exchange Rate: " + usdToAud);
        } catch (IOException e) {
            System.err.println("Error getting USD to AUD exchange rate: " + e.getMessage());
        }
    }
}