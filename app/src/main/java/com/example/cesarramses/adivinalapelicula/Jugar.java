package com.example.cesarramses.adivinalapelicula;

import android.media.Image;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Jugar extends AppCompatActivity {
    TextView puntos, contador, vidas, Correcto, Incorrecto;
    ImageView imagen;
    EditText nombre;
    Button Ok;

    int intpunto=0;
    int intvidas=3;
    int numGenerado=0;

    String [] nombre_peli={"alicia en el pais de las maravillas","aladdin","el rey leon","la bella y la bestia","lilo y stitch","bambi","piratas del caribe","batman","eso","harry potter","escuadron suicida","avatar","saw","los 4 fantasticos","el joven manos de tijera"};
    String [] imagen_peli={"img1","img2","img3","img4","img5","img6","img7","img8","img9","img10","img11","img12","img13","img14","img15"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        Correcto=findViewById(R.id.txtCorrecto);
        Incorrecto=findViewById(R.id.txtmal);
        puntos=findViewById(R.id.Puntos);
        contador=findViewById(R.id.Cuenta);
        vidas=findViewById(R.id.Vidas);
        imagen=findViewById(R.id.Imagen);
        nombre=findViewById(R.id.lblNomb);
        Ok=findViewById(R.id.btnOk);

        establecer_imagen(numGenerado);

        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textOk=nombre.getText().toString().toLowerCase();
                if (textOk.equals(nombre_peli[numGenerado])){
                    Correcto.setVisibility(View.VISIBLE);
                    intpunto=intpunto+5;
                    puntos.setText("Puntos: "+intpunto);
                    esperar();
                }
                else {
                    Incorrecto.setVisibility(View.VISIBLE);
                    intvidas=intvidas-1;
                    vidas.setText("Vidas: "+intvidas);
                    esperar2();

                }
            }
        });
    }

    void esperar2(){
        new CountDownTimer(3000,1) {
            @Override
            public void onTick(long millisUntilFinished) {

                Ok.setVisibility(View.GONE);

            }

            @Override
            public void onFinish() {
                Ok.setVisibility(View.VISIBLE);
                Incorrecto.setVisibility(View.INVISIBLE);
                nombre.setText("");
                nombre.setHint("Nombre de la pelicula");
            }
        }.start();
    }

    void esperar(){
        new CountDownTimer(3000, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                contador.setText(""+(millisUntilFinished/1000+1));
                Ok.setVisibility(View.GONE);

            }

            @Override
            public void onFinish() {
                Ok.setVisibility(View.VISIBLE);
                numGenerado=numGenerado+1;
                contador.setText("");
                establecer_imagen(numGenerado);
                Correcto.setVisibility(View.INVISIBLE);
                nombre.setText("");
                nombre.setHint("Nombre de la pelicula");

            }
        }.start();
    }
    void establecer_imagen(int numero){
        int id=getResources().getIdentifier(imagen_peli[numero],"mipmap",getPackageName());
        imagen.setImageResource(id);
    }
}
