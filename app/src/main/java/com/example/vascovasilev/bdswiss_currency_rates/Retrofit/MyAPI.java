package com.example.vascovasilev.bdswiss_currency_rates.Retrofit;

import com.example.vascovasilev.bdswiss_currency_rates.Model.Price;
import com.example.vascovasilev.bdswiss_currency_rates.Model.PriceResponse;

import java.util.List;
import io.reactivex.Observable;

import retrofit2.http.GET;

public interface MyAPI {

    @GET("rates")
    Observable<PriceResponse> getRates();
}
