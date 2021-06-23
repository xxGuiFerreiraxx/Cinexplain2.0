package com.example.appsorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TelaPrincipal extends AppCompatActivity {

    ImageView menu, filme2, filme3, filme4, filme5, filme6, filme7, filme8, filme9;
    Button filme1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        menu = findViewById(R.id.img_menu);
        menu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipal.this, MenuTela.class);
                startActivity(intent);


            }
        });

        filme1 = findViewById(R.id.btn_filme1);
        filme1.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(TelaPrincipal.this, filme1.class);
            startActivity(intent);

        }
    });

        filme2 = findViewById(R.id.filme2);
        filme2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipal.this, filme2.class);
                startActivity(intent);


            }
        });

        filme3 = findViewById(R.id.filme3);
        filme3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipal.this, filme3.class);
                startActivity(intent);


            }
        });

        filme4 = findViewById(R.id.filme4);
        filme4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipal.this, filme4.class);
                startActivity(intent);


            }
        });

        filme5 = findViewById(R.id.filme5);
        filme5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipal.this, filme5.class);
                startActivity(intent);


            }
        });

        filme6 = findViewById(R.id.filme6);
        filme6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipal.this, filme6.class);
                startActivity(intent);


            }
        });

        filme7 = findViewById(R.id.filme7);
        filme7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipal.this, filme7.class);
                startActivity(intent);


            }
        });

        filme8 = findViewById(R.id.filme8);
        filme8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipal.this, filme8.class);
                startActivity(intent);


            }
        });

        filme9 = findViewById(R.id.filme9);
        filme9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipal.this, filme9.class);
                startActivity(intent);


            }
        });


        }
    }