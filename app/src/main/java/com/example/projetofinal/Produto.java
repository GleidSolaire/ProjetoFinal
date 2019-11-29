package com.example.projetofinal;

public class Produto {

    private int Id;
    private  String Nome;
    private  String Categoria;
    private  String Preco;

    public Produto(int id, String nome, String categoria, String preco) {
        Id = id;
        Nome = nome;
        Categoria = categoria;
        Preco = preco;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getPreco() {
        return Preco;
    }

    public void setPreco(String preco) {
        Preco = preco;
    }
}
