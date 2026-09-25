package com.example.taller_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    private Button botonRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (vista, margenes) -> {
            Insets barrasSistema = margenes.getInsets(WindowInsetsCompat.Type.systemBars());
            vista.setPadding(barrasSistema.left, barrasSistema.top, barrasSistema.right, barrasSistema.bottom);
            return margenes;
        });

        // 1. Recepción y lectura de los datos enviados desde FirstActivity
        Bundle datosRecibidos = getIntent().getExtras();
        if (datosRecibidos != null) {
            String primerTexto = datosRecibidos.getString("DatoUno");
            String segundoTexto = datosRecibidos.getString("DatoDos");

            // Mostrar los datos en pantalla con una notificación Toast
            Toast.makeText(getApplicationContext(),
                    "Datos recibidos:\n• " + primerTexto + "\n• " + segundoTexto,
                    Toast.LENGTH_LONG).show();
        }

        // 2. Conexión del botón con el ID del diseño XML
        botonRegresar = findViewById(R.id.btnRegresarAFirst);
        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retorno = new Intent(SecondActivity.this, FirstActivity.class);
                startActivity(retorno);
                finish(); // Cierra esta pantalla para no acumularla en el historial
            }
        });
    }
}