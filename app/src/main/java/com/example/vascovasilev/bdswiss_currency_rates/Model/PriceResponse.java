package com.example.vascovasilev.bdswiss_currency_rates.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PriceResponse {

    @SerializedName("rates")
    private List<Price> rates;

    public PriceResponse() {
    }

    public List<Price> getRates() {
        return rates;
    }

    public void setRates(List<Price> rates) {
        this.rates = rates;
    }
}
