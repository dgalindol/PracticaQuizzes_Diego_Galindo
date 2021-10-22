package com.diegog.practicaquizzes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static Integer pregunta = 1;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView numPregunta = findViewById(R.id.tvNumPregunta);
        TextView enunciado = findViewById(R.id.tvPregunta);
        RadioButton respuesta1 = findViewById(R.id.rbRespuesta1);
        RadioButton respuesta2 = findViewById(R.id.rbRespuesta2);
        Button botonSiguiente = findViewById(R.id.btnValidar);

        numPregunta.setText(pregunta.toString() + getString(R.string.numPregunta));

        Enunciar(pregunta);


        botonSiguiente.setOnClickListener( i -> {

            Intent intent = new Intent(this, pantallaPrincipal.class);



            if (pregunta == 1){


                if (respuesta1.isChecked()){

                    intent.putExtra("taBien", 1);

                    startActivity(intent);

                    pregunta++;

                    Enunciar(pregunta);


                } else if (respuesta2.isChecked()){

                    intent.putExtra("taBien", 0);

                    startActivity(intent);

                } else {
                    Toast.makeText(this, "No has seleccionado ninguna respuesta", Toast.LENGTH_SHORT).show();
                }

                ;

            } else if (pregunta == 2){


                if (respuesta1.isChecked()){

                    intent.putExtra("taBien", 1);

                    startActivity(intent);

                    pregunta++;

                    Enunciar(pregunta);

                } else if (respuesta2.isChecked()){

                    intent.putExtra("taBien", 0);

                    startActivity(intent);

                } else {
                    Toast.makeText(this, "No has seleccionado ninguna respuesta", Toast.LENGTH_SHORT).show();
                }
                ;


            } else if (pregunta == 3){

                if (respuesta1.isChecked()){

                    intent.putExtra("taBien", 0);

                    startActivity(intent);

                } else if (respuesta2.isChecked()){

                    intent.putExtra("taBien", 2);

                    pregunta =1;

                    Enunciar(pregunta);

                    startActivity(intent);



                } else {
                    Toast.makeText(this, "No has seleccionado ninguna respuesta", Toast.LENGTH_SHORT).show();
                }


            }

        });
    }

    public void Enunciar(Integer a){

        TextView numPregunta = findViewById(R.id.tvNumPregunta);
        TextView enunciado = findViewById(R.id.tvPregunta);
        RadioButton respuesta1 = findViewById(R.id.rbRespuesta1);
        RadioButton respuesta2 = findViewById(R.id.rbRespuesta2);

        if (a == 1){

            enunciado.setText(getString(R.string.enunciado1));
            respuesta1.setText(getString(R.string.respuesta1pregunta1));
            respuesta2.setText(getString(R.string.respuesta2pregunta1));
            numPregunta.setText(a.toString() + getString(R.string.numPregunta));
        } else if (a == 2){
            enunciado.setText(getString(R.string.enunciado2));
            respuesta1.setText(getString(R.string.respuesta1pregunta2));
            respuesta2.setText(getString(R.string.respuesta2pregunta2));
            numPregunta.setText(a.toString() + getString(R.string.numPregunta));

        } else if ( a == 3){
            enunciado.setText(getString(R.string.enunciado3));
            respuesta1.setText(getString(R.string.respuesta2pregunta3));
            respuesta2.setText(getString(R.string.respuesta1pregunta3));
            numPregunta.setText(a.toString() + getString(R.string.numPregunta));
        }
    }

}