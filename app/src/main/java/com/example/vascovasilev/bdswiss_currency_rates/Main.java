package com.example.vascovasilev.bdswiss_currency_rates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.vascovasilev.bdswiss_currency_rates.Adapter.RatesAdapter;
import com.example.vascovasilev.bdswiss_currency_rates.Model.PriceResponse;
import com.example.vascovasilev.bdswiss_currency_rates.Retrofit.MyAPI;
import com.example.vascovasilev.bdswiss_currency_rates.Retrofit.RetrofitClient;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class Main extends AppCompatActivity {

    MyAPI myAPI;
    RecyclerView rcView;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing the API
        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(MyAPI.class);
        
        // the View
        rcView = (RecyclerView) findViewById(R.id.recycler_view);
        rcView.setHasFixedSize(true);
        rcView.setLayoutManager(new LinearLayoutManager(this));
        
        fetchData();
    }

    private void fetchData() {
        compositeDisposable.add(myAPI.getRates()
        .subscribeOn(Schedulers.io())
        .delay(10000, TimeUnit.MILLISECONDS)
        .repeat()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<PriceResponse>() {
            @Override
            public void accept(PriceResponse rates) throws Exception {
                displayData(rates);
            }
        }));
    }

    private void displayData(PriceResponse priceResponse) {
        RatesAdapter adapter = new RatesAdapter(this, priceResponse.getRates());
        rcView.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}
