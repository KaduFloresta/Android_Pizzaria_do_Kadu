package com.example1.androidpizzaria.activity.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example1.androidpizzaria.R;
import com.example1.androidpizzaria.activity.model.Pizza;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Pizza> listaPizzas;

    public Adapter(List<Pizza> lista) {
        this.listaPizzas = lista;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Convertendo em um objeto View
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_lista,
                parent,
                false
        );
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Pizza pizza = listaPizzas.get(position);
        holder.nomePizza.setText(pizza.getNomePizza().toString());
        holder.ingredientesPizza.setText(pizza.getIngredientesPizza().toString());
        holder.valorPizza.setText(pizza.getValorPizza().toString());

    }

    // Retorna a quantidade de itens
    @Override
    public int getItemCount() {
        return listaPizzas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nomePizza;
        TextView ingredientesPizza;
        TextView valorPizza;

        public MyViewHolder(View itemView) {
            super(itemView);

            nomePizza = itemView.findViewById(R.id.txtNome);
            ingredientesPizza = itemView.findViewById(R.id.txtIngredientes);
            valorPizza = itemView.findViewById(R.id.txtValor);
        }
    }
}
