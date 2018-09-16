package com.example.vascovasilev.bdswiss_currency_rates.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Price {

    @SerializedName("symbol")
    @Expose
    private String symbol;

    @SerializedName("price")
    @Expose
    private double price;

    public Price(){
    }


    public Price(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }
}
