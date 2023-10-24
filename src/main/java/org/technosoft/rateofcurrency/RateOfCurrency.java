package org.technosoft.rateofcurrency;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RateOfCurrency {

    private static final Logger LOGGER = LoggerFactory.getLogger(RateOfCurrency.class);

    private final String url = "https://www.cbr-xml-daily.ru/daily_json.js";

    public String getCurrencies() {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = httpClient
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());
            LOGGER.info("""
                    
                    Status: {}
                    URI: {}
                    """, httpResponse.statusCode(), httpResponse.uri());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return httpResponse.body();
    }
}
