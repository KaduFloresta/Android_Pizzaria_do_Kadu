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
import android.widget.ListView;
import android.widget.Toast;


import com.example1.androidpizzaria.R;
import com.example1.androidpizzaria.activity.Adapter.Adapter;
import com.example1.androidpizzaria.activity.RecyclerItemClickListener;
import com.example1.androidpizzaria.activity.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        ListView listaPizza = (ListView) findViewById(R.id.listaPizza);
        Button btnVoltar = (Button) findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                setResult(2, intent);
                finish();//terminando a activity
            }
        });

        Bundle args = getIntent().getExtras();
        ArrayList<Pizza> arrayOfPizzas = (ArrayList<Pizza>) args.getSerializable("array");
        Log.i("TESTE", this.getLocalClassName() + " Entrou aqui: " + arrayOfPizzas.size());

        Adapter adapter = new Adapter(this, arrayOfPizzas);
        listaPizza.setAdapter(adapter);

        // Adicionar o clique na lista
        listaPizza.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String valorSelecionado = listaPizza.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), valorSelecionado, Toast.LENGTH_LONG).show();
            }
        });
    }
}