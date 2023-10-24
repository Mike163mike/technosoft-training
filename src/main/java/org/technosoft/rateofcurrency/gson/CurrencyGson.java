package org.technosoft.rateofcurrency.gson;

import com.google.gson.annotations.SerializedName;

import java.util.Map;
import java.util.Optional;

public record CurrencyGson(
        @SerializedName("Date")
//        ZonedDateTime date,
        String date,
        @SerializedName("Timestamp")
        String timeStamp,
        @SerializedName("Valute")
        Map<String, CurrencyDetailsGson> valutes
) {

    public Optional<CurrencyDetailsGson> findByCode(String code) {
        return Optional.ofNullable(valutes.get(code));
    }
}
