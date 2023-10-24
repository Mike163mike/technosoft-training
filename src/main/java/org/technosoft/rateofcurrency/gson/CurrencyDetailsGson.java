package org.technosoft.rateofcurrency.gson;

import com.google.gson.annotations.SerializedName;

public record CurrencyDetailsGson(
        @SerializedName("ID")
        String id,
        @SerializedName("NumCode")
        Integer numCode,
        @SerializedName("CharCode")
        String charCode,
        @SerializedName("Name")
        String name,
        @SerializedName("Value")
        Double value
) {
}
