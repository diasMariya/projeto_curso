package com.mariaeduarda.projetocurso.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mariaeduarda.projetocurso.R;
import com.mariaeduarda.projetocurso.model.Pessoa;


public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    EditText Curso;
    EditText Sobrenome;
    EditText PrimeiroNome;
    EditText Telefone;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;


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
        pessoa = new Pessoa();

        pessoa.setPrimeiroNome("Maria Eduarda");
        pessoa.setSobrenome("Dos Santos");
        pessoa.setCursoDesejado("JavaScrip");
        pessoa.setTelefone("000000000");

        PrimeiroNome = findViewById(R.id.editPrimeiroNome);
        Sobrenome = findViewById(R.id.editSobrenome);
        Telefone = findViewById(R.id.editTelefone);
        Curso = findViewById(R.id.editCurso);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        PrimeiroNome.setText(pessoa.getPrimeiroNome());
        Sobrenome.setText(pessoa.getSobrenome());
        Telefone.setText(pessoa.getTelefone());
        Curso.setText(pessoa.getCursoDesejado());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrimeiroNome.setText(" ");
                Sobrenome.setText(" ");
                Telefone.setText(" ");
                Curso.setText(" ");
            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(PrimeiroNome.getText().toString());
                pessoa.setSobrenome(Sobrenome.getText().toString());
                pessoa.setTelefone(Telefone.getText().toString());
                pessoa.setCursoDesejado(Curso.getText().toString());

                Toast.makeText(MainActivity.this, "Dados salvos: " + pessoa.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}