package com.example.projetofinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class DAOProdutos {

    private Gateway gateway;

    public DAOProdutos(Context context){
        this.gateway = Gateway.getInstance(context);
    }

    public  boolean salvarProduto(Produto p) {

        ContentValues values = new ContentValues();

        values.put(Helper.NOME, p.getNome());
        values.put(Helper.CATEGORIA, p.getCategoria());
        values.put(Helper.PRECO, p.getPreco());
        long result = 0;

        try {
            result = gateway.getDb().insert(Helper.TABELA, null,values);

        }catch (Exception e) {
            e.printStackTrace();
        }

        if (result >  0 ){
            return true;
        }
        return false;
    }

    public  void getProdutos() {

        String sql = "SELECT *FROM " + Helper.TABELA;
        try {
            Cursor c = gateway.getDb().rawQuery(sql, null);

            c.moveToFirst();

            while (c != null) {

                int id = c.getInt(c.getColumnIndex(Helper.ID));
                String nome = c.getString(c.getColumnIndex(Helper.NOME));
                String categoria = c.getString(c.getColumnIndex(Helper.CATEGORIA));
                String preco = c.getString(c.getColumnIndex(Helper.PRECO));

                Produto p = new Produto(id,nome, categoria, preco);

                ProdutosLista.Add(p);

                c.moveToNext();
            }
            c.close();

        }catch (Exception we) {
            we.printStackTrace();
        }
    }

    public  boolean ExcluirProduto (int id) {
        String where = Helper.ID + " = ? ";
        String[] args = {String.valueOf(id)};

        long result = gateway.getDb().delete(Helper.TABELA, where,args);

        if (result > 0) {
            return  true;
        }
        return  false;
    }
  public  boolean EditarProduto(Produto p) {

        String where = Helper.ID + " = ? ";
        String args[] = {String.valueOf(p.getId())};

        ContentValues values = new ContentValues();
        values.put(Helper.NOME, p.getNome());
        values.put(Helper.CATEGORIA, p.getCategoria());
        values.put(Helper.PRECO, p.getPreco());

        long result = gateway.getDb().update(Helper.TABELA, values, where, args);


        if (result >= 0) {
            return  true;
        }

        return  false;
    }

 }
