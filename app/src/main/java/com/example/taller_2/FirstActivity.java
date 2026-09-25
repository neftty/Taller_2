package com.example.taller_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FirstActivity extends AppCompatActivity {

    private Button botonEnviar;
    private Button botonVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (vista, margenes) -> {
            Insets barrasSistema = margenes.getInsets(WindowInsetsCompat.Type.systemBars());
            vista.setPadding(barrasSistema.left, barrasSistema.top, barrasSistema.right, barrasSistema.bottom);
            return margenes;
        });

        botonEnviar = findViewById(R.id.btnEnviarASegunda);
        botonVolver = findViewById(R.id.btnRegresarInicio);

        // 1. Enviar datos a SecondActivity mediante Intent Explícito
        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentoSegunda = new Intent(FirstActivity.this, SecondActivity.class);
                intentoSegunda.putExtra("DatoUno", "Desarrollo Móvil Android");
                intentoSegunda.putExtra("DatoDos", "Demostración de Intent Explícito");
                startActivity(intentoSegunda);
            }
        });

        // 2. Regresar a la pantalla principal
        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentoRegreso = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(intentoRegreso);
                finish();
            }
        });
    }
}