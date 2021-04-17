package com.example1.androidpizzaria.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example1.androidpizzaria.R;
import com.example1.androidpizzaria.activity.Adapter.Adapter;
import com.example1.androidpizzaria.activity.model.Pizza;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    List<Pizza> arrayPizzas = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView codigoPizza = (TextView) findViewById(R.id.txtCodigoPizza);
        TextView nomePizza = (TextView) findViewById(R.id.txtNomePizza);
        TextView ingredientesPizza = (TextView) findViewById(R.id.txtIngredientesPizza);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        TextView valorPizza = (TextView) findViewById(R.id.txtValorPizza);

        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        Button btnLimpar = (Button) findViewById(R.id.btnLimpar);
        Button btnRelatorio = (Button) findViewById(R.id.btnRelatorio);

        ListView listaPizza = new ListView(this);
        ArrayList<Pizza> arrayOfPizzas = new ArrayList<Pizza>();
        Adapter adapter = new Adapter(this, arrayOfPizzas);
        listaPizza.setAdapter(adapter);

        // Evento para Limpar os campos
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codigoPizza.setText(null);
                nomePizza.setText(null);
                ingredientesPizza.setText(null);
                radioGroup.clearCheck();
                valorPizza.setText(null);

                abrirToast("O formulário foi limpo!");
            }
        });


        // Regra para nova nota de aluno
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Validar campos

                String radiovalue = ((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
                // Add item to adapter
                Pizza newPizza = new Pizza(
                        codigoPizza.getText().toString(),
                        nomePizza.getText().toString(),
                        ingredientesPizza.getText().toString(),
                        radiovalue,
                        valorPizza.getText().toString()
                );


                arrayPizzas.add(newPizza);

                adapter.clear();
                for (Pizza a : arrayPizzas) {
                    adapter.add(a);
                }
                abrirToast("Pizza Cadastrada!");
            }
        });

        // Botão para ir para outra tele de dados
        btnRelatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TESTE", " Entrou aqui Primeiro: " + arrayPizzas.size());
                Intent intent = new Intent(MainActivity.this, DataActivity.class);
                Bundle params = new Bundle();
                params.putParcelableArrayList("array", (ArrayList<? extends Parcelable>) arrayPizzas);
                intent.putExtras(params);
                startActivityForResult(intent, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Verifica se o requestCode recebido é o mesmo que o enviado
        if (requestCode == 2) {
            //Testa o retorno da activity
        }
    }

    // Criação do Toast (Mensagem)
    private void abrirToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }
}
