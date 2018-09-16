package com.example.vascovasilev.bdswiss_currency_rates.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.vascovasilev.bdswiss_currency_rates.R;

public class RatesViewHolder extends RecyclerView.ViewHolder {

    TextView txt_symbol, txt_rate;

    public RatesViewHolder(@NonNull View itemView) {
        super(itemView);

        txt_symbol = (TextView) itemView.findViewById(R.id.txt_symbol);
        txt_rate = (TextView) itemView.findViewById(R.id.txt_rate);
    }
}
