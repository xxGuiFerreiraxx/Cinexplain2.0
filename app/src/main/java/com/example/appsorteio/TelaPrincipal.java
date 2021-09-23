package com.example.appsorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import static android.hardware.Sensor.TYPE_LIGHT;

public class TelaPrincipal extends AppCompatActivity implements SensorEventListener {

    ImageView menu, filme2, filme3, filme4, filme5, filme6, filme7, filme8, filme9;
    Button filme1;
    private SensorManager sensorManager;
    private Sensor sensorLum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorLum = sensorManager.getDefaultSensor(TYPE_LIGHT);
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

    //sensor

    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(this,sensorLum, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        if(event.sensor.getType() == Sensor.TYPE_LIGHT){
            if(permissaoControlarBrilho()){
                int brilho = (int)(event.values[0]);
                controlarBrilho(brilho);
            }
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }

    private boolean permissaoControlarBrilho(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(Settings.System.canWrite(this)){
                return true;
            }
            else{
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData((Uri.parse("package:" + getApplication().getPackageName())));
                startActivity(intent);
                return false;
            }
        }
        return false;
    }

    private void controlarBrilho(int brilho){
        if(brilho < 0){
            brilho = 0;
        }
        else if(brilho > 255)
        {
            brilho = 255;
        }

        ContentResolver contentResolver = getApplicationContext().getContentResolver();
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, brilho);
    }


}



