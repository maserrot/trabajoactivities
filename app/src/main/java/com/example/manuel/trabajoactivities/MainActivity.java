package com.example.manuel.trabajoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.design.widget.TextInputLayout;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextInputLayout tiNombre;
    TextInputLayout titelefono;
    TextInputLayout tiMail;
    DatePicker dtfecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Bundle parametros = getIntent().getExtras();
        //String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        //tiNombre.getEditText().setText(nombre);
        final Button btn = (Button)findViewById(R.id.boton_aceptar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tiNombre = (TextInputLayout)findViewById(R.id.til_nombre);
                titelefono= (TextInputLayout)findViewById(R.id.til_telefono);
                tiMail= (TextInputLayout)findViewById(R.id.til_correo);
                dtfecha= (DatePicker)findViewById(R.id.datePicker);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date dia =getDateFromDatePicker(dtfecha);
                String dateString = sdf.format(dia);
                Intent intent=new Intent(MainActivity.this,segundaActividad.class);
                intent.putExtra(getResources().getString(R.string.pnombre),tiNombre.getEditText().getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono),titelefono.getEditText().getText().toString());
                intent.putExtra(getResources().getString(R.string.pmail),tiMail.getEditText().getText().toString());
                intent.putExtra(getResources().getString(R.string.pfecha),dateString);
                startActivity(intent);
            }
        });

    }
    public static java.util.Date getDateFromDatePicker(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }
}
