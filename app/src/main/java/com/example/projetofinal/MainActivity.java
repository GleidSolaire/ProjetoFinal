package com.example.projetofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    RecyclerView rclProdutos;
    Button btnCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        rclProdutos = findViewById(R.id.rclProdutos);

        if(ProdutosLista.getListaProdutos().size() > 0 ) {

            ProdutosLista.getListaProdutos().clear();
        }

        DAOProdutos dao = new DAOProdutos(MainActivity.this);

        try {
            dao.getProdutos();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Adapter meuAdapter = new Adapter(MainActivity.this, ProdutosLista.getListaProdutos());
        RecyclerView.LayoutManager meuLayout = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

        rclProdutos.setAdapter(meuAdapter);
        rclProdutos.setLayoutManager(meuLayout);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Cadastro.class));
            }
        });

    }
}
