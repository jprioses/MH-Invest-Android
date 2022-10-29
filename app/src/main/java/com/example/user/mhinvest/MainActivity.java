package com.example.user.mhinvest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void formulario_boton(View view) {
        Intent formulario = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(formulario);
    }

    public void historial_boton(View view) {
        Intent historial = new Intent(MainActivity.this,HistorialActivity.class);
        startActivity(historial);
    }
}
