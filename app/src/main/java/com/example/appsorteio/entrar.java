package com.example.appsorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

public class entrar extends AppCompatActivity {

    private Button salvar;
    private EditText edUserName, edSenha;
    private static final String FILE_NAME="example.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar);

        edSenha = findViewById(R.id.edtSenha);
        edUserName = findViewById(R.id.edtUserName);

    }

    public void salvar(View v) {
        String text = edUserName.getText().toString();
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());

            edUserName.getText().clear();
            Toast.makeText(this, "UserName e senha cadastrados com sucesso na MEMÓRIA INTERNA!!!" ,
                    Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Intent intent = new Intent(entrar.this,TelaPrincipal.class);
        startActivity(intent);
    }


}
