package com.example.cesarramses.adivinalapelicula;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {
    Button jugar,respuestas, acerca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        jugar=findViewById(R.id.btnJugar);
        respuestas=findViewById(R.id.btnResp);
        acerca=findViewById(R.id.btnAcerca);

        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagina2=new Intent(Inicio.this,Jugar.class);
                startActivity(pagina2);
            }
        });

        respuestas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagina3=new Intent(Inicio.this,Respuestas.class);
                startActivity(pagina3);
            }
        });

        acerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagina4=new Intent(Inicio.this,Acerca.class);
                startActivity(pagina4);
            }
        });
    }
}
