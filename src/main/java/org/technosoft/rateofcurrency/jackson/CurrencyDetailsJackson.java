package org.technosoft.rateofcurrency.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CurrencyDetailsJackson(
        @JsonProperty("ID")
        String id,
        @JsonProperty("NumCode")
        Integer numCode,
        @JsonProperty("CharCode")
        String charCode,
        @JsonProperty("Name")
        String name,
        @JsonProperty("Value")
        Double value
) {
}
