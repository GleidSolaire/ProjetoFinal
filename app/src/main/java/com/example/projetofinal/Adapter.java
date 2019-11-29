package com.example.projetofinal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Produto> listaprodutos;

    public Adapter(Context context, ArrayList<Produto> listaprodutos) {
        this.context = context;
        this.listaprodutos = listaprodutos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.celula_produto, parent,false);
                Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Holder pHolder = (Holder) holder;

        String nome = listaprodutos.get(position).getNome();
        String preco = listaprodutos.get(position).getPreco();
        pHolder.txtNome.setText(nome);
        pHolder.txtPreco.setText("R$ "+preco);

        pHolder.txtNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detalhes = new Intent(context, Detalhes.class);
                detalhes.putExtra("index", position);

                detalhes.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(detalhes);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaprodutos.size();
    }
}
