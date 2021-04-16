package com.example1.androidpizzaria.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example1.androidpizzaria.R;
import com.example1.androidpizzaria.activity.model.Pizza;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    TextView nomePizza;
    TextView ingredientesPizza;
    TextView valorPizza;
    Button btnCadastrar;
    Button btnLimpar;
    List<Pizza> listaPizzas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(cadastrarPizza());
        btnLimpar = (Button) findViewById(R.id.btnLimpar);

//        // Listagem de Filmes
//        this.criarPizzas();

        // Evento botão LIMPAR campos
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nomePizza.setText(null);
                ingredientesPizza.setText(null);
                valorPizza.setText(null);
            }
        });
    }

    // Teste de Interface
//    public void criarPizzas() {
//        Pizza pizza = new Pizza("Pepperoni", "Mussarela, Pepperoni, Azeitona e Alho", "R$ 60.50");
//        listaPizzas.add(pizza);
//        pizza = new Pizza("CatuFrango", "Mussarela, Frango, Catupiry e Alho", "R$ 61.50");
//        listaPizzas.add(pizza);
//        pizza = new Pizza("Calabresa", "Mussarela e Calabresa", "R$ 60.50");
//        listaPizzas.add(pizza);
//        pizza = new Pizza("Portuguesa", "Mussarela, Presunto, Ovo, Cebola e Alho", "R$ 60.50");
//        listaPizzas.add(pizza);
//    }

    private View.OnClickListener cadastrarPizza() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nomePizza = (TextView) findViewById(R.id.txtNomePizza);
                nomePizza.getText().toString();
                ingredientesPizza = (TextView) findViewById(R.id.txtIngredientesPizza);
                ingredientesPizza.getText().toString();
                valorPizza = (TextView) findViewById(R.id.txtValorPizza);
                valorPizza.getText().toString();

                Pizza pizza = new Pizza(nomePizza, ingredientesPizza, valorPizza);
                listaPizzas.add(pizza);
                Intent intent = new Intent(MainActivity.this, DataActivity.class);
                startActivityForResult(intent, 2);
            }
        };
    }
}
