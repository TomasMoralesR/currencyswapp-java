package com.currencyswapp.api;

import com.currencyswapp.exception.UnableToLoadApiKey;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**This class handles fetching exchange rates from ExchangeRate-API*/
public class ExchangeRate {

    private static final String API_KEY = loadApiKey();
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private static String loadApiKey() {
        try {
            Dotenv dotenv = Dotenv.load();
            String apiKey = dotenv.get("API_KEY");

            if (apiKey == null || apiKey.isBlank()) {
                throw new UnableToLoadApiKey("API_KEY not found in .env file");
            }

            return apiKey;
        } catch (Exception e) {
            throw new UnableToLoadApiKey("Error loading the .env file or reading the API_KEY", e);
        }
    }

    /**
     * Retrieves the converted amount from the exchange API.
     *
     * @param base   Base currency (e.g., "USD")
     * @param target Target currency (e.g., "EUR")
     * @param amount Amount to convert
     * @return Converted amount or 0 if an error occurs
     */
    public double getConvertedAmount(String base, String target, double amount) {
        String url = BASE_URL + API_KEY + "/pair/" + base + "/" + target + "/" + amount;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

            if ("success".equals(json.get("result").getAsString()) && json.has("conversion_result")) {
                return json.get("conversion_result").getAsDouble();  // Directly returning the converted amount
            } else {
                System.err.println("Error in API response: " + json);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error connecting to the API: " + e.getMessage());
        }

        return 0;
    }
}
