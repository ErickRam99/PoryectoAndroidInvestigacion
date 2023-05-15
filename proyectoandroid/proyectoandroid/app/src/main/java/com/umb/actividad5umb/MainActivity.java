package com.umb.actividad5umb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //metodo para ir a LA ACTIVIDAD DE SENSOR DE TEMPERATURA
    public void Termometro (View view) {
        Intent termometro = new Intent(this, termometro.class);
        startActivity(termometro);













    }
}