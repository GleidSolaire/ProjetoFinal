package com.example.projetofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {

    Button btnSalvar;

    EditText edtNome;
    EditText edtCategoria;
    EditText edtPreco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

           btnSalvar = findViewById(R.id.btnSalvar);
           edtNome = findViewById(R.id.edtNome);
           edtCategoria = findViewById(R.id.edtCategoria);
           edtPreco = findViewById(R.id.edtPreco);

        Intent intent = getIntent();

        final  int index = intent.getIntExtra("index", -1);

        if(index != -1) {

            Produto produto = ProdutosLista.GetProduto(index);

            edtNome.setText(produto.getNome());
            edtPreco.setText(produto.getPreco());
            edtCategoria.setText(produto.getCategoria());
        }

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = edtNome.getText().toString();
                String categoria = edtCategoria.getText().toString();
                String preco = edtPreco.getText().toString();

                Produto produto = new Produto(0, nome, categoria, preco);

                DAOProdutos dao = new DAOProdutos(Cadastro.this);

                if (index != -1) {

                    int id = ProdutosLista.GetProduto(index).getId();
                    produto.setId(id);

                    if (dao.EditarProduto(produto)) {
                        Toast.makeText(Cadastro.this, "Produto Editado! ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Cadastro.this, MainActivity.class));


                    } else {

                        Toast.makeText(Cadastro.this, "Erro Inesperado!", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent (Cadastro.this, MainActivity.class));


                    }


                }else {

                    if(dao.salvarProduto(produto)) {
                        Toast.makeText(Cadastro.this, "Produto Cadastrado!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Cadastro.this, MainActivity.class));

                    }else {
                        Toast.makeText(Cadastro.this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });

    }
}
