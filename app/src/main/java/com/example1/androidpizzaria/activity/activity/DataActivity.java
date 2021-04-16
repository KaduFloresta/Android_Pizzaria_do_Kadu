package com.example1.androidpizzaria.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.example1.androidpizzaria.R;
import com.example1.androidpizzaria.activity.Adapter.Adapter;
import com.example1.androidpizzaria.activity.RecyclerItemClickListener;
import com.example1.androidpizzaria.activity.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class DataActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Pizza> listaPizzas = new ArrayList<>();
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        recyclerView = findViewById(R.id.recyclerPizzas);


        btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                setResult(2, intent);
                finish();//terminando a activity
            }
        });

        // Configurar Adapter
        Adapter adapter = new Adapter(listaPizzas);

        // Configurar RecycleView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        // Eventos de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Pizza filme = listaPizzas.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "NOME: " + filme.getNomePizza(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Pizza filme = listaPizzas.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "VALOR: " + filme.getValorPizza(),
                                        Toast.LENGTH_LONG
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );
    }
}