package com.umb.actividad5umb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class termometro extends AppCompatActivity implements SensorEventListener {

    //SE CREAN LAS VARIABLES PRIVADAS
    private TextView textTempView;
    private TextView falloText;
    private SensorManager sensorManager;
    private Sensor tempSensor;
    private Boolean sensorTempDisponible;
    private ProgressBar progressBar;
    private int temperatura =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termometro);


        // EN LOS SIGUIENTES METODOS SE LLAMAN LAS DIFERENTES CAJAS DE TEXTO DEL ACTIVITY TERMOMETRO.XML
        textTempView= findViewById(R.id.textTempView);
        falloText= findViewById(R.id.falloText);
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        progressBar= (ProgressBar) findViewById(R.id.progressBar2);


        //prueba de sensor, SI ESTA ACTIVO O NO, EN CASOD E QUE NO MUESTRA UN MENSAJE DE DISPOSTIVO SIN SENSOR

        if(sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)!=null){
            tempSensor= sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            sensorTempDisponible=true;
            falloText.setVisibility(View.GONE);
        }else{
            falloText.setText("Dispositivo sin sensor de temperatura");
            textTempView.setVisibility(View.GONE);
            sensorTempDisponible=false;
        }
        if(sensorTempDisponible){
            sensorManager.registerListener(this,tempSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }


    }

    //metodo para ir a MENU PRINCIPAL
    public void menu (View view) {
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }
//EN ESTE METODO SE CARGA LA INFORMACION ENVIADA POR EL HARDWARE Y SE CARGA EN LA CAJA DE TEXTO, LO MISMO PARA LA BARRA DE PROGRESO
    @Override
    public void onSensorChanged(SensorEvent event) {
        temperatura= (int) event.values[0];
        textTempView.setText(temperatura+" °C");
        progressBar.setProgress(temperatura);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}