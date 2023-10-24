package org.technosoft.rateofcurrency.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CurrencyJackson(
        @JsonProperty("Date")
        ZonedDateTime date,
//        @JsonProperty("Date")
//        String date,
        @JsonProperty("Timesstamp")
        String timeStamp,
        @JsonProperty("Valute")
        Map<String, CurrencyDetailsJackson> valutes
) {

    public Optional<CurrencyDetailsJackson> findByCode(String code) {
        return Optional.ofNullable(valutes.get(code));
    }
}
