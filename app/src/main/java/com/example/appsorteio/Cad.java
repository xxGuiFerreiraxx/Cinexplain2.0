package com.example.appsorteio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Cad extends AppCompatActivity {

    private String email,nome;
    private EditText edemail, ednome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad);



         ednome = (EditText) findViewById(R.id.edtNome);
         edemail = (EditText) findViewById(R.id.edtEmail);


        Button gravar = (Button) findViewById(R.id.btnGravar);
        gravar.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
                SharedPreferences prefs= getSharedPreferences("preferencias" , Context.MODE_PRIVATE);

                SharedPreferences.Editor ed = prefs.edit();

                ed.putString("nome", ednome.getText().toString());
                ed.putString("email", edemail.getText().toString());

                ed.apply();
                Toast.makeText(getBaseContext(),"Gravado com sucesso",
                        Toast.LENGTH_SHORT).show();

                String uriText = null;
                try {
                    uriText = "mailto:"+"cinexplain@gmail.com"+
                            "?subject="+ URLEncoder.encode("Cinexplain:Sugestão","utf-8")+
                            "&body="+URLEncoder.encode("A minha sugestão é:","utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                Uri uri=Uri.parse(uriText);

                Intent it=new Intent(Intent.ACTION_SENDTO);
                it.setData(uri);
                startActivity(Intent.createChooser(it,"Enviar Email"));
            }
        });

        Button limpar = (Button) findViewById(R.id.btnLimpar);
        limpar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ednome.setText("");
                edemail.setText("");
            }
        });

        Button recuperar = (Button) findViewById(R.id.btnRecuperar);
        recuperar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                SharedPreferences prefs= getSharedPreferences("preferencias" , Context.MODE_PRIVATE);

                ednome.setText(prefs.getString("nome","não encontrado"));
                edemail.setText(prefs.getString("email","não encontrado"));

            }
        });

    }



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);

        email = edemail.getText().toString();
        outState.putString("Email",email);

        nome = ednome.getText().toString();
        outState.putString("Nome",nome);

    }


}