package com.example.projcalculaidade;


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


import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;


public class MainActivity extends AppCompatActivity {

    private EditText txtdtNascimento;
    private TextView txtsIdade;
    private TextView txtsIdadeCompleta;

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

        txtdtNascimento = findViewById(R.id.txtdtNascimento);
        txtdtNascimento.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        txtsIdade = findViewById(R.id.txtsIdade);
        txtsIdadeCompleta = findViewById(R.id.txtsIdadeCompleta);

        Button btnDescobrir = findViewById(R.id.btnDescobrir);
        btnDescobrir.setOnClickListener(op -> Descobrir());
    }

    private void Descobrir ()
    {
        String sData = txtdtNascimento.getText().toString();

        LocalDate dtNascimento = LocalDate.parse(sData);
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dtNascimento, dataAtual);
        int dia = periodo.getDays();
        int mes = periodo.getMonths();
        int ano = periodo.getYears();

        long diaCompleto = ChronoUnit.DAYS.between(dtNascimento,dataAtual);
        long mesCompleto = ChronoUnit.MONTHS.between(dtNascimento,dataAtual);
        long anoCompleto = ChronoUnit.YEARS.between(dtNascimento,dataAtual);

        String msg = getString(R.string.sIdade) + " " + ano + " anos, " + mes + " mese(s), " + dia + " dias.";
        String msgCompleta = getString(R.string.sIdadeCompleta) + " " + anoCompleto + " em anos, " + mesCompleto + " em meses, " + diaCompleto + " em dias.";
        txtsIdade.setText(msg);
        txtsIdadeCompleta.setText(msgCompleta);








    }
}