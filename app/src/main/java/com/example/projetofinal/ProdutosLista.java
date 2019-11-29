package com.example.projetofinal;

import java.util.ArrayList;

public class ProdutosLista {


    private static ArrayList<Produto> listaProdutos = new ArrayList<>();

    public  static  void Add (Produto p)
    {
        listaProdutos.add(p);
    }

    public  static  Produto GetProduto (int index) {
        return  listaProdutos.get(index);
    }

    public  static  ArrayList<Produto> getListaProdutos(){
        return listaProdutos;
    }
}
