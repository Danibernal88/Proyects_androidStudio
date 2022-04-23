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
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button goToIMC;
    private Button goToTemp;
    private Button goToCalc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentViewAttribute();
        setContentViewEvents();
    }

    private void setContentViewEvents() {
        goToIMC.setOnClickListener(this);
        goToTemp.setOnClickListener(this);
        goToCalc.setOnClickListener(this);
    }
    public void setContentViewAttribute(){
        goToIMC = findViewById(R.id.btnGoToImc);
        goToTemp = findViewById(R.id.btnGoToTemperatura);
        goToCalc = findViewById(R.id.btnGoToCalc);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnGoToImc:
                goToIMCAction();
                break;

            case R.id.btnGoToTemperatura:
                goToTempAction();
                break;

            case R.id.btnGoToCalc:
                goToCalcAction();
                break;
        }


    }

    private void goToIMCAction() {
        EditText nombre;
        nombre = (EditText) findViewById(R.id.txtNombre);
        String valorNombre = nombre.getText().toString();

        if (valorNombre.equals("Ingrese Nombre") || valorNombre.equals("") ){
            Toast.makeText(this,"Favor ingrese un nombre valido.", Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent(MainActivity.this,imc.class);
            intent.putExtra("nombre",valorNombre);
            startActivity(intent);
        }

    }

    private void goToTempAction() {

        EditText nombre;
        nombre = (EditText) findViewById(R.id.txtNombre);
        String valorNombre = nombre.getText().toString();

        Intent intent = new Intent(MainActivity.this,temperatura.class);
        intent.putExtra("nombre",valorNombre);
        startActivity(intent);
    }

    private void goToCalcAction() {

        EditText nombre;
        nombre = (EditText) findViewById(R.id.txtNombre);
        String valorNombre = nombre.getText().toString();

        Intent intent = new Intent(MainActivity.this,calculadora.class);
        intent.putExtra("nombre",valorNombre);
        startActivity(intent);
    }




}