package com.example1.androidpizzaria.activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example1.androidpizzaria.R;
import com.example1.androidpizzaria.activity.model.Pizza;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Pizza> {
    public Adapter(Context context, ArrayList<Pizza> pizzas) {
        super(context, 0, pizzas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pizza pizza = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_lista, parent, false);
        }

        TextView codigoPizza = (TextView) convertView.findViewById(R.id.txtCodigo);
        TextView nomePizza = (TextView) convertView.findViewById(R.id.txtNome);
        TextView tamanhoPizza = (TextView) convertView.findViewById(R.id.txtTamanho);
        TextView ingredientesPizza = (TextView) convertView.findViewById(R.id.txtIngredientes);
        TextView valorPizza = (TextView) convertView.findViewById(R.id.txtValor);

        codigoPizza.setText(pizza.getCódigoPizza());
        nomePizza.setText(pizza.getNomePizza());
        tamanhoPizza.setText("Tamanho: " + pizza.getTamanhoPizza());
        ingredientesPizza.setText(" " + pizza.getIngredientesPizza());
        valorPizza.setText("R$ " + pizza.getValorPizza());

        return convertView;
    }
}
