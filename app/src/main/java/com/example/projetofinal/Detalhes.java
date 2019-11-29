package com.example.projetofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Detalhes extends AppCompatActivity {

    TextView txtVerNome;
    TextView txtVerPreco;
    TextView txtVerCategoria;
    Button btnEditar;
    Button btnExcluir;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        txtVerNome = findViewById(R.id.txtVerNome);
        txtVerCategoria = findViewById(R.id.txtVerCategoria);
        txtVerPreco = findViewById(R.id.txtVerPreco);

        btnEditar = findViewById(R.id.btnEditar);
        btnExcluir = findViewById(R.id.btnExcluir);

        final Intent detalhes = getIntent();

        final int index = detalhes.getIntExtra("index", -1);

        if(index == -1) {
            Toast.makeText(this, "Erro ao cadastrar detalhes!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Detalhes.this, MainActivity.class));
        }else{
            Produto produto = ProdutosLista.GetProduto(index);

            txtVerNome.setText("Nome do Produto: "+produto.getNome());
            txtVerCategoria.setText("Categoria do Produto: "+produto.getCategoria());
            txtVerPreco.setText("Preço do Produto R$: "+produto.getPreco());
            id = produto.getId();

            btnEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent editar = new Intent(Detalhes.this, Cadastro.class);
                    editar.putExtra("index", index);
                    startActivity(editar);
                }
            });
        }

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DAOProdutos dao = new DAOProdutos(Detalhes.this);

                if(dao.ExcluirProduto(id)){
                    Toast.makeText(Detalhes.this, "Produto Excluido!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent( Detalhes.this, MainActivity.class));
                }
                else {
                    Toast.makeText(Detalhes.this, "Erro ao Excluir Produto!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
