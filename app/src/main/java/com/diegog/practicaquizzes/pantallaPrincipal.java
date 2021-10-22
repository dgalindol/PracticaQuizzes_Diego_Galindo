package com.diegog.practicaquizzes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class pantallaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        Button botonEmpezar = findViewById(R.id.buttonSe);
        TextView titulo = findViewById(R.id.tvTextoPrincipal);

        Bundle extras = getIntent().getExtras();

        int numero = extras.getInt("taBien");

        if (numero == 0){
            titulo.setText(getString(R.string.respuestaFallida));
            botonEmpezar.setText(getString(R.string.botonReintentar));
        } else if (numero == 1){
            titulo.setText(getString(R.string.respuestaCorrecta));
            botonEmpezar.setText(getString(R.string.botonSiguiente));
        } else if (numero == 2){
            titulo.setText(getString(R.string.respuestaFinal));
            botonEmpezar.setText(getString(R.string.botonAcabar));
            MainActivity.pregunta = 1;
        }
        botonEmpezar.setOnClickListener(v -> {
            finish();
        });
    }


}