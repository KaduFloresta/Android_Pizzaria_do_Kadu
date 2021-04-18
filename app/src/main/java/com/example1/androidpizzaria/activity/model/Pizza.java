package com.example1.androidpizzaria.activity.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Pizza implements Parcelable {
    private String códigoPizza;
    private String nomePizza;
    private String tamanhoPizza;
    private String ingredientesPizza;
    private String valorPizza;

    public Pizza(String códigoPizza,
                 String nomePizza,
                 String tamanhoPizza,
                 String ingredientesPizza,
                 String valorPizza) {
        this.códigoPizza = códigoPizza;
        this.nomePizza = nomePizza;
        this.tamanhoPizza = tamanhoPizza;
        this.ingredientesPizza = ingredientesPizza;
        this.valorPizza = valorPizza;
    }

    protected Pizza(Parcel in) {
        códigoPizza = in.readString();
        nomePizza = in.readString();
        ingredientesPizza = in.readString();
        tamanhoPizza = in.readString();
        valorPizza = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(códigoPizza);
        dest.writeString(nomePizza);
        dest.writeString(tamanhoPizza);
        dest.writeString(ingredientesPizza);
        dest.writeString(valorPizza);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pizza> CREATOR = new Creator<Pizza>() {
        @Override
        public Pizza createFromParcel(Parcel in) {
            return new Pizza(in);
        }

        @Override
        public Pizza[] newArray(int size) {
            return new Pizza[size];
        }
    };

    public String getCódigoPizza() {
        return códigoPizza;
    }

    public void setCódigoPizza(String códigoPizza) {
        this.códigoPizza = códigoPizza;
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

    public String getTamanhoPizza() {
        return tamanhoPizza;
    }

    public void setTamanhoPizza(String tamanhoPizza) {
        this.tamanhoPizza = tamanhoPizza;
    }

    public String getValorPizza() {
        return valorPizza;
    }

    public void setValorPizza(String valorPizza) {
        this.valorPizza = valorPizza;
    }
}


