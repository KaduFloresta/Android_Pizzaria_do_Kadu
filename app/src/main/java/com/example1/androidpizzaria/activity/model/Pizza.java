package com.example1.androidpizzaria.activity.model;

import android.widget.TextView;

public class Pizza {

    private String nomePizza;
    private String ingredientesPizza;
    private String valorPizza;

    public Pizza(String nomePizza, String ingredientesPizza, String valorPizza) {
        this.nomePizza = nomePizza;
        this.ingredientesPizza = ingredientesPizza;
        this.valorPizza = valorPizza;
    }

    public Pizza(TextView nomePizza, TextView ingredientesPizza, TextView valorPizza) {
    }

    public String getNomePizza() {
        return nomePizza;
    }

    public void setNomePizza(String nomePizza) {
        this.nomePizza = nomePizza;
    }

    public String getIngredientesPizza() {
        return ingredientesPizza;
    }

    public void setIngredientesPizza(String ingredientesPizza) {
        this.ingredientesPizza = ingredientesPizza;
    }

    public String getValorPizza() {
        return valorPizza;
    }

    public void setValorPizza(String valorPizza) {
        this.valorPizza = valorPizza;
    }
}
