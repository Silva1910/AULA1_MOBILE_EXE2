package com.fatec.zl.amos.appfirst;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etA;
    private EditText etB;
    private EditText etC;

    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        etA = findViewById(R.id.etA);
        etA.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etB = findViewById(R.id.etB);
        etB.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etC = findViewById(R.id.etC);
        etC.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button  btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(op -> calc());


    }

    private void calc(){
        float a = Float.parseFloat(etA.getText().toString());
        float b = Float.parseFloat(etB.getText().toString());
        float c = Float.parseFloat(etC.getText().toString());


        float delta = b * b - 4 * a * c;


        if (a == 0) {
            tvRes.setText("Não é uma equação de segundo grau");
        } else {
            if (delta < 0) {
                tvRes.setText("A equação não possui raízes reais");
            } else {

                float x1 = (-b + (float)Math.sqrt(delta)) / (2 * a);
                float x2 = (-b - (float)Math.sqrt(delta)) / (2 * a);


                String res = "Δ = " + delta + "\n";
                res += "x1 = " + x1 + "\n";
                res += "x2 = " + x2;
                tvRes.setText(res);
            }
        }

        // Limpando os campos de entrada
        etA.setText("");
        etB.setText("");
        etC.setText("");
    }


}