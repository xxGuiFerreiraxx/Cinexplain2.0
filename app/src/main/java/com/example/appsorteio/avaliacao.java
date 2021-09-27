package com.example.appsorteio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class avaliacao extends AppCompatActivity {

    Button avaliacaoF;
    EditText avaliacao;
    String filename = "";
    String filepath = "";
    String fileContent = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao);

        avaliacao = findViewById(R.id.edtAvaliacao);
        avaliacaoF = findViewById(R.id.btnAvaliacaoFeita);

        filename = "myFile.txt";
        filepath = "MyFileDir";
        if(!isExternalStorageAvailableForRW()){
            avaliacaoF.setEnabled(false);
        }

        avaliacaoF.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (ActivityCompat.checkSelfPermission(avaliacao.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    fileContent = avaliacao.getText().toString().trim();
                    if (!fileContent.equals("")) {
                        File myExternalFile = new File(getExternalFilesDir(filepath), filename);
                        FileOutputStream fos = null;
                        try {
                            fos = new FileOutputStream(myExternalFile);
                            fos.write(fileContent.getBytes());
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        avaliacao.setText("");
                        Toast.makeText(avaliacao.this, "Sua avaliação foi salva no SD card", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(avaliacao.this, "A avaliação não pode ser salva vazia", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    ActivityCompat.requestPermissions(avaliacao.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},44);
                }

            }
        });
    }



    private boolean isExternalStorageAvailableForRW(){
        String extStorageState = Environment.getExternalStorageState();
        if(extStorageState.equals(Environment.MEDIA_MOUNTED)){
            return true;
        }
        return false;
    }
}
