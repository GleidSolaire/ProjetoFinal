package com.example.projetofinal;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder {

    TextView txtNome;
    TextView txtPreco;


    public Holder(@NonNull View itemView) {
        super(itemView);
        txtNome = itemView.findViewById(R.id.txtNome);

        txtPreco = itemView.findViewById(R.id.txtPreco);

    }




}
