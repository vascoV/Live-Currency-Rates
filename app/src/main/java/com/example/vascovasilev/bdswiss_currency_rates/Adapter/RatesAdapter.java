package com.example.vascovasilev.bdswiss_currency_rates.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vascovasilev.bdswiss_currency_rates.Model.Price;
import com.example.vascovasilev.bdswiss_currency_rates.R;

import java.util.List;

public class RatesAdapter extends RecyclerView.Adapter<RatesViewHolder> {

    Context ctx;
    List<Price> priceList;

    public RatesAdapter(Context ctx, List<Price> priceList) {
        this.ctx = ctx;
        this.priceList = priceList;
    }

    @NonNull
    @Override
    public RatesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_layout, parent, false);
        return new RatesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RatesViewHolder holder, int position) {

        holder.txt_symbol.setText(String.valueOf(priceList.get(position).getSymbol()));
        holder.txt_rate.setText(String.valueOf(priceList.get(position).getPrice()));

        Log.d("Symbol: ", String.valueOf(priceList.get(position).getSymbol()));
        Log.d("Symbol: ", String.valueOf(priceList.get(position).getPrice()));

    }

    @Override
    public int getItemCount() {
        return priceList.size();
    }
}
