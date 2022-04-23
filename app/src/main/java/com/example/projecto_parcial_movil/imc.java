package com.example.projecto_parcial_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import models.IMC_MODEL;

public class imc extends AppCompatActivity implements View.OnClickListener{

    private Button calcIMC;
    private Button volver;
    private String nombre = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        setContentViewAttribute();
        setContentViewEvents();
        recibirDatos();
    }

    public void recibirDatos(){
        Bundle extras = getIntent().getExtras();
        nombre = extras.getString("nombre");
    }

    private void setContentViewEvents() {
        volver.setOnClickListener(this);
        calcIMC.setOnClickListener(this);
    }
    public void setContentViewAttribute(){
        volver = findViewById(R.id.btnVolver);
        calcIMC = findViewById(R.id.btnCalcIMC);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCalcIMC:
                calcIMC();
                break;

            case R.id.btnVolver:
                volverMenu();
                break;
        }

    }

    private void calcIMC() {

        EditText altura;
        EditText peso;
        TextView salidaMensaje;

        altura = (EditText) findViewById(R.id.txtAltura);
        peso = (EditText) findViewById(R.id.txtPeso);
        salidaMensaje = (TextView) findViewById(R.id.txtViewIMC);

        String valorAltura = altura.getText().toString();
        String valorpeso = peso.getText().toString();
        String estado = "";

        IMC_MODEL instIMC = new IMC_MODEL(Float.parseFloat(valorAltura),Float.parseFloat(valorpeso));
        float imc = instIMC.calcularIMC(instIMC.getAltura(),instIMC.getPeso());

        if (imc >= 18.5 && imc <=24.9){
            estado = "Normal";
        }
        else if (imc >= 25 && imc <=29.9){
            estado = "Sobrepeso";
        }
        else if (imc >= 30 && imc <=34.9){
            estado = "Obesidad grado I";
        }
        else if (imc >= 5 && imc <=39.9){
            estado = "Obesidad grado II";
        }
        else if (imc >= 40){
            estado = "Obesidad grado III";
        }

        DecimalFormat df = new DecimalFormat("#.00");

        salidaMensaje.setText("Hola " +  nombre + "\nEl IMC es: "+ df.format(imc) + ", su condición es: " + estado);

    }

    private void volverMenu(){
        finish();
    }


}