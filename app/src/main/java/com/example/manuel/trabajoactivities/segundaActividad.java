package com.example.manuel.trabajoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class segundaActividad extends AppCompatActivity {
    android.support.v7.widget.AppCompatTextView tvNom;
    android.support.v7.widget.AppCompatTextView tvtel;
    android.support.v7.widget.AppCompatTextView tvmail;
    android.support.v7.widget.AppCompatTextView tvfecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);
        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String mail = parametros.getString(getResources().getString(R.string.pmail));
        String fecha = parametros.getString(getResources().getString(R.string.pfecha));
        tvNom= (android.support.v7.widget.AppCompatTextView)findViewById(R.id.tvNombre);
        tvtel= (android.support.v7.widget.AppCompatTextView)findViewById(R.id.tvTelefono);
        tvmail= (android.support.v7.widget.AppCompatTextView)findViewById(R.id.tvMail);
        tvfecha= (android.support.v7.widget.AppCompatTextView)findViewById(R.id.tvFecha);
        tvNom.setText(nombre);
        tvtel.setText(telefono);
        tvmail.setText(mail);
        tvfecha.setText(fecha);
        final Button btn = (Button)findViewById(R.id.boton_edicion);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                //Intent intent=new Intent(segundaActividad.this,MainActivity.class);
                //intent.putExtra(getResources().getString(R.string.pnombre),tvNom.getText().toString());
                //startActivity(intent);
            }
        });
    }
}
