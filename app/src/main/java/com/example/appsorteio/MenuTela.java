/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.appsorteio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.SensorEventListener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MenuTela extends AppCompatActivity {

    Button mapa, voltar_tela_principal, sair, cad, aval;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tela);

        aval = findViewById(R.id.btn_avaliacao);
        aval.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuTela.this, avaliacao.class);
                startActivity(intent);


            }
        });
        mapa = findViewById(R.id.btn_mapa);
        mapa.setOnClickListener( new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(MenuTela.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    getLocalizacao();
                }
                else{
                    ActivityCompat.requestPermissions(MenuTela.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},44);
                }
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

        cad = findViewById(R.id.btn_cad);
        cad.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MenuTela.this, Cad.class);
                startActivity(intent);
            }
        });

        }

        private void getLocalizacao(){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/cinemas/@-23.4857091,-46.7837878,13z/data=!3m1!4b1")));

        }


    }