package com.example.appsorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MenuTela extends AppCompatActivity {

    Button mapa, voltar_tela_principal, sair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tela);

        mapa = findViewById(R.id.btn_mapa);
        mapa.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/cinemas/@-23.4857091,-46.7837878,13z/data=!3m1!4b1")));


            }
        });

        voltar_tela_principal = findViewById(R.id.btn_voltar_tela_principal);
        voltar_tela_principal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuTela.this, TelaPrincipal.class);
                startActivity(intent);


            }
        });

        sair = findViewById(R.id.btn_sair);
        sair.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        }
    }