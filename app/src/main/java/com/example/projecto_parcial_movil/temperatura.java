package com.example.projecto_parcial_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;

public class temperatura extends AppCompatActivity implements View.OnClickListener{

    private Button calcularTemp;
    private Button volver2;
    private String nombre = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);
        setContentViewAttribute();
        setContentViewEvents();
        recibirDatos();
    }

    public void recibirDatos(){
        Bundle extras = getIntent().getExtras();
        nombre = extras.getString("nombre");
    }

    private void setContentViewEvents() {
        calcularTemp.setOnClickListener(this);
        volver2.setOnClickListener(this);
    }
    public void setContentViewAttribute(){
        calcularTemp = findViewById(R.id.btnCalTemp);
        volver2 = findViewById(R.id.btnVolver2);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCalTemp:
                calcularTemperatura();
                break;

            case R.id.btnVolver2:
                volverMenu();
                break;
        }
    }

    private void volverMenu(){
        finish();
    }

    private void calcularTemperatura() {

        double valorC;
        double valorF;
        double valorK;

        EditText valorTemp;
        RadioButton rc, rf, rk;
        TextView salidaC, salidaF, salidaK, salidaNombre;

        valorTemp = (EditText) findViewById(R.id.txtValorTemp);
        String valorTemperatura = valorTemp.getText().toString();

        rc = (RadioButton) findViewById(R.id.radioCelsius);
        rf = (RadioButton) findViewById(R.id.radioFahrenheit);
        rk = (RadioButton) findViewById(R.id.radioKelvin);

        boolean isCheckRc = rc.isChecked();
        boolean isCheckRf = rf.isChecked();
        boolean isCheckRk = rk.isChecked();

        salidaC = (TextView) findViewById(R.id.textCel);
        salidaF = (TextView) findViewById(R.id.txtFah);
        salidaK = (TextView) findViewById(R.id.txtCal);
        salidaNombre = (TextView) findViewById(R.id.txtNombre2);

        salidaNombre.setText(nombre);

        if (isCheckRc){

            valorF = (Float.parseFloat(valorTemperatura)*1.8)+32;
            valorK = (Float.parseFloat(valorTemperatura)+273.75);
            salidaC.setText(valorTemperatura);
            salidaF.setText(valorF + ".");
            salidaK.setText(valorK + ".");
        }

        else if (isCheckRf){
            valorC = (Float.parseFloat(valorTemperatura)-32)+1.8;
            valorK = ((5/9)*(Float.parseFloat(valorTemperatura)-32)+273.15);
            salidaC.setText(valorC + ".");
            salidaF.setText(valorTemperatura);
            salidaK.setText(valorK + ".");
        }

        else if (isCheckRk){
            valorC = Float.parseFloat(valorTemperatura)-273.15;
            valorF = 1.8*(Float.parseFloat(valorTemperatura)-273.15)+32;
            salidaC.setText(valorC + ".");
            salidaF.setText(valorF + ".");
            salidaK.setText(valorTemperatura);
        }

    }

}